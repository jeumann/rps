package com.ebay.rps;

import java.util.HashMap;
import java.util.Map;

public class RuleEvaluator {
	Map<Gesture, Gesture[]> rulesMap = new HashMap<Gesture, Gesture[]>();

	public RuleEvaluator() {
		// Map stores a gesture and an array of the gestures that are beaten by the gesture
		rulesMap.put(Gesture.ROCK, new Gesture[] { Gesture.SCISSORS,
				Gesture.SPONGE, Gesture.FIRE });
		rulesMap.put(Gesture.PAPER, new Gesture[] { Gesture.WATER,
				Gesture.ROCK, Gesture.AIR });
		rulesMap.put(Gesture.SCISSORS, new Gesture[] { Gesture.PAPER,
				Gesture.SPONGE, Gesture.AIR });
		rulesMap.put(Gesture.WATER, new Gesture[] { Gesture.SCISSORS,
				Gesture.ROCK, Gesture.FIRE });
		rulesMap.put(Gesture.SPONGE, new Gesture[] { Gesture.WATER,
				Gesture.PAPER, Gesture.AIR });
		rulesMap.put(Gesture.FIRE, new Gesture[] { Gesture.SPONGE,
				Gesture.PAPER, Gesture.SCISSORS });
		rulesMap.put(Gesture.AIR, new Gesture[] { Gesture.WATER, Gesture.ROCK,
				Gesture.FIRE });
	}

	public GameResult determineGameResult(Gesture gestureFromPlayer1,
			Gesture gestureFromPlayer2) {

		if (gestureFromPlayer1 == gestureFromPlayer2) {
			return GameResult.DRAW;
		}

		Gesture[] loosingGestures = rulesMap.get(gestureFromPlayer1);

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
