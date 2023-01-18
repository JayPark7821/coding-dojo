package com.jay.codingdojo.atdd.carracing.web;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.jay.codingdojo.atdd.carracing.service.RaceStatusResponse;

@SpringBootTest
@Transactional
class CarRacingControllerTest {

	@Autowired
	private CarRacingController sut;

	@Test
	void create() {
		final Long raceId = 1L;
		RaceStatusResponse expectedResponse
			= new RaceStatusResponse(raceId, null, null, null);

		RaceStatusResponse response = sut.create();

		assertThat(response).isEqualTo(expectedResponse);
	}

	@Test
	@Sql("classpath:atdd/carracing/insert-carracing.sql")
	void addCars() {

		final Long raceId = 1L;
		RaceStatusResponse expectedResponse
			= new RaceStatusResponse(raceId, null, null, "3 Cars Participated");

		RaceStatusResponse response = sut.addCars(raceId, "test1,test2,test3");

		assertThat(response).isEqualTo(expectedResponse);
	}

	@Test
	void startRace() {

		final Long raceId = 1L;
		RaceStatusResponse expectedResponse
			= new RaceStatusResponse(raceId, null, null, "Race Started");

		RaceStatusResponse response = sut.startRace(raceId);

		assertThat(response).isEqualTo(expectedResponse);
	}

	@Test
	void getRaceWinner() {

		final Long raceId = 1L;
		RaceStatusResponse expectedResponse
			= new RaceStatusResponse(raceId, null, List.of("test1"), null);

		RaceStatusResponse response = sut.getRaceWinner(raceId);

		assertThat(response).isEqualTo(expectedResponse);
	}

	@Test
	void getRaceHistory() {

		final Long raceId = 1L;
		RaceStatusResponse expectedResponse
			= new RaceStatusResponse(raceId, generateRaceHistory(), null, null);

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