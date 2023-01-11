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

/**
 * 기능 요구사항
 *
 * 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
 * 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
 * 자동차 이름은 쉼표(,)를 기준으로 구분한다.
 * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우이다.
 * 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
 *
 *
 * ex)
 * 경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
 * pobi,crong,honux
 * 시도할 회수는 몇회인가요?
 * 2
 *
 * 실행 결과
 * pobi : -
 * crong : -
 * honux : -
 *
 * pobi : --
 * crong : -
 * honux : --
 *
 * pobi, honux가 최종 우승했습니다.
 */
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

		assertThat(response.getString("message")).isEqualTo("3 Cars Participated");
	}

	@Test
	@DisplayName("레이싱 게임을 시작한다.")
	void startRace() throws Exception {

		final JsonPath response = RestAssuredMockMvc.

			given()
			.contentType("application/json").

			when()
			.put("/api/jay/car-racing/1/start").

			then()
			.statusCode(200)
			.extract().jsonPath();

		assertThat(response.getString("message")).isEqualTo("Race Started");
	}

	@Test
	@DisplayName("레이싱의 우승자 조회")
	void getWinner () throws Exception {

		JsonPath response = RestAssuredMockMvc.

			given()
			.contentType("application/json").

			when()
			.get("/api/jay/car-racing/1/winner").

			then()
			.statusCode(200)
			.extract().jsonPath();

		assertThat(response.getString("winner")).containsAnyOf("test1", "test2", "test3");
	}









}
