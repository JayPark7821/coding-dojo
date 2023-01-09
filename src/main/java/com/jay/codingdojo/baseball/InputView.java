package com.jay.codingdojo.baseball;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.jay.codingdojo.carracing2.UserInput;

public class InputView {

	public static final Pattern pattern = Pattern.compile("^[1-9]{3}$");

	public String getUserInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해 주세요: ");
		return validateUserInput(sc.nextLine());
	}

	public String shouldContinue() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			String userInput = sc.nextLine();
			if (!List.of("1", "2").contains(userInput))
				continue;

			return userInput;
		}
	}

	private String validateUserInput(String userInput) {

		if(!pattern.matcher(userInput).matches()) {
			throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다.");
		}
		return userInput;
	}
}
