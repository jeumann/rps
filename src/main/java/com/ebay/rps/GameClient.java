package com.ebay.rps;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: jeumann
 * Date: 1/8/14
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameClient {

    public static void main (String[] args) {
        for (int i=0; i<20; i++) {
            Game game = new Game(GameConfig.getRulesMap().keySet(), new RuleEvaluator(GameConfig.getRulesMap()));
            Gesture player1 = ComputerPlayer.randomGesture();
            Gesture player2 = ComputerPlayer.randomGesture();
            GameResult result = game.playRound(player1, player2);
            System.out.println(player1 + " vs " + player2 + " -> " + result);
        }
    }
}
