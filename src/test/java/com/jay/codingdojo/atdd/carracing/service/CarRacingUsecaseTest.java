package com.jay.codingdojo.atdd.carracing.service;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jay.codingdojo.atdd.carracing.domain.Car;
import com.jay.codingdojo.atdd.carracing.domain.CarRacingRepository;
import com.jay.codingdojo.atdd.carracing.domain.CarRepository;


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

		final RaceStatusResponse response = sut.addCars(raceId, "car1,car2");

		assertThat(response).isEqualTo(new RaceStatusResponse(raceId,null,null,"2 Cars Participated"));
	}

}
