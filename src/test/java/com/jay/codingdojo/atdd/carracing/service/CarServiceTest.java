package com.jay.codingdojo.atdd.carracing.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.jay.codingdojo.atdd.carracing.domain.Car;
import com.jay.codingdojo.atdd.carracing.domain.CarRacing;
import com.jay.codingdojo.atdd.carracing.domain.CarRepository;

@DataJpaTest
@Import({CarService.class, CarRepository.class})
class CarServiceTest {

	@Autowired
	private CarService sut;

	@Test
	void create() throws Exception {

		CarRacing carRacing = new CarRacing();

		assertThat(sut.create("car1,car2", carRacing))
			.isEqualTo(List.of(new Car(1L, "car1", carRacing), new Car(2L, "car2", carRacing)));
	}

	@Test
	void create_when_name_is_less_then_1_and_more_then5() throws Exception {
		CarRacing carRacing = new CarRacing();
		assertThatThrownBy(() -> sut.create("", carRacing))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("Car name must be between 1 and 5 characters");

		assertThatThrownBy(() -> sut.create("test1234567", carRacing))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("Car name must be between 1 and 5 characters");
	}

}