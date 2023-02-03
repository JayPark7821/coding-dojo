package com.jay.codingdojo.atdd.okr.application.user;

import com.jay.codingdojo.atdd.okr.domain.guest.Guest;
import com.jay.codingdojo.atdd.okr.domain.token.service.AuthTokenInfo;
import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.User;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserInfo;

public record LoginInfo(String guestUuid, String email, String name, ProviderType providerType, String accessToken,
						String refreshToken) {

	public LoginInfo(String guestUuid, String email, String name, ProviderType providerType, String accessToken,
		String refreshToken) {
		this.guestUuid = guestUuid;
		this.email = email;
		this.name = name;
		this.providerType = providerType;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	public LoginInfo(Guest guest) {
		this(guest.getGuestUuid(), guest.getEmail(), guest.getGuestName(), guest.getProviderType(), null, null);
	}

	public LoginInfo(UserInfo userInfo, AuthTokenInfo authTokenInfo) {
		this(null , userInfo.email(), userInfo.name(), userInfo.providerType(), authTokenInfo.accessToken(),
			authTokenInfo.refreshToken() );
	}

}
