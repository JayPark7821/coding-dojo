package com.jay.codingdojo.atdd.tennis.application;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jay.codingdojo.atdd.tennis.service.TennisGameStatusResponse;

class TennisGameServiceTest {

	@Test
	void create() {
		assertThat(new TennisGameService().create())
			.isEqualTo(new TennisGameStatusResponse());
	}


}