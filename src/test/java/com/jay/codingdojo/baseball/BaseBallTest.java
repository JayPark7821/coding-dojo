package com.jay.codingdojo.baseball;

import static org.assertj.core.api.Assertions.*;

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
		assertThat(baseBall.generateRandomNumber()).isGreaterThan(99);
	}
}
