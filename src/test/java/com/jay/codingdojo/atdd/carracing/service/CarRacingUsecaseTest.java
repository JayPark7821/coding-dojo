package com.jay.codingdojo.atdd.carracing.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import com.jay.codingdojo.atdd.carracing.domain.CarRepository;

@DataJpaTest
@Import({
	CarRacingUsecase.class,
	CarRacingService.class,
	CarService.class,
	CarRepository.class
})
public class CarRacingUsecaseTest {

	@Autowired
	private CarRacingUsecase sut;

	@Test
	@Sql("classpath:atdd/carracing/insert-carracing.sql")
	void addCars() throws Exception {

		final Long raceId = 1L;
		final RaceStatusResponse response = sut.addCars(raceId, "car1,car2");
		assertThat(response).isEqualTo(new RaceStatusResponse(raceId, null, null, "2 Cars Participated"));
	}

}
