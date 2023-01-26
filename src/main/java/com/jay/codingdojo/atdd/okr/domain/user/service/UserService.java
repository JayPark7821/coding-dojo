package com.jay.codingdojo.atdd.okr.domain.user.service;

import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;

public interface UserService {
	LoginInfo loginWithIdToken(ProviderType providerType, String idToken);
}
