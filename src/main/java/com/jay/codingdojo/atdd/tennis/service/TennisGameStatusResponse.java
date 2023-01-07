package com.jay.codingdojo.atdd.tennis.service;

public record TennisGameStatusResponse(Long gameId, Integer server, Integer receiver, String status) {
}
