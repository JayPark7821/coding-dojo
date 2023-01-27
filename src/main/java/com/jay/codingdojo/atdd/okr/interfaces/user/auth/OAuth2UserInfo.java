package com.jay.codingdojo.atdd.okr.interfaces.user.auth;

import com.jay.codingdojo.atdd.okr.domain.guest.Guest;
import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;

public record OAuth2UserInfo(String id, String name, String email, String picture) {

	public Guest toGuest(ProviderType providerType) {
		return Guest.builder()
			.guestId(id)
			.guestName(name)
			.email(email)
			.profileImage(picture)
			.providerType(providerType)
			.build();
	}
}

