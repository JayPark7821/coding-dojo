package com.jay.codingdojo.atdd.okr.interfaces.user;

import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;

public record LoginResponse(String guestId, String email, String name, ProviderType providerType, String accessToken,
							String refreshToken) {
}
