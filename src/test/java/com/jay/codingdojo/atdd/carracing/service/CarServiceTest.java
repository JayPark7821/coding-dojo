package com.jay.codingdojo.atdd.carracing.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarServiceTest {

	private CarService sut;

	@BeforeEach
	void setUp() {
		sut = new CarService();
	}

	@Test
	void create() throws Exception {
		assertThat(sut.create("test1"))
			.isEqualTo(new CarResponse(1L, "test1"));
	}

}