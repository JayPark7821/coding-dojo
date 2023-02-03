package com.jay.codingdojo.atdd.okr.domain.user.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.User;
import com.jay.codingdojo.atdd.okr.domain.user.UserRepository;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserInfo;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserService;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.OAuth2UserInfo;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.TokenVerifier;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final TokenVerifier tokenVerifier;
	private final UserRepository userRepository;


	@Override
	public UserInfo getUserWholeInfoFromIdToken(ProviderType provider, String idToken) {
		OAuth2UserInfo userInfo = tokenVerifier.verifyIdToken(idToken);
		Optional<User> user = userRepository.findByEmail(userInfo.email());
		if(user.isPresent()) {
			return new UserInfo(user.get());
		}
		return new UserInfo(userInfo);
	}
}
