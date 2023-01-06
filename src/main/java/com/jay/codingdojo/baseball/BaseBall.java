package com.jay.codingdojo.baseball;

public class BaseBall {
	 int generateRandomNumber() {
		 double randomNumber = Math.random() * 1000;
		 return randomNumber < 100 ? (int) (randomNumber * 10 ) : (int) randomNumber;
	}
}
