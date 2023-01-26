package com.jay.codingdojo.atdd.okr.infrastructure.guest;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.codingdojo.atdd.okr.domain.guest.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
