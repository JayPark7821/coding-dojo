package com.jay.codingdojo.carracing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {
	private String[] carName;
	private int tryCount;

	public UserInput(String carName, int tryCount) {
		this.carName = carName.split(",");
		this.tryCount = tryCount;
	}

	public String[] getCarName() {
		return carName;
	}

	public int getTryCount() {
		return tryCount;
	}
}
