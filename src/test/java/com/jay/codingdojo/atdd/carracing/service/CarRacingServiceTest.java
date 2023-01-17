package com.jay.codingdojo.atdd.carracing.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.BDDMockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jay.codingdojo.atdd.carracing.domain.Car;
import com.jay.codingdojo.atdd.carracing.domain.CarRacing;
import com.jay.codingdojo.atdd.carracing.domain.CarRacingRepository;

@ExtendWith(MockitoExtension.class)
class CarRacingServiceTest {

	@Mock
	private CarRacingRepository repository;
	private CarRacingService sut;

	@BeforeEach
	void setUp() {
		sut = new CarRacingService(repository);
	}

	@Test
	void create() {

		given(repository.save(any(CarRacing.class)))
			.willReturn(new CarRacing(1L));

		assertThat(sut.create())
			.isEqualTo(new RaceStatusResponse(1L, null, null, null));
	}

	@Test
	void addCars_success() throws Exception {
		final Long raceId = 1L;

		CarRacing carRacing = new CarRacing(raceId);

		final RaceStatusResponse response = sut.addCars(carRacing, Car.createCars("car1,car2", new CarRacing(1L)));

		assertThat(response).isEqualTo(new RaceStatusResponse(raceId, null, null, "2 Cars Participated"));
	}

	@Test
	void can_find_by_id() throws Exception {
		final Long raceId = 1L;

		CarRacing carRacing = new CarRacing(raceId);

		given(repository.findById(raceId))
			.willReturn(Optional.of(carRacing));

		CarRacing savedCarRacing = sut.findById(raceId);

		assertThat(savedCarRacing).isEqualTo(carRacing);
	}

	@Test
	void find_by_id_fail() throws Exception {
		final Long raceId = 1L;

		given(repository.findById(raceId))
			.willReturn(Optional.empty());

		Assertions.assertThrows(CarRacingNotFoundException.class,
			() -> {
				sut.findById(raceId);
			}
		);
	}
}