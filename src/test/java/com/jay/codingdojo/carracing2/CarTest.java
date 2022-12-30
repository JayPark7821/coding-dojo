package com.jay.codingdojo.carracing2;

import static org.assertj.core.api.AssertionsForClassTypes.*;

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


}
