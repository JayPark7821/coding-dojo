package com.jay.codingdojo.atdd.okr.application.user;

import org.springframework.stereotype.Component;

import com.jay.codingdojo.atdd.okr.domain.guest.service.GuestService;
import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.service.LoginInfo;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserFacade {

	private final UserService userService;
	private final GuestService guestService;

	public LoginInfo loginWithIdToken(ProviderType valueOf, String idToken) {
		throw new UnsupportedOperationException(
			"com.jay.codingdojo.atdd.okr.application.user.UserFacade.loginWithIdToken())");
	}
}
