package com.jay.codingdojo.atdd.okr.interfaces.user.auth;

public interface TokenVerifier {

	OAuth2UserInfo verifyIdToken(String token);
}
