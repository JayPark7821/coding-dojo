package com.jay.codingdojo.atdd.tennis.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jay.codingdojo.atdd.tennis.domain.TennisGame;
import com.jay.codingdojo.atdd.tennis.domain.TennisGameRepository;
import com.jay.codingdojo.atdd.tennis.service.TennisGameStatusResponse;

@Service
@Transactional
public class TennisGameService {

	private final TennisGameRepository repository;

	public TennisGameService(TennisGameRepository repository) {
		this.repository = repository;
	}

	public TennisGameStatusResponse create() {
		final TennisGame createdGame = repository.save(new TennisGame());
		return new TennisGameStatusResponse(createdGame);
	}

	public TennisGameStatusResponse scores(TennisPlayerScoresRequest request) {
		throw new UnsupportedOperationException(
			"com.jay.codingdojo.atdd.tennis.application.TennisGameService.scores()");
	}
}
