package com.jay.codingdojo.atdd.okr.application.user;

import com.jay.codingdojo.atdd.okr.domain.guest.Guest;
import com.jay.codingdojo.atdd.okr.domain.token.service.AuthTokenInfo;
import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.User;

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

	public LoginInfo(User user, AuthTokenInfo authTokenInfo) {
		this(null , user.getEmail(), user.getUsername(), user.getProviderType(), authTokenInfo.accessToken(),
			authTokenInfo.refreshToken() );
	}

}
