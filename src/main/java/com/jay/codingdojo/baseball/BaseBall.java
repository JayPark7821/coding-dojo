package com.jay.codingdojo.baseball;

import java.util.Random;

public class BaseBall {
	 int generateRandomNumber() {
		 Random random = new Random();
		 return random.nextInt(900) + 100;
	}

}
