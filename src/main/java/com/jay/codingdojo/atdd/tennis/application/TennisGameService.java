package com.jay.codingdojo.atdd.tennis.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jay.codingdojo.atdd.tennis.service.TennisGameStatusResponse;

@Service
@Transactional
public class TennisGameService {

	public TennisGameStatusResponse create() {
		throw new UnsupportedOperationException(
			"com.jay.codingdojo.atdd.tennis.application.TennisGameService.create()");
	}
}
