package com.jay.codingdojo.atdd.carracing.web;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jay.codingdojo.atdd.carracing.service.CarRacingService;
import com.jay.codingdojo.atdd.carracing.service.CarRacingUsecase;
import com.jay.codingdojo.atdd.carracing.service.RaceStatusResponse;

import static org.mockito.BDDMockito.given;

import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class CarRacingControllerTest {

	@Mock
	private CarRacingService carRacingService;
	@Mock
	private CarRacingUsecase carRacingUsecase;
	private CarRacingController sut;


	@BeforeEach
	void setUp() {
		sut = new CarRacingController(carRacingService,carRacingUsecase);
	}

	@Test
	void create() {
		final Long raceId = 1L;
		RaceStatusResponse expectedResponse
			= new RaceStatusResponse(raceId, null, null, null);

		given(carRacingService.create())
			.willReturn(expectedResponse);

		RaceStatusResponse response = sut.create();

		assertThat(response).isEqualTo(expectedResponse);
	}


	@Test
	void addCars() {

		final Long raceId = 1L;
		RaceStatusResponse expectedResponse
			= new RaceStatusResponse(raceId, null, null, "3 Cars Participated");

		given(carRacingUsecase.addCars(raceId, "test1,test2,test3"))
			.willReturn(expectedResponse);

		RaceStatusResponse response = sut.addCars(raceId, "test1,test2,test3");

		assertThat(response).isEqualTo(expectedResponse);
	}


	@Test
	void startRace() {

		final Long raceId = 1L;
		RaceStatusResponse expectedResponse
			= new RaceStatusResponse(raceId, null, null, "Race Started");

		given(carRacingService.startRace(raceId))
			.willReturn(expectedResponse);

		RaceStatusResponse response = sut.startRace(raceId);

		assertThat(response).isEqualTo(expectedResponse);
	}



	@Test
	void getRaceWinner() {

		final Long raceId = 1L;
		RaceStatusResponse expectedResponse
			= new RaceStatusResponse(raceId, null, List.of("test1"), null);

		given(carRacingService.getRaceWinner(raceId))
			.willReturn(expectedResponse);

		RaceStatusResponse response = sut.getRaceWinner(raceId);

		assertThat(response).isEqualTo(expectedResponse);
	}

	@Test
	void getRaceHistory() {

		final Long raceId = 1L;
		RaceStatusResponse expectedResponse
			= new RaceStatusResponse(raceId, generateRaceHistory(), null, null);

		given(carRacingService.getRaceHistory(raceId))
			.willReturn(expectedResponse);

		RaceStatusResponse response = sut.getRaceHistory(raceId);

		assertThat(response).isEqualTo(expectedResponse);
	}

	private List<Map<String, Integer>> generateRaceHistory() {
		return List.of(
			Map.of(
				"test1", 1,
				"test2", 0,
				"test3", 1
			),
			Map.of(
				"test1", 2,
				"test2", 0,
				"test3", 1
			),
			Map.of(
				"test1", 2,
				"test2", 1,
				"test3", 1
			)
		);
	}

}