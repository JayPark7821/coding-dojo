package com.jay.codingdojo.atdd.tennis.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static org.assertj.core.api.Assertions.assertThat;

// 모든 컨트롤러가 연결된 시점에 springboottest로 전환
// 프로젝트가 무겁다면 조금 타협을...
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TennisGameControllerAcceptanceTest {

	@LocalServerPort
	private int port;

	@BeforeEach
	void setUp() {
		RestAssured.port = port; // 테스트 격리를 위해
	}

	@Test
	void create() {
		final JsonPath response = RestAssured.

			given()
			.contentType(ContentType.JSON).

			when()
			.post("/api/jay/tennis-game").

			then()
			.statusCode(200)
			.extract().jsonPath();

		assertExpectedResponse(response, 1L, 0, 0, "STARTED");
	}


	@Test
	void serverScores() {
		final JsonPath response = RestAssured.

			given()
			.contentType(ContentType.JSON).

			when()
			.post("/api/jay/tennis-game/3/score/server").

			then()
			.statusCode(200)
			.extract().jsonPath();

		assertExpectedResponse(response, 2L, 1, 0, "STARTED");
	}

	@Test
	void receiverScores() {
		final JsonPath response = RestAssured.

			given()
			.contentType(ContentType.JSON).

			when()
			.post("/api/jay/tennis-game/1/score/receiver").

			then()
			.statusCode(200)
			.extract().jsonPath();

		assertExpectedResponse(response, 3L, 0, 1, "STARTED");
	}


	private void assertExpectedResponse(final JsonPath response, final long gameId, final int server, final int receiver, final String status) {
		assertThat(response.getLong("gameId")).isEqualTo(gameId);
		assertThat(response.getInt("server")).isGreaterThanOrEqualTo(server);
		assertThat(response.getInt("receiver")).isGreaterThanOrEqualTo(receiver);
		assertThat(response.getString("status")).isEqualTo(status);
	}
}
