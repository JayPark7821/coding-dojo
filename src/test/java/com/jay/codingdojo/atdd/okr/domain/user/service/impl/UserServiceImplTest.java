package com.jay.codingdojo.atdd.okr.domain.user.service.impl;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.service.LoginInfo;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.GoogleTokenVerifier;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.OAuth2UserInfo;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
@Import(UserServiceImpl.class)
class UserServiceImplTest {

	@MockBean // InjectMocks
	private GoogleTokenVerifier googleTokenVerifier;

	@Autowired
	private UserServiceImpl sut;

	@Test
	@DisplayName("가입한 유저 정보가 없을 때  idToken을 통해 로그인을 시도하면 기대하는 응답(Guest)을 반환한다.")
	void login_With_IdToken_when_before_join() throws Exception {

		String userId = "testId";
		String guestName = "testUser";
		String guestEmail = "test@email.com";
		ProviderType provider = ProviderType.GOOGLE;

		stubGoogleTokenVerifier(userId, guestName, guestEmail);

		LoginInfo info = sut.loginWithIdToken(provider, "idToken");

		assertGuest(guestName, guestEmail, info);

	}

	@Test
	@DisplayName("회원 가입을 완료하지 않고 어플리케이션을 종료한 경우 idToken을 통해 로그인을 시도하면 새로운 응답(Guest)을 반환한다.")
	void login_With_IdToken_when_temp_user() throws Exception {

		String userId = "testId";
		String guestName = "testUser";
		String guestEmail = "test@email.com";
		ProviderType provider = ProviderType.GOOGLE;
		stubGoogleTokenVerifier(userId, guestName, guestEmail);

		LoginInfo info = sut.loginWithIdToken(provider, "idToken");

		assertGuest(guestName, guestEmail, info);

	}


	private void stubGoogleTokenVerifier(String userId, String guestName, String guestEmail) {
		String guestPicture = "pic";

		given(googleTokenVerifier.varifyIdToken("idToken"))
			.willReturn(new OAuth2UserInfo(userId, guestName, guestEmail, guestPicture));
	}

	private void assertGuest(String guestName, String guestEmail, LoginInfo info) {
		assertThat(info.email()).isEqualTo(guestEmail);
		assertThat(info.name()).isEqualTo(guestName);
		assertThat(info.accessToken()).isNull();
		assertThat(info.refreshToken()).isNull();
	}

}