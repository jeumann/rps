package com.ebay.rps;

import java.util.List;
import java.util.Map;

public class RuleEvaluator {
	Map<Gesture, List<Gesture>> rulesMap;

	public RuleEvaluator(Map<Gesture, List<Gesture>> rulesMap) {
		this.rulesMap = rulesMap;
	}

	public GameResult determineGameResult(Gesture gestureFromPlayer1,
			Gesture gestureFromPlayer2) {

		if (gestureFromPlayer1 == gestureFromPlayer2) {
			return GameResult.DRAW;
		}

		if (rulesMap.get(gestureFromPlayer1).contains(gestureFromPlayer2)) {
			return GameResult.PLAYER1_WINS;
		} else {
			return GameResult.PLAYER2_WINS;
		}
	}
}
