package com.jay.codingdojo.atdd.carracing.web;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jay.codingdojo.atdd.carracing.service.RaceStatusResponse;

class CarRacingControllerTest {

	@Test
	void create() {
		final CarRacingController sut = new CarRacingController();

		RaceStatusResponse response = sut.create();

		assertThat(response).isEqualTo(new RaceStatusResponse(1L, null, null));
	}

}