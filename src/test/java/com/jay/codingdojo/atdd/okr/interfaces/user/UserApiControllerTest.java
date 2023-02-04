package com.jay.codingdojo.atdd.okr.interfaces.user;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;

import com.jay.codingdojo.atdd.carracing.web.CarRacingController;
import com.jay.codingdojo.atdd.okr.FakeTokenVerifier;
import com.jay.codingdojo.atdd.okr.TestConfig;
import com.jay.codingdojo.atdd.okr.application.user.UserFacade;
import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.application.user.LoginInfo;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.GoogleTokenVerifier;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.OAuth2UserInfo;

@Import(TestConfig.class)
@SpringBootTest
class UserApiControllerTest {


	@Autowired
	private UserApiController sut;

	@Test
	@DisplayName("가입한 유저 정보가 없을 때  idToken을 통해 로그인을 시도하면 기대하는 응답(Guest)을 반환한다.")
	void login_With_IdToken_when_before_join() throws Exception {

		ResponseEntity<LoginResponse> response = sut.loginWithIdToken("GOOGLE", "idToken");

		assertThat(response.getStatusCodeValue()).isEqualTo(201);
		assertLoginResponse(response.getBody());
	}

	private static void assertLoginResponse(LoginResponse body) {
		assertThat(body.guestId()).containsPattern(
			Pattern.compile("guest-[a-zA-Z0-9]{14}")
		);
		assertThat(body.name()).isEqualTo(FakeTokenVerifier.name);
		assertThat(body.email()).isEqualTo(FakeTokenVerifier.email);
		assertThat(body.providerType()).isEqualTo(FakeTokenVerifier.provider);
		assertThat(body.accessToken()).isNull();
		assertThat(body.refreshToken()).isNull();
	}

}