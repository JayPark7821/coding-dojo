package com.jay.codingdojo.rentacar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 기능 요구사항
 * 우리 회사는 렌터카를 운영하고 있다. 현재 보유하고 있는 차량은 Sonnata 2대, Avante 1대, K5 1대로 총 5대의 차량을 보유하고 있다.
 * 우리 회사는 고객이 인터넷으로부터 예약할 때 여행할 목적지의 대략적인 이동거리를 입력 받는다.
 * 이 이동거리를 활용해 차량 별로 필요한 연료를 주입한다.
 * <p>
 * 차량 별로 주입해야 할 연료량을 확인할 수 있는 보고서를 생성해야 한다.
 * <p>
 * 각 차량별 연비는 다음과 같다.
 * sonnata : 10km/l
 * avante : 15km/l
 * k5 : 12km/l
 */
public class RentACarTest {

	private RentACar sut;

	@BeforeEach
	void setUp() {
		sut = new RentACar();
	}

	@Test
	void canCreateRentACar() throws Exception {
		assertThat(sut).isNotNull();
	}
}
