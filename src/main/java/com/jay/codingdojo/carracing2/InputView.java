package com.jay.codingdojo.carracing2;

import java.util.Scanner;

public class InputView {
	public UserInput getUserInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String carName = sc.nextLine();
		System.out.println("시도할 회수는 몇회인가요?");
		int tryCount = sc.nextInt();
		return new UserInput(carName, tryCount);
	}
}
