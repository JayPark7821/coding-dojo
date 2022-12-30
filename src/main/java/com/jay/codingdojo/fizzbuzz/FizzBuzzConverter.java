package com.jay.codingdojo.fizzbuzz;

public class FizzBuzzConverter {

	public String convert(int number) {
		if(number % 3 == 0) {
			return "Fizz";
		}else if(number % 5 == 0) {
			return "Buzz";
		}
		return String.valueOf(number);
	}
}
