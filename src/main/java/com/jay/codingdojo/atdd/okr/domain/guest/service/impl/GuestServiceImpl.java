package com.jay.codingdojo.atdd.okr.domain.guest.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jay.codingdojo.atdd.okr.domain.guest.Guest;
import com.jay.codingdojo.atdd.okr.domain.guest.GuestRepository;
import com.jay.codingdojo.atdd.okr.domain.guest.service.GuestService;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.OAuth2UserInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {

	private final GuestRepository guestRepository;

	@Override
	public Guest createNewGuest(OAuth2UserInfo oAuth2UserInfo) {
		Optional<Guest> savedGuest = guestRepository.findByGuestId(oAuth2UserInfo.id());
		if (savedGuest.isPresent()) {
			guestRepository.delete(savedGuest.get());
		}
		return guestRepository.save(oAuth2UserInfo.toGuest());
	}
}
