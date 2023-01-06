package com.jay.codingdojo.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseBallTest {

	private BaseBall sut;

	@BeforeEach
	void setUp() {
		sut = new BaseBall(new RandomNumberService() {
			@Override
			public int generateRandomNumber() {
				return 789;
			}
		});

	}



	@Test
	void baseBallCanCountBallFromUserInput() throws Exception {
		assertThat(sut.countBall(123)).isNotNull();
	}

	@Test
	void ifThereAreNoMatchingNumbersThenReturnNothing() throws Exception {
		BallCount ballCount = sut.countBall(123);
		assertBallCounts(ballCount, 0,0);
	}

	@Test
	void ifOneNumberMatchesThenReturnOneBall() throws Exception {
		BallCount ballCount = sut.countBall(923);
		assertBallCounts(ballCount, 1,0);
	}

	private static void assertBallCounts(BallCount ballCount, int balls, int strikes) {
		assertThat(ballCount.getBalls()).isEqualTo(balls);
		assertThat(ballCount.getStrikes()).isEqualTo(strikes);
	}




}
