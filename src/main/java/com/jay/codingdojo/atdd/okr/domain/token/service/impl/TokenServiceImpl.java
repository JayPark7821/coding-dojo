package com.jay.codingdojo.atdd.okr.domain.token.service.impl;

import org.springframework.stereotype.Service;

import com.jay.codingdojo.atdd.okr.domain.token.service.AuthTokenInfo;
import com.jay.codingdojo.atdd.okr.domain.token.service.TokenService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

	@Override
	public AuthTokenInfo generateTokenSet(String userEmail) {
		throw new UnsupportedOperationException();
	}
}
