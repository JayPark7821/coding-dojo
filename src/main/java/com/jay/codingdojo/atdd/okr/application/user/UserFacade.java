package com.jay.codingdojo.atdd.okr.application.user;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.jay.codingdojo.atdd.okr.domain.guest.service.GuestService;
import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.User;
import com.jay.codingdojo.atdd.okr.domain.user.service.LoginInfo;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserWholeInfo;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserFacade {

	private final UserService userService;
	private final GuestService guestService;

	public LoginInfo loginWithIdToken(ProviderType provider, String idToken) {
		UserWholeInfo userWholeInfo = userService.getUserWholeInfoFromIdToken(provider, idToken);
		Optional<User> user = userWholeInfo.user();

		if (user.isPresent()) {
			if (user.get().canUserLogin(provider)) {
				return new LoginInfo(user.get(), "accessToken", "refreshToken");
			}
		}
		return new LoginInfo(guestService.createNewGuest(userWholeInfo.oAuth2UserInfo()));

	}
}
