package com.jay.codingdojo.atdd.tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.path.json.JsonPath;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class TennisGameControllerAcceptanceTest {

	@BeforeEach
	void setUp() {
		RestAssuredMockMvc.standaloneSetup();
	}

	@Test
	void create() {
		final JsonPath response = RestAssuredMockMvc.

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
		final JsonPath response = RestAssuredMockMvc.

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
		final JsonPath response = RestAssuredMockMvc.

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
