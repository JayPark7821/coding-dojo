package com.jay.codingdojo.atdd.carracing.web;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jay.codingdojo.atdd.carracing.service.CarRacingService;
import com.jay.codingdojo.atdd.carracing.service.RaceStatusResponse;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CarRacingControllerTest {

	@Mock
	private CarRacingService carRacingService;
	private CarRacingController sut;

	@BeforeEach
	void setUp() {
		sut = new CarRacingController(carRacingService);
	}

	@Test
	void create() {
		given(carRacingService.create())
			.willReturn(new RaceStatusResponse(1L, null, null, null));

		RaceStatusResponse response = sut.create();

		assertThat(response).isEqualTo(new RaceStatusResponse(1L, null, null, null));
	}


	@Test
	void addCars() {

		given(carRacingService.addCars(1L, "test1,test2,test3"))
			.willReturn(new RaceStatusResponse(1L, null, null, "3 Cars Participated"));

		RaceStatusResponse response = sut.addCars(1L, "test1,test2,test3");

		assertThat(response).isEqualTo(new RaceStatusResponse(1L, null, null, "3 Cars Participated"));
	}


	@Test
	void startRace() {
		RaceStatusResponse response = sut.startRace(1L);

		assertThat(response).isEqualTo(new RaceStatusResponse(1L, null, null, "Race Started"));
	}





}