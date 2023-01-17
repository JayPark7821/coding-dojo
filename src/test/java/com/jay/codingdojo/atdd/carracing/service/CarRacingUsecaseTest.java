package com.jay.codingdojo.atdd.carracing.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.BDDMockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jay.codingdojo.atdd.carracing.domain.Car;
import com.jay.codingdojo.atdd.carracing.domain.CarRacing;

@ExtendWith(MockitoExtension.class)
public class CarRacingUsecaseTest {

	private CarRacingUsecase sut;
	@Mock
	private CarRacingService carRacingService;
	@Mock
	private CarService carService;

	@BeforeEach
	void setUp() {
		sut = new CarRacingUsecase(carRacingService, carService);
	}

	@Test
	void addCars() throws Exception {

		final Long raceId = 1L;
		CarRacing carRacing = new CarRacing(raceId);
		List<Car> cars = List.of(new Car(1L, "car1", carRacing), new Car(2L, "car2", carRacing));

		given(carRacingService.findById(raceId))
			.willReturn(carRacing);
		given(carService.create("car1,car2", carRacing))
			.willReturn(cars);
		given(carRacingService.addCars(carRacing, cars))
			.willReturn(new RaceStatusResponse(raceId, null, null, "2 Cars Participated"));

		final RaceStatusResponse response = sut.addCars(raceId, "car1,car2");

		assertThat(response).isEqualTo(new RaceStatusResponse(raceId, null, null, "2 Cars Participated"));
	}

}
