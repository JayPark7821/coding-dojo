package com.jay.codingdojo.atdd.tennis.application;

import static com.jay.codingdojo.atdd.tennis.application.PlayerType.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jay.codingdojo.atdd.tennis.domain.TennisGame;
import com.jay.codingdojo.atdd.tennis.domain.TennisGameRepository;
import com.jay.codingdojo.atdd.tennis.service.TennisGameStatusResponse;

@ExtendWith(MockitoExtension.class)
class TennisGameServiceTest {

	private TennisGameService sut;

	@Mock
	private TennisGameRepository repository;

	@BeforeEach
	void setUp() {
		sut = new TennisGameService(repository);
	}

	@Test
	void create() {
		given(repository.save(any(TennisGame.class))).willReturn(new TennisGame(1L));
		assertThat(sut.create())
			.isEqualTo(new TennisGameStatusResponse(1L, 0, 0, "STARTED"));
	}
}