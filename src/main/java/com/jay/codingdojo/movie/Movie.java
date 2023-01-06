package com.jay.codingdojo.movie;

public class Movie {

	private final String title;
	private int rating;

	public Movie(String title) {
		this.title = title;
		this.rating = 0;
	}

	public int getRating() {
		return this.rating;
	}

	public void rate(int rating) {
		this.rating = rating;
	}
}
