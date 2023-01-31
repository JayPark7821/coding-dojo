package com.jay.codingdojo.atdd.okr.domain.user.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jay.codingdojo.atdd.okr.domain.guest.Guest;
import com.jay.codingdojo.atdd.okr.domain.guest.GuestRepository;
import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;
import com.jay.codingdojo.atdd.okr.domain.user.User;
import com.jay.codingdojo.atdd.okr.domain.user.UserRepository;
import com.jay.codingdojo.atdd.okr.domain.user.service.LoginInfo;
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
	private final GuestRepository guestRepository;

	@Override
	public LoginInfo loginWithIdToken(ProviderType providerType, String idToken) {
		if (providerType == ProviderType.GOOGLE) {
			OAuth2UserInfo info = googleTokenVerifier.varifyIdToken(idToken);
			Optional<User> user = userRepository.findByEmail(info.email());

			if (user.isEmpty()) {
				Optional<Guest> savedGuest = guestRepository.findByGuestId(info.id());
				savedGuest.ifPresent(guestRepository::delete);
				Guest newGuest = info.toGuest(providerType);
				newGuest.setGuestUuidForNewGuest();
				return new LoginInfo(guestRepository.save(newGuest));
			}
		}
		throw new IllegalStateException();
	}
}
