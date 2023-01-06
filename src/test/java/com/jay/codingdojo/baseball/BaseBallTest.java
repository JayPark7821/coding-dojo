package com.jay.codingdojo.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseBallTest {

	private BaseBall sut;

	@BeforeEach
	void setUp() {
		sut = BaseBall.startBaseBallGame();
	}

	@Test
	void baseBallCanGenerateRandomNumber () throws Exception {
		IntStream.range(0,100)
				.forEach(
					i -> assertThat(sut.generateRandomNumber()).isBetween(99, 1000)
				);
	}

	@Test
	void baseBallCanGenerateRandomNumberWithNoRepetition () throws Exception {
		IntStream.range(0,100)
				.forEach(
					i -> {
						checkIfThereIsARepetition(sut.generateRandomNumber());
					}
				);
	}

	@Test
	void baseBallCanCountBallFromUserInput() throws Exception {
		assertThat(sut.countBall(123)).isNotNull();
	}

	private void checkIfThereIsARepetition(int randomNumber) {
		String randomNumberString = String.valueOf(randomNumber);

		IntStream.range(0,randomNumberString.length())
				.forEach(
					i -> {
						char digit = randomNumberString.charAt(i);
						assertThat(randomNumberString.indexOf(digit)).isEqualTo(randomNumberString.lastIndexOf(digit));
					}
				);
	}
}
