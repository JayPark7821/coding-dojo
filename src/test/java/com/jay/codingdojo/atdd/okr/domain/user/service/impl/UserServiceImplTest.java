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
		Guest guest = Guest.builder()
			.guestId("testId")
			.guestUuid("guest_fewfewa3")
			.guestName("testUser")
			.email("test@email.com")
			.providerType(ProviderType.GOOGLE)
			.profileImage("pic")
			.build();

		given(googleTokenVerifier.varifyIdToken("idToken"))
			.willReturn(new OAuth2UserInfo("testId", "testUser", "test@email.com", "pic"));

		given(userRepository.findByEmail("test@email.com"))
			.willReturn(Optional.empty());

		given(guestRepository.findByGuestId("testId"))
			.willReturn(Optional.empty());

		given(guestRepository.save(any(Guest.class)))
			.willReturn(guest);

		LoginInfo info = sut.loginWithIdToken(ProviderType.GOOGLE, "idToken");

		assertThat(info).isEqualTo(
			new LoginInfo(
				"guest_fewfewa3",
				"test@email.com",
				"testUser",
				ProviderType.GOOGLE,
				null,
				null
			)
		);
	}
}