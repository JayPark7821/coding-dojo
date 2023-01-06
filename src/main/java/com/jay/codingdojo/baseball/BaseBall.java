package com.jay.codingdojo.baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class BaseBall {

	private final int randomNumber;

	private BaseBall() {
		this.randomNumber = generateRandomNumber();
	}

	public static BaseBall startBaseBallGame() {
		return new BaseBall();
	}

	int generateRandomNumber() {
		return randomDigitListGenerator().stream()
				.mapToInt(Integer::intValue)
				.reduce(0, (a, b) -> a * 10 + b);

	}

	private List<Integer> randomDigitListGenerator() {
		List<Integer> randomDigitList = new ArrayList<>();

		while(randomDigitList.size() < 3) {
			int randomDigit = new Random().nextInt(9) + 1;
			if (!randomDigitList.contains(randomDigit)) {
				randomDigitList.add(randomDigit);
			}
		}
		return randomDigitList;
	}

}
