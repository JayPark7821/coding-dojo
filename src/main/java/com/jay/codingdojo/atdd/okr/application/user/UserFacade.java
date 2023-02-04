package com.jay.codingdojo.atdd.okr.application.user;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.jay.codingdojo.atdd.okr.domain.guest.service.GuestService;
import com.jay.codingdojo.atdd.okr.domain.token.service.TokenService;
import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.User;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserInfo;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserInfoType;
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
		UserInfo userInfo = userService.getUserWholeInfoFromIdToken(provider, idToken);

		if (userInfo.userInfoType() == UserInfoType.USER) {
			validateProvider(provider, userInfo);
			return new LoginInfo(userInfo, tokenService.generateTokenSet(userInfo.email()));
		}
		return new LoginInfo(guestService.createNewGuest(userInfo));
	}

	private void validateProvider(ProviderType provider, UserInfo userInfo) {
		if (userInfo.providerType() != provider) {
			throw new IllegalStateException(userInfo.providerType() + "(으)로 가입한 계정이 있습니다.");
		}
	}

}
