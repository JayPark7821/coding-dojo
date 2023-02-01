package com.jay.codingdojo.atdd.okr.domain.user.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.User;
import com.jay.codingdojo.atdd.okr.domain.user.UserRepository;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserWholeInfo;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserService;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.GoogleTokenVerifier;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.OAuth2UserInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final GoogleTokenVerifier googleTokenVerifier;
	private final UserRepository userRepository;


	@Override
	public UserWholeInfo getUserWholeInfoFromIdToken(ProviderType provider, String idToken) {
		OAuth2UserInfo userInfo = googleTokenVerifier.varifyIdToken(idToken);
		Optional<User> user = userRepository.findByEmail(userInfo.email());
		return new UserWholeInfo(user, userInfo);
	}
}
