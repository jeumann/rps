package com.ebay.rps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.ebay.rps.GameResult.DRAW;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created with IntelliJ IDEA.
 * User: jeumann
 * Date: 1/8/14
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(Parameterized.class)
public class CheckInvalidInputsJUnitTest {

    private final Gesture gesturePlayer1;
    private final Gesture gesturePlayer2;

    Game game = new Game(GameConfig.getRulesMap().keySet(), new RuleEvaluator(GameConfig.getRulesMap()));

    public CheckInvalidInputsJUnitTest(Gesture gesturePlayer1, Gesture gesturePlayer2) {
        this.gesturePlayer1 = gesturePlayer1;
        this.gesturePlayer2 = gesturePlayer2;
    }

    @Test(expected=RuntimeException.class)
    public void checkInvalidInputs() {
        game.playRound(gesturePlayer1, gesturePlayer2);
    }

    @Parameterized.Parameters
     public static Collection createDataForDraw() {
        return Arrays.asList(new Object[][]{{ Gesture.ROCK, null }, { null, Gesture.AIR }});
    }

}
