package com.jay.codingdojo.atdd.carracing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

	//TODO
	@Test
	void addCars() throws Exception {
		//
		// final Long raceId = 1L;
		//
		// given(carService.create(any(String.class)))
		// 	.willReturn(mock(Car.class));
		//
		// given(carRacingService.addCars(eq(raceId), any(List.class)))
		// 	.willReturn(new RaceStatusResponse(raceId, null, null, "2 Cars Participated"));
		//
		// final RaceStatusResponse response = sut.addCars(raceId, "car1,car2");
		//
		// assertThat(response).isEqualTo(new RaceStatusResponse(raceId, null, null, "2 Cars Participated"));
	}

}
