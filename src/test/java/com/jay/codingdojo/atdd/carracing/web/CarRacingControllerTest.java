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

	@BeforeEach
	void setUp() {
		given(carRacingService.create())
			.willReturn(new RaceStatusResponse(1L, null, null));
	}

	@Test
	void create() {
		final CarRacingController sut = new CarRacingController(carRacingService);

		RaceStatusResponse response = sut.create();

		assertThat(response).isEqualTo(new RaceStatusResponse(1L, null, null));
	}

}