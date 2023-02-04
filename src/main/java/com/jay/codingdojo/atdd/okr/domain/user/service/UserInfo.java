package com.jay.codingdojo.atdd.okr.domain.user.service;

import com.jay.codingdojo.atdd.okr.domain.guest.Guest;
import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.User;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.OAuth2UserInfo;

public record UserInfo(UserInfoType userInfoType, String id, String name, String email, String picture, ProviderType providerType){

	public UserInfo(User user) {
		this(UserInfoType.USER, user.getUserId(), user.getUsername(), user.getEmail(), user.getProfileImage(), user.getProviderType());
	}

	public UserInfo(OAuth2UserInfo oAuth2UserInfo) {
		this(UserInfoType.GUEST, oAuth2UserInfo.id(), oAuth2UserInfo.name(), oAuth2UserInfo.email(), oAuth2UserInfo.picture(), oAuth2UserInfo.providerType());
	}


	public Guest toGuest() {
		return Guest.builder()
			.guestId(id)
			.guestName(name)
			.email(email)
			.profileImage(picture)
			.providerType(providerType)
			.build();
	}

}
