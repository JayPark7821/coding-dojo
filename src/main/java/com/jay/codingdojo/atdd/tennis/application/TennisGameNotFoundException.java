package com.jay.codingdojo.atdd.tennis.application;

public class TennisGameNotFoundException extends RuntimeException{
	public TennisGameNotFoundException(Long gameId) {
		super("Tennis game not found: %d".formatted(gameId));
	}
}
