package com.jay.codingdojo.atdd.tennis.application;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jay.codingdojo.atdd.tennis.domain.TennisGameRepository;
import com.jay.codingdojo.atdd.tennis.service.TennisGameStatusResponse;

class TennisGameServiceTest {

	private TennisGameService sut;
	private   repository;

	@BeforeEach
	void setUp() {
		sut = new TennisGameService(repository);
	}

	@Test
	void create() {
		assertThat(sut.create())
			.isEqualTo(new TennisGameStatusResponse(1L,0,0,"STARTED"));
	}


}