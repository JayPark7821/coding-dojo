package com.jay.codingdojo.atdd.carracing.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.BDDMockito.*;

import java.util.List;
import java.util.Optional;

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
	void addCars_when_car_racing_not_found() throws Exception {
		final Long raceId = 999L;

		given(repository.findById(raceId))
			.willReturn(Optional.empty());
		CarRacing carRacingForCar = new CarRacing();

		final CarRacingService sut = new CarRacingService(repository);

		assertThatThrownBy(() -> sut.addCars(
			carRacingForCar,
			List.of(new Car(1L, "test1", carRacingForCar), new Car(2L, "test2", carRacingForCar)))
		)
			.isInstanceOf(CarRacingNotFoundException.class)
			.hasMessage("Car Racing not found: " + raceId);
	}

	@Test
	void addCars_success() throws Exception {
		final Long raceId = 1L;

		CarRacing carRacing = new CarRacing(raceId);
		given(repository.findById(raceId))
			.willReturn(Optional.of(carRacing));

		final RaceStatusResponse response = sut.addCars(carRacing, Car.createCars("car1,car2", new CarRacing(1L)));

		assertThat(response).isEqualTo(new RaceStatusResponse(raceId, null, null, "2 Cars Participated"));
	}

}