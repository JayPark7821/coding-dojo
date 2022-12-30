package com.jay.codingdojo.fizzbuzz;

public class FizzBuzzConverter {

	public String convert(int number) {
		if(number % 3 == 0) {
			return "Fizz";
		}
		return String.valueOf(number);
	}
}
