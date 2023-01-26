package com.jay.codingdojo.atdd.okr.interfaces.user;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jay.codingdojo.atdd.okr.domain.user.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserApiController {

	private final UserService userService;

	@PostMapping("/login/{provider}/{idToken}")
	LoginResponse loginWithIdToken(
		@PathVariable("provider") String provider,
		@PathVariable("idToken") String idToken
	) {
		throw new UnsupportedOperationException("unimplemented");
	}
}
