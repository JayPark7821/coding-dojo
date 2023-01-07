package com.jay.codingdojo.atdd.tennis.application;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jay.codingdojo.atdd.tennis.service.TennisGameStatusResponse;

class TennisGameServiceTest {

	private TennisGameService sut;

	@BeforeEach
	void setUp() {
		sut = new TennisGameService();
	}

	@Test
	void create() {
		assertThat(sut.create())
			.isEqualTo(new TennisGameStatusResponse());
	}


}