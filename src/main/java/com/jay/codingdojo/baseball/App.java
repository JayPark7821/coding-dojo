package com.jay.codingdojo.baseball;

public class App {

	private static final String GAME_START = "1";
	private static final String GAME_END = "2";
	public static void main(String[] args) {

		InputView inputView = new InputView();
		OutPutView outPutView = new OutPutView();
		String gameStatus = GAME_START;

		while (gameStatus == GAME_START) {
			playBaseBallGame(inputView, outPutView);
			gameStatus = inputView.shouldContinue();
		}

	}

	private static void playBaseBallGame(InputView inputView, OutPutView outPutView) {
		BaseBall baseBall = BaseBall.startBaseBallGame();

		while (true) {
			BallCount ballCount = baseBall.countBall(inputView.getUserInput());
			outPutView.printBallCount(ballCount);
			if (ballCount.getStrikes() == 3) {
				outPutView.finishGame();
				break;
			}

		}
	}
}
