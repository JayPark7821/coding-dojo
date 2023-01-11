package com.jay.codingdojo.atdd.carracing.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarRacingServiceTest {

	@Test
	void create() {
		final CarRacingService sut = new CarRacingService();

		assertThat(sut.create())
			.isEqualTo(new RaceStatusResponse(1L, null, null, null));
	}

}