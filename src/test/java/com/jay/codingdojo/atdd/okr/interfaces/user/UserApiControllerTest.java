package com.jay.codingdojo.atdd.okr.interfaces.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.service.LoginInfo;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserService;

@ExtendWith(MockitoExtension.class)
class UserApiControllerTest {

	@Mock
	private UserService userService;

	@BeforeEach
	void setUp() {
		BDDMockito.given(userService.loginWithIdToken(ProviderType.GOOGLE, "idToken"))
			.willReturn(new LoginInfo(
				"guest_fewfewa3",
				"test@email.com",
				"testUser",
				ProviderType.GOOGLE,
				null,
				null)
			);
	}

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