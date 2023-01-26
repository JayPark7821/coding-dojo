package com.jay.codingdojo.atdd.okr.domain.user.service.impl;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.service.LoginInfo;

class UserServiceImplTest {

	@Test
	@DisplayName("가입한 유저 정보가 없을 때  idToken을 통해 로그인을 시도하면 기대하는 응답(Guest)을 반환한다.")
	void login_With_IdToken_when_before_join() throws Exception {

		final UserServiceImpl sut = new UserServiceImpl();

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