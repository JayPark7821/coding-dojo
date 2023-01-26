package com.jay.codingdojo.atdd.okr.interfaces.user;

import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.service.LoginInfo;

public record LoginResponse(String guestId, String email, String name, ProviderType providerType, String accessToken,
							String refreshToken) {
	public LoginResponse(LoginInfo info) {
		this(info.guestUuId(), info.email(), info.name(), info.providerType(), info.accessToken(), info.refreshToken());
	}
}
