package com.jay.codingdojo.atdd.tennis.domain;

import java.util.Optional;

public interface TennisGameRepository {

	TennisGame save(TennisGame tennisGame);

	Optional<TennisGame> findById(Long gameId);
}
