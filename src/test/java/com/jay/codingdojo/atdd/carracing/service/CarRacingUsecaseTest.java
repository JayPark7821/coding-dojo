package com.jay.codingdojo.atdd.carracing.service;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CarRacingUsecaseTest {

	private CarRacingUsecase sut;


	@BeforeEach
	void setUp() {
		sut = new CarRacingUsecase();
	}

	@Test
	void addCars() throws Exception {

		final Long raceId = 1L;

		final RaceStatusResponse response = sut.addCars(raceId, "car1,car2");

		assertThat(response).isEqualTo(new RaceStatusResponse(raceId,null,null,"2 Cars Participated"));
	}

}
