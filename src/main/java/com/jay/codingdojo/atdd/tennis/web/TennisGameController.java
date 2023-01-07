package com.jay.codingdojo.atdd.tennis.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jay.codingdojo.atdd.tennis.service.TennisGameStatusResponse;

@RestController
@RequestMapping("/api/jay/tennis-game")
class TennisGameController {

	@PostMapping
	TennisGameStatusResponse create(){
		throw new UnsupportedOperationException("unimplemented");

	}
}

