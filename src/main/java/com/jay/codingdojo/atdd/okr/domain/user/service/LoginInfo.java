package com.jay.codingdojo.atdd.okr.domain.user.service;

import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;

public record LoginInfo(String guestId, String email, String name, ProviderType providerType, String accessToken,
						String refreshToken) {
}
