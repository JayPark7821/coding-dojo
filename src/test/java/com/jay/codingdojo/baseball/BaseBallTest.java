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
	void baseBallCanCountBallFromUserInput() throws Exception {
		assertThat(sut.countBall(123)).isNotNull();
	}

	@Test
	void ifThereAreNoMatchingNumbersThenReturnNothing() throws Exception {
		assertThat(sut.countBall(123)).isEqualTo(new BallCount(0,0));
	}

	@Test
	void ifOneNumberMatchesThenReturnOneBall() throws Exception {
		assertThat(sut.countBall(123)).isEqualTo(new BallCount(1,0));
	}




}
