package com.ebay.rps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static com.ebay.rps.GameResult.*;
import static java.util.Arrays.asList;

public class RockPaperScissorTest {

	Game game = new Game(createAllowedGestures(), new RuleEvaluator(createRulesMap()));

	@Test(dataProvider = "Draw")
	public void checkDraws(Gesture gesture) {
		GameResult gameResult = game.playRound(gesture, gesture);
		assertThat(gameResult, is(DRAW));
	}

	@Test(dataProvider = "Player1Wins")
	public void playerOneWins(Gesture gesturePlayer1, Gesture gesturePlayer2) {
		GameResult gameResult = game.playRound(gesturePlayer1, gesturePlayer2);
		assertThat(gameResult, is(PLAYER1_WINS));
	}

	@Test(dataProvider = "Player2Wins")
	public void playerTwoWins(Gesture gesturePlayer1, Gesture gesturePlayer2) {
		GameResult gameResult = game.playRound(gesturePlayer1, gesturePlayer2);
		assertThat(gameResult, is(PLAYER2_WINS));
	}

	@Test(dataProvider = "nullInputValues", expectedExceptions = RuntimeException.class)
	public void checkForNullInputValues(Gesture gesturePlayer1,
			Gesture gesturePlayer2) {
		game.playRound(gesturePlayer1, gesturePlayer2);
	}

	@DataProvider(name = "Draw")
	public Object[][] createDataForDraw() {
		return new Object[][] { { Gesture.AIR }, { Gesture.FIRE },
				{ Gesture.PAPER }, { Gesture.ROCK }, { Gesture.SCISSORS },
				{ Gesture.SPONGE }, { Gesture.WATER } };
	}

	@DataProvider(name = "Player1Wins")
	public Object[][] createDataForPlayer1Wins() {
		return new Object[][] { { Gesture.ROCK, Gesture.FIRE },
				{ Gesture.ROCK, Gesture.SCISSORS },
				{ Gesture.ROCK, Gesture.SPONGE },
				{ Gesture.PAPER, Gesture.AIR },
				{ Gesture.PAPER, Gesture.ROCK },
				{ Gesture.PAPER, Gesture.WATER },
				{ Gesture.FIRE, Gesture.SCISSORS },
				{ Gesture.FIRE, Gesture.SPONGE },
				{ Gesture.FIRE, Gesture.PAPER },
				{ Gesture.SCISSORS, Gesture.SPONGE },
				{ Gesture.SCISSORS, Gesture.PAPER },
				{ Gesture.SCISSORS, Gesture.AIR },
				{ Gesture.SPONGE, Gesture.WATER },
				{ Gesture.SPONGE, Gesture.PAPER },
				{ Gesture.SPONGE, Gesture.AIR },
				{ Gesture.AIR, Gesture.WATER }, { Gesture.AIR, Gesture.ROCK },
				{ Gesture.AIR, Gesture.FIRE }, { Gesture.WATER, Gesture.ROCK },
				{ Gesture.WATER, Gesture.SCISSORS },
				{ Gesture.WATER, Gesture.FIRE }, };
	}

	@DataProvider(name = "Player2Wins")
	public Object[][] createDataForPlayer2Wins() {
		return new Object[][] { { Gesture.ROCK, Gesture.WATER },
				{ Gesture.ROCK, Gesture.AIR }, { Gesture.ROCK, Gesture.PAPER },
				{ Gesture.PAPER, Gesture.SCISSORS },
				{ Gesture.PAPER, Gesture.SPONGE },
				{ Gesture.PAPER, Gesture.FIRE },
				{ Gesture.WATER, Gesture.SPONGE },
				{ Gesture.WATER, Gesture.PAPER },
				{ Gesture.WATER, Gesture.AIR }, { Gesture.AIR, Gesture.PAPER },
				{ Gesture.AIR, Gesture.SCISSORS },
				{ Gesture.AIR, Gesture.SPONGE },
				{ Gesture.SPONGE, Gesture.FIRE },
				{ Gesture.SPONGE, Gesture.SCISSORS },
				{ Gesture.SPONGE, Gesture.ROCK },
				{ Gesture.SCISSORS, Gesture.FIRE },
				{ Gesture.SCISSORS, Gesture.WATER },
				{ Gesture.SCISSORS, Gesture.ROCK },
				{ Gesture.FIRE, Gesture.AIR }, { Gesture.FIRE, Gesture.WATER },
				{ Gesture.FIRE, Gesture.ROCK }, };
	}

	@DataProvider(name = "nullInputValues")
	public Object[][] createDataForInputValues() {
		return new Object[][] { { Gesture.ROCK, null }, { null, Gesture.AIR } };
	}
	
	private List<Gesture> createAllowedGestures() {
		List<Gesture> allowedGestures = new ArrayList<Gesture>();
		allowedGestures.add(Gesture.AIR);
		allowedGestures.add(Gesture.SCISSORS);
		allowedGestures.add(Gesture.FIRE);
		allowedGestures.add(Gesture.PAPER);
		allowedGestures.add(Gesture.ROCK);
		allowedGestures.add(Gesture.SPONGE);
		allowedGestures.add(Gesture.WATER);
		return allowedGestures;
	}
	
	private Map<Gesture, List<Gesture>> createRulesMap() {
		Map<Gesture, List<Gesture>> rulesMap = new HashMap<Gesture, List<Gesture>>();
		rulesMap.put(Gesture.ROCK, asList(Gesture.SCISSORS, Gesture.SPONGE, Gesture.FIRE));
		rulesMap.put(Gesture.PAPER, asList(Gesture.WATER, Gesture.ROCK, Gesture.AIR));
		rulesMap.put(Gesture.SCISSORS, asList(Gesture.PAPER, Gesture.SPONGE, Gesture.AIR));
		rulesMap.put(Gesture.WATER, asList(Gesture.SCISSORS, Gesture.ROCK, Gesture.FIRE));
		rulesMap.put(Gesture.SPONGE, asList(Gesture.WATER, Gesture.PAPER, Gesture.AIR));
		rulesMap.put(Gesture.FIRE, asList(Gesture.SPONGE, Gesture.PAPER, Gesture.SCISSORS));
		rulesMap.put(Gesture.AIR, asList(Gesture.WATER, Gesture.ROCK, Gesture.FIRE));
		return rulesMap;
	}
}
