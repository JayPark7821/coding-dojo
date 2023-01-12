package com.jay.codingdojo.atdd.carracing.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jay.codingdojo.atdd.carracing.domain.Car;
import com.jay.codingdojo.atdd.carracing.domain.CarRepository;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

	private CarService sut;
	@Mock
	private CarRepository repository;

	@BeforeEach
	void setUp() {
		sut = new CarService(repository);
	}

	@Test
	void create() throws Exception {

		given(repository.save(any(Car.class)))
			.willReturn(new Car(1L, "test1"));

		assertThat(sut.create("test1"))
			.isEqualTo(new Car(1L, "test1"));
	}

	@Test
	void create_when_name_is_less_then_1_and_more_then5() throws Exception {
		assertThatThrownBy(() -> sut.create(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("Car name must be between 1 and 5 characters");

		assertThatThrownBy(() -> sut.create("test1234567"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("Car name must be between 1 and 5 characters");
	}

}