package com.ebay.rps;

import java.util.Set;

public class Game {

	RuleEvaluator ruleEvaluator;
	Set<Gesture> allowedGestures;

	public Game(Set<Gesture> allowedGestures, RuleEvaluator ruleEvaluator) {
		this.allowedGestures = allowedGestures;
		this.ruleEvaluator = ruleEvaluator;
	}

	public GameResult playRound(Gesture gesturePlayerOne, Gesture gesturePlayerTwo) {
		if (gesturePlayerOne == null || gesturePlayerTwo == null) {
			throw new RuntimeException("Invalid input values");
		}

		if (allowedGestures.contains(gesturePlayerOne) && allowedGestures.contains(gesturePlayerTwo)) {
			return ruleEvaluator.determineGameResult(gesturePlayerOne, gesturePlayerTwo);
		} else {
			throw new RuntimeException("Gesture not allowed");
		}

	}
}
