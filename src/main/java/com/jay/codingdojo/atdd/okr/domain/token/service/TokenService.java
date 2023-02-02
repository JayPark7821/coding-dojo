package com.jay.codingdojo.atdd.okr.domain.token.service;

public interface TokenService {
	AuthTokenInfo generateTokenSet(String userEmail);
}
