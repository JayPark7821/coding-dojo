package com.jay.codingdojo.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

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
		sut.countBall(userInput);
		assertBallCounts(balls, strikes);
	}

	private void assertBallCounts(int balls, int strikes) {

		assertThat(sut.getBalls()).isEqualTo(balls);
		assertThat(sut.getStrikes()).isEqualTo(strikes);
	}

}