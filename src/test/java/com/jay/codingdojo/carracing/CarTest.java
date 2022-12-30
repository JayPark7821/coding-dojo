package com.jay.codingdojo.carracing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	void canCreateCarWithName () throws Exception {
		assertDoesNotThrow(()->new Car("test"));
	}

	@Test
	void carNameCantBeLongerThen5 () throws Exception {
	    assertThrows(
			IllegalArgumentException.class,
			()->new Car("test12"),
			"자동차 이름은 5자를 초과할 수 없습니다."
		);
	}

}