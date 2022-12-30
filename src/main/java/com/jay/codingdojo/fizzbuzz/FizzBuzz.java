package com.jay.codingdojo.fizzbuzz;

import java.util.Arrays;

public enum FizzBuzz {
	FIZZ(3, "Fizz"),
	BUZZ(5, "Buzz"),
	;

	private int number;
	private String word;

	FizzBuzz(int number, String word) {
		this.number = number;
		this.word = word;
	}

	public int getNumber() {
		return number;
	}

	public String getNumberInString() {
		return String.valueOf(number);
	}

	public String getWord() {
		return word;
	}

	public FizzBuzz of(int number) {
		return Arrays.stream(FizzBuzz.values())
			.filter(fizzBuzz -> number % fizzBuzz.number == 0)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("Invalid number"));
	}
}
