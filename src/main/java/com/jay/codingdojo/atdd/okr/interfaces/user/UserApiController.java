package com.jay.codingdojo.atdd.okr.interfaces.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jay.codingdojo.atdd.okr.application.user.UserFacade;
import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.application.user.LoginInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserApiController {

	private final UserFacade UserFacade;

	@PostMapping("/login/{provider}/{idToken}")
	ResponseEntity<LoginResponse> loginWithIdToken(
		@PathVariable("provider") String provider,
		@PathVariable("idToken") String idToken
	) {
		LoginInfo loginInfo = UserFacade.loginWithIdToken(ProviderType.valueOf(provider), idToken);
		LoginResponse loginResponse = new LoginResponse(loginInfo);

		return ResponseEntity.status(HttpStatus.CREATED)
			.body(loginResponse);

	}
}
