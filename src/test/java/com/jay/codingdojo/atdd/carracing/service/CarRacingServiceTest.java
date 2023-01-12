package com.jay.codingdojo.atdd.carracing.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import com.jay.codingdojo.atdd.carracing.domain.CarRacing;
import com.jay.codingdojo.atdd.carracing.domain.CarRacingRepository;

class CarRacingServiceTest {

	private CarRacingRepository repository;

	@Test
	void create() {
		final CarRacingService sut = new CarRacingService(repository);

		given(repository.save(any(CarRacing.class)))
			.willReturn(new CarRacing(1L));

		assertThat(sut.create())
			.isEqualTo(new RaceStatusResponse(1L, null, null, null));
	}

}