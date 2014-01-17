package com.ebay.rps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.ebay.rps.GameResult.DRAW;
import static com.ebay.rps.GameResult.PLAYER1_WINS;
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
public class CheckPlayer1WinsJUnitTest {

    private final Gesture gesture1;
    private final Gesture gesture2;

    Game game = new Game(GameConfig.getRulesMap().keySet(), new RuleEvaluator(GameConfig.getRulesMap()));

    public CheckPlayer1WinsJUnitTest(Gesture gesture1, Gesture gesture2) {
        this.gesture1 = gesture1;
        this.gesture2 = gesture2;
    }

    @Test
    public void checkDraws() {
        GameResult gameResult = game.playRound(gesture1, gesture2);
        assertThat(gameResult, is(PLAYER1_WINS));
    }

    @Parameterized.Parameters
    public static Collection createDataForDraw() {
        return Arrays.asList(new Object[][] { { Gesture.ROCK, Gesture.FIRE },
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
                { Gesture.WATER, Gesture.FIRE }, });
    }

}
