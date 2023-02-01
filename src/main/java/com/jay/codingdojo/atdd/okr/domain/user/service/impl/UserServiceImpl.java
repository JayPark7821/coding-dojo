package com.jay.codingdojo.atdd.okr.domain.user.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.UserRepository;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserWholeInfo;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserService;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.GoogleTokenVerifier;

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
		throw new UnsupportedOperationException();
	}
}
