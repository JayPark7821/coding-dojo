package com.jay.codingdojo.movie;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieTest {

	private Movie sut;
	
	@BeforeEach
	void setUp() {
		sut = new Movie("test movie");
	}
	
	@Test
	void shouldReturn0WhenThereIsNoRating () throws Exception {
		assertThat(sut.getRating()).isEqualTo(0);
	}
}
