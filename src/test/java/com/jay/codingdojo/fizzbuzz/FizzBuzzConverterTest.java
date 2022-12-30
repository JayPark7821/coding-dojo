package com.jay.codingdojo.fizzbuzz;

import static org.assertj.core.api.Assertions.*;

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
 */
public class FizzBuzzConverterTest {

	private FizzBuzzConverter sut;

	@BeforeEach
	void setUp() {
		sut = new FizzBuzzConverter();
	}

	@Test
	void fizzBuzzConverterCanConvertMultiplesOfThreeToFizz() {
		assertThat(sut.convert(3)).isEqualTo("Fizz");
	}
}
