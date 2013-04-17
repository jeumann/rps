package com.ebay.rps;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RockPaperScissorTest {

	Game game = new Game(new RuleEvaluator());

	@DataProvider(name = "Draw")
	public Object[][] createDataForDraw() {
		return new Object[][] { { Gesture.AIR }, { Gesture.FIRE },
				{ Gesture.PAPER }, { Gesture.ROCK }, { Gesture.SCISSORS },
				{ Gesture.SPONGE }, { Gesture.WATER } };
	}
	// TODO: Need to add the other combinations
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
				{ Gesture.FIRE, Gesture.PAPER }
		};
	}
	// TODO: Need to add the other combinations
	@DataProvider(name = "Player2Wins")
	public Object[][] createDataForPlayer2Wins() {
		return new Object[][] {
				{ Gesture.ROCK, Gesture.WATER },
				{ Gesture.ROCK, Gesture.AIR },
				{ Gesture.ROCK, Gesture.PAPER},
				{ Gesture.PAPER, Gesture.SCISSORS},
				{ Gesture.PAPER, Gesture.SPONGE},
				{ Gesture.PAPER, Gesture.FIRE},
				{ Gesture.WATER, Gesture.SPONGE},
				{ Gesture.WATER, Gesture.PAPER},
				{ Gesture.WATER, Gesture.AIR}
		};
	}

	@DataProvider(name = "nullInputValues")
	public Object[][] createDataForInputValues() {
		return new Object[][] {
				{ Gesture.ROCK, null },
				{ null, Gesture.AIR }
		};
	}

	@Test(dataProvider = "Draw")
	public void checkDraws(Gesture gesture) {
		GameResult gameResult = game.playRound(gesture, gesture);
		assertThat(gameResult, is(GameResult.DRAW));
	}

	@Test(dataProvider = "Player1Wins")
	public void playerOneWins(Gesture gesturePlayer1, Gesture gesturePlayer2) {
		GameResult gameResult = game.playRound(gesturePlayer1, gesturePlayer2);
		assertThat(gameResult, is(GameResult.PLAYER1_WINS));
	}

	@Test(dataProvider = "Player2Wins")
	public void playerTwoWins(Gesture gesturePlayer1, Gesture gesturePlayer2) {
		GameResult gameResult = game.playRound(gesturePlayer1, gesturePlayer2);
		assertThat(gameResult, is(GameResult.PLAYER2_WINS));
	}

	@Test(dataProvider = "nullInputValues", expectedExceptions=RuntimeException.class)
	public void checkForNullInputValues(Gesture gesturePlayer1, Gesture gesturePlayer2) {
		game.playRound(gesturePlayer1, gesturePlayer2);
	}
}
