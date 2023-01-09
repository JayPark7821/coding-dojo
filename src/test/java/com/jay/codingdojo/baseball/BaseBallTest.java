package com.jay.codingdojo.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseBallTest {

	private BaseBall sut;
	private final RandomNumberService service = new RandomNumberServiceImpl();

	@BeforeEach
	void setUp() {
		sut = new BaseBall(service);
	}

	@Test
	void baseBallCanCountBallFromUserInput() throws Exception {
		assertThat(sut.countBall("123")).isNotNull();
	}

	@Test
	void userShouldInputThreeDigits() throws Exception {
		assertThatThrownBy(() -> sut.countBall("12")).isExactlyInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> sut.countBall("4312")).isExactlyInstanceOf(IllegalArgumentException.class);
	}




}
