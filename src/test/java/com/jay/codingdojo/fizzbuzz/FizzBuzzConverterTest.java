package com.jay.codingdojo.fizzbuzz;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Write a program that prints the numbers from 1 to 100.
 * But for multiples of three print “Fizz” instead of the number
 * and for the multiples of five print “Buzz”.
 * For numbers which are multiples of both three and five print “FizzBuzz “.
 *
 * sample output:
 * 1
 * 2
 * Fizz
 * 4
 * Buzz
 * Fizz
 * 7
 * 8
 * Fizz
 * Buzz
 * 11
 * Fizz
 * 13
 * 14
 * FizzBuzz
 * 16
 *
 * Stage2 - new requirements:
 * A number is fizz if it is divisible by 3 or if it has a 3 in it
 * A number is buzz if it is divisible by 5 or if it has a 5 in it
 */
public class FizzBuzzConverterTest {

	private FizzBuzzConverter sut;

	@BeforeEach
	void setUp() {
		sut = new FizzBuzzConverter();
	}

	@Test
	void fizzBuzzConverterCanConvertMultiplesOfThreeToFizz() {
		assertThat(sut.convert(3)).isEqualTo("FizzFizz");
	}

	@Test
	void fizzBuzzConverterCanConvertMultiplesOfFiveToFizz() {
		assertThat(sut.convert(5)).isEqualTo("BuzzBuzz");
	}

	@Test
	void fizzBuzzConverterCanConvertMultiplesOfThreeAndFiveToFizzBuzz() {
		assertThat(sut.convert(15)).isEqualTo("FizzBuzzBuzz");
	}

	@Test
	void fizzBuzzConverterSholudReturnsGivenNumber() {
		IntStream.range(0, 100)
			.filter(i -> i % 3 != 0 && i % 5 != 0)
			.filter(i -> !String.valueOf(i).contains("3") && !String.valueOf(i).contains("5"))
			.forEach(i -> assertThat(sut.convert(i)).isEqualTo(String.valueOf(i)));
	}

	@Test
	void fizzBuzzConverterCanConvertNumbersWithThreeToFizz() {
		assertThat(sut.convert(13)).isEqualTo("Fizz");
	}

	@Test
	void test() {
		IntStream.range(1, 101)
			.mapToObj(sut::convert)
			.forEach(System.out::println);
	}


}
