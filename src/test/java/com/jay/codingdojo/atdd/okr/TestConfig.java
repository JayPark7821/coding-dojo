package com.jay.codingdojo.atdd.okr;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.jay.codingdojo.atdd.okr.interfaces.user.auth.TokenVerifier;

@TestConfiguration
public class TestConfig {

	@Primary
	@Bean
	public TokenVerifier tokenVerifier() {
		return new FakeTokenVerifier();
	}
}
