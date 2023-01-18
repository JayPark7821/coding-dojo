package com.jay.codingdojo.atdd.carracing.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import com.jay.codingdojo.atdd.carracing.domain.Car;
import com.jay.codingdojo.atdd.carracing.domain.CarRacing;

@DataJpaTest
@Import(CarRacingService.class)
class CarRacingServiceTest {

	@Autowired
	private CarRacingService sut;

	@Test
	void create() {
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
	@Sql("classpath:atdd/carracing/insert-carracing.sql")
	void can_find_by_id() throws Exception {
		final Long raceId = 1L;

		CarRacing carRacing = new CarRacing(raceId);

		CarRacing savedCarRacing = sut.findById(raceId);

		assertThat(savedCarRacing.getId()).isEqualTo(carRacing.getId());
	}

	@Test
	void find_by_id_fail() throws Exception {
		final Long raceId = 1L;

		Assertions.assertThrows(CarRacingNotFoundException.class,
			() -> {
				sut.findById(raceId);
			}
		);
	}
}