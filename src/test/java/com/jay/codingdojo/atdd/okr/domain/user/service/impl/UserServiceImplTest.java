package com.jay.codingdojo.atdd.okr.domain.user.service.impl;

import static org.mockito.BDDMockito.*;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserInfo;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserInfoType;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.GoogleTokenVerifier;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.OAuth2UserInfo;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
@Import(UserServiceImpl.class)
class UserServiceImplTest {

	@MockBean // InjectMocks
	private GoogleTokenVerifier googleTokenVerifier;

	@Autowired
	private UserServiceImpl sut;

	@Test
	@DisplayName("ProviderType과 idToken으로 인증하고 인증된 정보로 user테이블 조회 그결과를 인증된 정보화 함께 UserInfo로 반환한다. user정보 없는 케이스")
	void request_userWholeInfo_by_providerType_and_idToken() throws Exception {
		String userId = "testId";
		String userName = "testUser";
		String userEmail = "test@email.com";
		String userPicture = "testPicture";
		stubGoogleTokenVerifier(userId, userName, userEmail,userPicture);

		UserInfo userInfo = sut.getUserWholeInfoFromIdToken(ProviderType.GOOGLE, "idToken");

		Assertions.assertThat(userInfo)
			.isEqualTo(
				new UserInfo(UserInfoType.GUEST, userId, userName, userEmail, userPicture, ProviderType.GOOGLE));
	}

	@Test
	@DisplayName("ProviderType과 idToken으로 인증하고 인증된 정보로 user테이블 조회 그결과를 인증된 정보화 함께 UserWholeInfo로 반환한다. user정보 있는 케이스")
	@Sql("classpath:atdd/okr/insert-user.sql")
	void request_userWholeInfo_by_providerType_and_idToken_when_user_present() throws Exception {
		String userId = "testId";
		String userName = "testUser";
		String userEmail = "test@email.com";
		String userPicture = "pic";
		stubGoogleTokenVerifier(userId, userName, userEmail,userPicture);

		UserInfo userInfo = sut.getUserWholeInfoFromIdToken(ProviderType.GOOGLE, "idToken");

		Assertions.assertThat(userInfo)
			.isEqualTo(new UserInfo( UserInfoType.USER, userId, userName, userEmail, userPicture, ProviderType.GOOGLE));
	}

	private void stubGoogleTokenVerifier(String userId, String userName, String userEmail, String userPicture) {
		given(googleTokenVerifier.verifyIdToken("idToken"))
			.willReturn(new OAuth2UserInfo(userId, userName, userEmail, userPicture, ProviderType.GOOGLE));
	}

}