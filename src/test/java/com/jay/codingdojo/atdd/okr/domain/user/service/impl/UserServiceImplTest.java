package com.jay.codingdojo.atdd.okr.domain.user.service.impl;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.BDDMockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jay.codingdojo.atdd.okr.domain.guest.Guest;
import com.jay.codingdojo.atdd.okr.domain.guest.GuestRepository;
import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.UserRepository;
import com.jay.codingdojo.atdd.okr.domain.user.service.LoginInfo;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.GoogleTokenVerifier;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.OAuth2UserInfo;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	@Mock
	private GoogleTokenVerifier googleTokenVerifier;

	@Mock
	private GuestRepository guestRepository;

	@Mock
	private UserRepository userRepository;

	private UserServiceImpl sut;

	@BeforeEach
	void setUp() {
		sut = new UserServiceImpl(googleTokenVerifier, userRepository, guestRepository);
	}

	@Test
	@DisplayName("가입한 유저 정보가 없을 때  idToken을 통해 로그인을 시도하면 기대하는 응답(Guest)을 반환한다.")
	void login_With_IdToken_when_before_join() throws Exception {

		String userId = "testId";
		String guestUuid = "guest_fewfewa3";
		String guestName = "testUser";
		String guestEmail = "test@email.com";
		ProviderType provider = ProviderType.GOOGLE;
		String guestPicture = "pic";

		Guest guest = Guest.builder()
			.guestId(userId)
			.guestUuid(guestUuid)
			.guestName(guestName)
			.email(guestEmail)
			.providerType(provider)
			.profileImage(guestPicture)
			.build();

		given(googleTokenVerifier.varifyIdToken("idToken"))
			.willReturn(new OAuth2UserInfo(userId, guestName, guestEmail, guestPicture));

		given(userRepository.findByEmail(guestEmail))
			.willReturn(Optional.empty());

		given(guestRepository.findByGuestId(userId))
			.willReturn(Optional.empty());

		given(guestRepository.save(any(Guest.class)))
			.willReturn(guest);

		LoginInfo info = sut.loginWithIdToken(provider, "idToken");

		assertThat(info).isEqualTo(
			new LoginInfo(
				guestUuid,
				guestEmail,
				guestName,
				provider,
				null,
				null
			)
		);
	}

	@Test
	@DisplayName("회원 가입을 완료하지 않고 어플리케이션을 종료한 경우 idToken을 통해 로그인을 시도하면 새로운 응답(Guest)을 반환한다.")
	void login_With_IdToken_when_temp_user() throws Exception {

		String userId = "testId";
		String guestUuid = "guest_fewfewa3";
		String guestName = "testUser";
		String guestEmail = "test@email.com";
		ProviderType provider = ProviderType.GOOGLE;
		String guestPicture = "pic";

		Guest guest = Guest.builder()
			.guestId(userId)
			.guestUuid(guestUuid)
			.guestName(guestName)
			.email(guestEmail)
			.providerType(provider)
			.profileImage(guestPicture)
			.build();

		given(googleTokenVerifier.varifyIdToken("idToken"))
			.willReturn(new OAuth2UserInfo(userId, guestName, guestEmail, guestPicture));

		given(userRepository.findByEmail(guestEmail))
			.willReturn(Optional.empty());

		given(guestRepository.findByGuestId(userId))
			.willReturn(Optional.of(mock(Guest.class)));
		
		given(guestRepository.save(any(Guest.class)))
			.willReturn(guest);

		LoginInfo info = sut.loginWithIdToken(provider, "idToken");

		assertThat(info).isEqualTo(
			new LoginInfo(
				guestUuid,
				guestEmail,
				guestName,
				provider,
				null,
				null
			)
		);
	}
}