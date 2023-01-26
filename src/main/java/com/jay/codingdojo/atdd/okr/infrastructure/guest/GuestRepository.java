package com.jay.codingdojo.atdd.okr.infrastructure.guest;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.codingdojo.atdd.okr.domain.guest.Guest;

public interface GuestRepository extends JpaRepository<Guest, String> {

	Optional<Guest> findByGuestId(String guestId);
}
