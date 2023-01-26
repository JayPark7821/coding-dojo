package com.jay.codingdojo.atdd.okr.domain.user.service;

import com.jay.codingdojo.atdd.okr.domain.guest.Guest;
import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;

public record LoginInfo(String guestUuId, String email, String name, ProviderType providerType, String accessToken,
						String refreshToken) {

	public LoginInfo(String guestUuId, String email, String name, ProviderType providerType, String accessToken,
		String refreshToken) {
		this.guestUuId = guestUuId;
		this.email = email;
		this.name = name;
		this.providerType = providerType;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	public LoginInfo(Guest guest) {
		this(guest.getGuestUuid(), guest.getEmail(), guest.getGuestName(), guest.getProviderType(), null, null);
	}
}
