package com.jay.codingdojo.atdd.carracing.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

class CarRacingServiceTest {

	private CarRacingRepository repository;

	@Test
	void create() {
		final CarRacingService sut = new CarRacingService(repository);

		assertThat(sut.create())
			.isEqualTo(new RaceStatusResponse(1L, null, null, null));
	}

}