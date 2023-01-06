package com.jay.codingdojo.baseball;

public class OutPutView {
	public void finishGame() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public void printBallCount(BallCount ballCount) {
		String result = "";
		if (ballCount.getStrikes() > 0)
			result += ballCount.getStrikes() + " 스트라이크 ";
		if (ballCount.getBalls() > 0)
			result += ballCount.getBalls() + " 볼";
		if (result == "")
			result = "낫싱";
		System.out.println(result);
	}
}
