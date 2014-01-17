package com.ebay.rps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created with IntelliJ IDEA.
 * User: jeumann
 * Date: 1/8/14
 * Time: 4:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameConfig {

    public static Map<Gesture, List<Gesture>> getRulesMap() {
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
