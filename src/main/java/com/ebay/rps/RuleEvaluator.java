package com.ebay.rps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Arrays.asList;

public class RuleEvaluator {
	Map<Gesture, List<Gesture>> rulesMap = new HashMap<Gesture, List<Gesture>>();

	public RuleEvaluator() {
		// Map stores a gesture and a list of the gestures that the gesture beats
		rulesMap.put(Gesture.ROCK, asList(Gesture.SCISSORS, Gesture.SPONGE, Gesture.FIRE));
		rulesMap.put(Gesture.ROCK, asList(Gesture.SCISSORS,Gesture.SPONGE, Gesture.FIRE));
		rulesMap.put(Gesture.PAPER, asList(Gesture.WATER, Gesture.ROCK, Gesture.AIR));
		rulesMap.put(Gesture.SCISSORS, asList(Gesture.PAPER, Gesture.SPONGE, Gesture.AIR));
		rulesMap.put(Gesture.WATER, asList(Gesture.SCISSORS, Gesture.ROCK, Gesture.FIRE));
		rulesMap.put(Gesture.SPONGE, asList(Gesture.WATER, Gesture.PAPER, Gesture.AIR));
		rulesMap.put(Gesture.FIRE, asList(Gesture.SPONGE, Gesture.PAPER, Gesture.SCISSORS));
		rulesMap.put(Gesture.AIR, asList(Gesture.WATER, Gesture.ROCK, Gesture.FIRE));
	}

	public GameResult determineGameResult(Gesture gestureFromPlayer1,
			Gesture gestureFromPlayer2) {

		if (gestureFromPlayer1 == gestureFromPlayer2) {
			return GameResult.DRAW;
		}

		List<Gesture> loosingGestures = rulesMap.get(gestureFromPlayer1);

		if (loosingGestures != null) {
			for (Gesture loosingGesture : loosingGestures) {
				if (loosingGesture == gestureFromPlayer2) {
					return GameResult.PLAYER1_WINS;
				}
			}
			return GameResult.PLAYER2_WINS;
		}

		throw new RuntimeException("Gesture not recognized or no rules for gesture");
	}
}
