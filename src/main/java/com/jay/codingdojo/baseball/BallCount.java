package com.jay.codingdojo.baseball;

public class BallCount {
	private int balls;
	private int strikes;

	public BallCount() {
	}

	public void countBall() {
		balls++;
	}

	public void countStrike() {
		strikes++;
	}

	public int getBalls() {
		return balls;
	}

	public int getStrikes() {
		return strikes;
	}
}
