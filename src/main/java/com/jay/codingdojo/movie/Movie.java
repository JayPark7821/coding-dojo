package com.jay.codingdojo.movie;

public class Movie {

	private final String title;

	public Movie(String title) {
		this.title = title;
	}

	public int getRating() {
		throw new UnsupportedOperationException("com.jay.codingdojo.movie.Movie.getRating())");
	}
}
