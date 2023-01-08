package com.jay.codingdojo.baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomNumberServiceImplTest {

	private RandomNumberServiceImpl sut;
	private static final Pattern pattern = Pattern.compile("^[0-9]{3}$");

	@BeforeEach
	void setUp() {
		sut = new RandomNumberServiceImpl();
	}


	@Test
	void baseBallCanGenerateRandomNumber () throws Exception {
		IntStream.range(0,100)
			.forEach(i -> assertThat(pattern.matcher(sut.generateRandomNumber()).matches()).isTrue());
	}

	@Test
	void baseBallCanGenerateRandomNumberWithNoRepetition () throws Exception {
		IntStream.range(0,100)
			.forEach(i -> checkIfThereIsARepetition(sut.generateRandomNumber()));
	}

	private void checkIfThereIsARepetition(String randomNumber) {
 		IntStream.range(0,randomNumber.length())
			.forEach(
				i -> {
					char digit = randomNumber.charAt(i);
					assertThat(randomNumber.indexOf(digit)).isEqualTo(randomNumber.lastIndexOf(digit));
				}
			);
	}
}