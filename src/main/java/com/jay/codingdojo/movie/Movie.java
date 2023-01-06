package com.jay.codingdojo.movie;

import java.util.ArrayList;
import java.util.List;

public class Movie {

	private final String title;
	private final List<Integer> rating = new ArrayList<>();

	public Movie(String title) {
		this.title = title;
	}

	public double getRating() {
		return rating.stream().mapToInt(Integer::intValue).average().orElse(0);
	}

	public void rate(int rating) {
		this.rating.add(rating);
	}
}
