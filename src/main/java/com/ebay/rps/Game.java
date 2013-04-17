package com.ebay.rps;

public class Game {

	RuleEvaluator ruleEvaluator;

	public Game(RuleEvaluator ruleEvaluator) {
		this.ruleEvaluator = ruleEvaluator;
	}

	public GameResult playRound(Gesture gesturePlayerOne, Gesture gesturePlayerTwo) {
		if (gesturePlayerOne == null || gesturePlayerTwo == null) {
			throw new RuntimeException("Invalid input values");
		}
		return ruleEvaluator.determineGameResult(gesturePlayerOne, gesturePlayerTwo);
	}
}
