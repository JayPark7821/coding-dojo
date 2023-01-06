package com.jay.codingdojo.baseball;

import java.util.List;
import java.util.Scanner;

import com.jay.codingdojo.carracing2.UserInput;

public class InputView {

	public int getUserInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해 주세요: ");
		String userInput = sc.nextLine();
		return Integer.parseInt(userInput);
	}

	public int shouldContinue() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			String userInput = sc.nextLine();
			if (!List.of("1", "2").contains(userInput))
				continue;

			return Integer.parseInt(userInput);
		}
	}
}
