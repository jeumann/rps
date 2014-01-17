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
public class CheckDrawsJUnitTest {

    private final Gesture gesture;

    Game game = new Game(GameConfig.getRulesMap().keySet(), new RuleEvaluator(GameConfig.getRulesMap()));

    public CheckDrawsJUnitTest(Gesture gesture) {
        this.gesture = gesture;
    }

    @Test
    public void checkDraws() {
        GameResult gameResult = game.playRound(gesture, gesture);
        assertThat(gameResult, is(DRAW));
    }

    @Parameterized.Parameters
     public static Collection createDataForDraw() {
        return Arrays.asList(new Object[][]{{Gesture.AIR}, {Gesture.FIRE},
                {Gesture.PAPER}, {Gesture.ROCK}, {Gesture.SCISSORS},
                {Gesture.SPONGE}, {Gesture.WATER}});
    }

}
