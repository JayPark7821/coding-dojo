package com.jay.codingdojo.fizzbuzz;

public class FizzBuzzConverter {

	public String convert(int number) {
		String convtertedString = "";

		if(number % 3 == 0) {
			convtertedString += "Fizz";
		}
		if(number % 5 == 0) {
			convtertedString += "Buzz";
		}
		return convtertedString.isEmpty() ? String.valueOf(number) : convtertedString;
	}
}
