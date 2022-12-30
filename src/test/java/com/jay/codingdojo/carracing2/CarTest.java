package com.jay.codingdojo.carracing2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CarTest {

	@Test
	void canCreateCars() throws Exception {
		Assertions.assertDoesNotThrow(()->new Car("test"));
	}
}
