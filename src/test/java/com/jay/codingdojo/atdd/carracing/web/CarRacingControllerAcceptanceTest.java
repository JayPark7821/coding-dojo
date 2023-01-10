package com.jay.codingdojo.atdd.carracing.web;

import static org.assertj.core.api.Assertions.*;

import org.json.JSONException;
import org.json.JSONObject;
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
	void create() throws Exception {
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

	@Test
	@DisplayName("레이싱 게임에 참여자를 추가한다.")
	void addCars() throws Exception {
		JSONObject carNames = new JSONObject();
		carNames.put("carNames", "test1,test2,test3");

		final JsonPath response = RestAssuredMockMvc.

			given()
			.contentType("application/json")
			.body(carNames).

			when()
			.post("/api/jay/car-racing/1/car").


			then()
			.statusCode(200)
			.extract().jsonPath();

		assertThat(response.getString("3 Cars Participated")).isEqualTo("1");
	}



}
