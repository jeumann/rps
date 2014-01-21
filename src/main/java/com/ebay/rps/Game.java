package com.ebay.rps;

import java.util.Set;

public class Game {

	RuleEvaluator ruleEvaluator;

	public Game (RuleEvaluator ruleEvaluator) {
		this.ruleEvaluator = ruleEvaluator;
	}

	public GameResult playRound(Gesture gesturePlayerOne, Gesture gesturePlayerTwo) {
		if (gesturePlayerOne == null || gesturePlayerTwo == null) {
			throw new RuntimeException("Invalid input values");
		}

		if (isGestureValid(gesturePlayerOne) && isGestureValid(gesturePlayerTwo)) {
			return ruleEvaluator.determineGameResult(gesturePlayerOne, gesturePlayerTwo);
		} else {
			throw new RuntimeException("Gesture not allowed");
		}

	}

    private boolean isGestureValid(Gesture gesturePlayerOne) {
        return GameConfig.getRulesMap().keySet().contains(gesturePlayerOne);
    }
}
