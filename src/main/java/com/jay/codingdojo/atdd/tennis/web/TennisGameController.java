package com.jay.codingdojo.atdd.tennis.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jay.codingdojo.atdd.tennis.application.PlayerType;
import com.jay.codingdojo.atdd.tennis.application.TennisGameService;
import com.jay.codingdojo.atdd.tennis.application.TennisPlayerScoresRequest;
import com.jay.codingdojo.atdd.tennis.service.TennisGameStatusResponse;

@RestController
@RequestMapping("/api/jay/tennis-game")
class TennisGameController {

	private final TennisGameService service  ;

	TennisGameController(TennisGameService service) {
		this.service = service;
	}

	@PostMapping
	TennisGameStatusResponse create(){
		return service.create();
	}

	@PutMapping("/{gameId}/score/server")
	TennisGameStatusResponse serverScores(final Long gameId){
		return service.scores(new TennisPlayerScoresRequest(gameId, PlayerType.SERVER ));
	}

	@PutMapping("/{gameId}/score/receiver")
	TennisGameStatusResponse receiverScores(final Long gameId){
		return service.scores(new TennisPlayerScoresRequest(gameId, PlayerType.RECEIVER ));
	}
}

