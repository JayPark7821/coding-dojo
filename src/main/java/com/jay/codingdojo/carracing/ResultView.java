package com.jay.codingdojo.carracing;

public class ResultView {

	public ResultView() {
		System.out.println("실행 결과");
	}

	public void printResult(String currentPosition) {
		System.out.println(currentPosition);
		System.out.println("\n");
	}

	public void printWinner(String winner) {
		System.out.println(winner + "가 최종 우승했습니다.");
	}
}
