package com.jay.codingdojo.carracing;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 기능 요구사항
 *
 * 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
 * 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
 * 자동차 이름은 쉼표(,)를 기준으로 구분한다.
 * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우이다.
 * 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
 */
class CarTest {

	@Test
	void canCreateCarWithName () throws Exception {
		assertDoesNotThrow(()->new Car("test"));
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


	@Test
	void carCanMove () throws Exception {
		Car car = new Car("test");
		car.move();
		assertThat(car.showPosition()).isEqualTo("test : -");
	}


}