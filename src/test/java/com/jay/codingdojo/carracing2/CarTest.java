package com.jay.codingdojo.carracing2;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CarTest {

	private Car sut;

	@BeforeEach
	void setUp() throws Exception {
		sut = new Car("test");
	}

	@Test
	void carCanOnlyMoveRandomNumberIsLargerThen3() throws Exception {
		Assertions.assertDoesNotThrow(()-> sut.move(2));
		assertThat(sut.getCurrentPosition()).isEqualTo(0);
		Assertions.assertDoesNotThrow(()-> sut.move(5));
		assertThat(sut.getCurrentPosition()).isEqualTo(1);
	}


	@Test
	void carNameLengthShouldBetween0to5 () throws Exception {
		assertThrows(
			IllegalArgumentException.class,
			()->new Car(""),
			"자동차 이름은 0~5자만 허용 합니다."
		);
		assertThrows(
			IllegalArgumentException.class,
			()->new Car("test12"),
			"자동차 이름은 0~5자만 허용 합니다."
		);
	}


}
