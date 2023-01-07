package com.jay.codingdojo.atdd.tennis.service;

import com.jay.codingdojo.atdd.tennis.domain.TennisGame;

public record TennisGameStatusResponse(Long gameId, Integer server, Integer receiver, String status) {
	public TennisGameStatusResponse(TennisGame game) {
		this(game.getId(), game.getServerPoints(), game.getReceiverPoints(), game.getStatus());
	}
}
