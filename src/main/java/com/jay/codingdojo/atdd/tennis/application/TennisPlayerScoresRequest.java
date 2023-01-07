package com.jay.codingdojo.atdd.tennis.application;

public record TennisPlayerScoresRequest(Long gameId, PlayerType server) {
}
