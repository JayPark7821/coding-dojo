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
}
