package com.jay.codingdojo.atdd.okr.domain.guest;

import java.util.Optional;

public interface GuestRepository {
	Optional<Guest> findByGuestId(String guestId);

	void delete(Guest guest);

	Guest save(Guest guest);

}
