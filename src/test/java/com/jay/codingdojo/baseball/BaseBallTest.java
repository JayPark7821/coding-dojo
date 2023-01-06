package com.jay.codingdojo.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseBallTest {


	@Test
	void canCreateBaseBall () throws Exception {
		assertThat(new BaseBall()).isNotNull();
	}
	
	@Test
	void baseBallCanGenerateRandomNumber () throws Exception {
		BaseBall baseBall = new BaseBall();
		IntStream.range(0,100)
				.forEach(
					i -> assertThat(baseBall.generateRandomNumber()).isBetween(99, 1000)
				);
	}
}
