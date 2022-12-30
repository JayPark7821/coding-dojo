package com.jay.codingdojo.fizzbuzz;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FizzBuzzConverter {

	public String convert(int number) {

		String convertedString = Arrays.stream(FizzBuzz.values())
			.map(baseNum -> converter(number, baseNum)).collect(Collectors.joining());

		return convertedString.isEmpty() ? String.valueOf(number) : convertedString;

	}

	private static String converter(int number, FizzBuzz fizzBuzz) {
		String convertedString = "";
		if(String.valueOf(number).contains(fizzBuzz.getNumberInString())) {
			convertedString += fizzBuzz.getWord();
		}
		if(number % fizzBuzz.getNumber() == 0) {
			convertedString += fizzBuzz.getWord();
		}
		return convertedString;
	}

}
