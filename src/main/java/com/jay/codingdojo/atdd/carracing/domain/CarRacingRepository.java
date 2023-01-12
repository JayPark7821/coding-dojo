package com.jay.codingdojo.atdd.carracing.domain;

import java.util.Optional;

public interface CarRacingRepository {
	CarRacing save(final CarRacing carRacing);

	Optional<CarRacing> findById(final Long id);
}
