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
	void carCanMove() throws Exception {
		Assertions.assertDoesNotThrow(()-> sut.move());
		assertThat(sut.getCurrentPosition()).isEqualTo(1);

	}
}
