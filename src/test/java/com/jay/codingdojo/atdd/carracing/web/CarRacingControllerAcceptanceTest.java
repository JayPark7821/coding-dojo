package com.jay.codingdojo.atdd.carracing.web;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.ValidatableMockMvcResponse;
import io.restassured.path.json.JsonPath;

public class CarRacingControllerAcceptanceTest {

	@BeforeEach
	void setUp() throws Exception {
		RestAssuredMockMvc.standaloneSetup();
	}

	@Test
	@DisplayName("레이싱 게임을 생성한다.")
	void create() {
		final JsonPath response = RestAssuredMockMvc.

			given()
			.contentType("application/json").

			when()
			.post("/api/jay/car-racing").

			then()
			.statusCode(200)
			.extract().jsonPath();

		assertThat(response.getLong("id")).isEqualTo(1L);
	}


}
