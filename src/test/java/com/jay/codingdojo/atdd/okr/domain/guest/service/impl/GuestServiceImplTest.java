package com.jay.codingdojo.atdd.okr.domain.guest.service.impl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import com.jay.codingdojo.atdd.okr.common.utils.TokenGenerator;
import com.jay.codingdojo.atdd.okr.domain.guest.Guest;
import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserInfo;
import com.jay.codingdojo.atdd.okr.domain.user.service.UserInfoType;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.OAuth2UserInfo;

@DataJpaTest
@Import({GuestServiceImpl.class})
class GuestServiceImplTest {

	@Autowired
	private GuestServiceImpl sut;

	@Test
	@DisplayName("Guest를 생성한다. (한번도 회원가입 시도 X)")
	void create_new_guest_when_not_exist() {
		UserInfo info = new UserInfo(UserInfoType.GUEST,"testId", "testName", "testEmail@mail.com", "testPicture", ProviderType.GOOGLE);
		Guest guest = sut.createNewGuest(info);

		assertNewGuset(info, guest);
	}

	@Test
	@DisplayName("Guest를 생성한다. (회원가입 시도 했던적 O)")
	@Sql("classpath:atdd/okr/insert-guest.sql")
	void create_new_guest_when_exist() {
		UserInfo info = new UserInfo(UserInfoType.GUEST,"testId", "testName", "testEmail@mail.com", "testPicture", ProviderType.GOOGLE);
		Guest guest = sut.createNewGuest(info);

		assertExistedGuest(info, guest);
	}


	private void assertNewGuset(UserInfo info, Guest guest) {
		assertThat(guest.getGuestName()).isEqualTo(info.name());
		assertThat(guest.getEmail()).isEqualTo(info.email());
		assertThat(guest.getGuestId()).isEqualTo(info.id());
		assertThat(guest.getProfileImage()).isEqualTo(info.picture());
		assertThat(guest.getProviderType()).isEqualTo(info.providerType());
		assertThat(guest.getGuestUuid()).containsPattern(
			Pattern.compile("guest-[a-zA-Z0-9]{14}")
		);
	}

	private void assertExistedGuest(UserInfo info, Guest guest) {
		assertThat(guest.getGuestName()).isEqualTo(info.name());
		assertThat(guest.getEmail()).isEqualTo(info.email());
		assertThat(guest.getGuestId()).isEqualTo(info.id());
		assertThat(guest.getProfileImage()).isEqualTo(info.picture());
		assertThat(guest.getProviderType()).isEqualTo(info.providerType());
		assertThat(guest.getGuestUuid()).isNotEqualTo("guest_ffeda");
	}

}