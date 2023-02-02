package com.jay.codingdojo.atdd.okr.domain.token.service.impl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import com.jay.codingdojo.atdd.okr.domain.token.service.AuthTokenInfo;
@DataJpaTest
@Import(TokenServiceImpl.class)
class TokenServiceImplTest {

		@Autowired
		private TokenServiceImpl sut;

		@Test
		void generate_AuthTokenInfo_from_userEmail () throws Exception {
			String userEmail = "testUser@mail.com";

			AuthTokenInfo authTokenInfo = sut.generateTokenSet(userEmail);
			assertThat(authTokenInfo).isEqualTo(new AuthTokenInfo("access-token", "refresh-token"));
		}

}