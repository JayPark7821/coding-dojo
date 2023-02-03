package com.jay.codingdojo.atdd.okr.domain.guest.service;

import com.jay.codingdojo.atdd.okr.domain.guest.Guest;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserInfo;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.OAuth2UserInfo;

public interface GuestService {
	Guest createNewGuest(UserInfo userInfo);
}
