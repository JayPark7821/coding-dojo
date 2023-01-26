package com.jay.codingdojo.atdd.okr.domain.user.service;

import com.jay.codingdojo.atdd.okr.domain.guest.Guest;
import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;

public record LoginInfo(String guestId, String email, String name, ProviderType providerType, String accessToken,
						String refreshToken) {

	public LoginInfo(Guest guest) {
		this(guest.getGuestId(), guest.getEmail(), guest.getGuestName(), guest.getProviderType(), null, null);
	}
}
