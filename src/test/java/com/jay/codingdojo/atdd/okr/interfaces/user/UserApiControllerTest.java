package com.jay.codingdojo.atdd.okr.interfaces.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserService;

class UserApiControllerTest {

	private UserService userService;

	@Test
	@DisplayName("가입한 유저 정보가 없을 때  idToken을 통해 로그인을 시도하면 기대하는 응답(Guest)을 반환한다.")
	void login_With_IdToken_when_before_join() throws Exception {
		final UserApiController sut = new UserApiController(userService);

		LoginResponse response = sut.loginWithIdToken("GOOGLE", "idToken");

		Assertions.assertThat(response).isEqualTo(new LoginResponse(
			"guest_fewfewa3",
			"test@email.com",
			"testUser",
			ProviderType.GOOGLE,
			null,
			null));
	}
}