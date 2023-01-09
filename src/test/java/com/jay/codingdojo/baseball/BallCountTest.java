package com.jay.codingdojo.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallCountTest {

	private BallCount sut;

	@BeforeEach
	void setUp() {
		sut = new BallCount("789");
	}

	@ParameterizedTest
	@CsvSource({
		"123, 0, 0",
		"923, 1, 0",
		"239, 0, 1",
		"739, 0, 2",
		"379, 1, 1",
		"789, 0, 3"
	})
	void testCases(String userInput, int balls, int strikes) throws Exception {
		BallCount ballCount = sut.countBall(userInput);
		assertBallCounts(ballCount, balls, strikes);
	}

	private static void assertBallCounts(BallCount ballCount, int balls, int strikes) {
		assertThat(ballCount.getBalls()).isEqualTo(balls);
		assertThat(ballCount.getStrikes()).isEqualTo(strikes);
	}

}