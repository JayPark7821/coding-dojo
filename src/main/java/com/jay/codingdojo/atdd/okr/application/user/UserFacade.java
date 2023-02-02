package com.jay.codingdojo.atdd.okr.application.user;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.jay.codingdojo.atdd.okr.domain.guest.service.GuestService;
import com.jay.codingdojo.atdd.okr.domain.token.service.TokenService;
import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.User;
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
	private final TokenService tokenService;

	public LoginInfo loginWithIdToken(ProviderType provider, String idToken) {
		UserWholeInfo userWholeInfo = userService.getUserWholeInfoFromIdToken(provider, idToken);
		Optional<User> user = userWholeInfo.user();

		if (user.isPresent()) {
			User joinedUser = user.get();
			if (joinedUser.canUserLogin(provider)) {
				return new LoginInfo(joinedUser, tokenService.generateTokenSet(joinedUser.getEmail()));
			}
		}
		return new LoginInfo(guestService.createNewGuest(userWholeInfo.oAuth2UserInfo()));

	}
}
