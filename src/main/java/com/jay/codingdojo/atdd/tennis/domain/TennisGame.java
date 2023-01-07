package com.jay.codingdojo.atdd.tennis.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TennisGame {

	private Long id;

	public TennisGame(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public Integer getServerPoints() {
		return 0;
	}

	public Integer getReceiverPoints() {
		return 0;
	}

	public String getStatus() {
		return "STARTED";
	}
}
