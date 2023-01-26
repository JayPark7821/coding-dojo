package com.jay.codingdojo.atdd.okr.infrastructure.guest;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.codingdojo.atdd.okr.domain.guest.Guest;
import com.jay.codingdojo.atdd.okr.domain.guest.GuestRepository;

public interface GuestJpaRepository extends JpaRepository<Guest, String>, GuestRepository {

	Optional<Guest> findByGuestId(String guestId);
}
