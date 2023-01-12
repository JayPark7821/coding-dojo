package com.jay.codingdojo.atdd.carracing.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.BDDMockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jay.codingdojo.atdd.carracing.domain.CarRacing;
import com.jay.codingdojo.atdd.carracing.domain.CarRacingRepository;

@ExtendWith(MockitoExtension.class)
class CarRacingServiceTest {

	@Mock
	private CarRacingRepository repository;

	@Test
	void create() {
		final CarRacingService sut = new CarRacingService(repository);

		given(repository.save(any(CarRacing.class)))
			.willReturn(new CarRacing(1L));

		assertThat(sut.create())
			.isEqualTo(new RaceStatusResponse(1L, null, null, null));
	}

	@Test
	void addCars_when_car_racing_not_found() throws Exception {
		final Long raceId = 1L;

		given(repository.findById(raceId))
			.willReturn(Optional.empty());

		final CarRacingService sut = new CarRacingService(repository);

		assertThatThrownBy(() -> sut.addCars(raceId, "car1,car2"))
			.isInstanceOf(CarRacingNotFoundException.class)
			.hasMessage("Car Racing not found: " + raceId);
	}

}