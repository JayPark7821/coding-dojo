package com.jay.codingdojo.atdd.okr;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.OAuth2UserInfo;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.TokenVerifier;

public class FakeTokenVerifier implements TokenVerifier {

	public static final String id = "fakeId";
	public static final String name = "fakeName";
	public static final String email = "fakeEmail";
	public static final String pic = "fakePic";
	public static final ProviderType provider = ProviderType.GOOGLE;

	@Override
	public OAuth2UserInfo verifyIdToken(String token) {
		if (token.equals("userToken")) {
			return new OAuth2UserInfo(id, name, email, pic, provider);
		}
		return new OAuth2UserInfo(id, name, email, pic, provider);
	}
}
