package com.jay.codingdojo.atdd.okr.domain.user.service;

import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;

public interface UserService {
	UserInfo getUserWholeInfoFromIdToken(ProviderType provider, String idToken);
}
