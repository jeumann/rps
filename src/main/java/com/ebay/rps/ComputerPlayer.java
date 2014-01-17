package com.ebay.rps;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: jeumann
 * Date: 1/8/14
 * Time: 5:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComputerPlayer {

    private static final List<Gesture> VALUES =
            Collections.unmodifiableList(Arrays.asList(Gesture.values()));
    private static final Random RANDOM = new Random();

    public static Gesture randomGesture()  {
        return VALUES.get(RANDOM.nextInt(VALUES.size()));
    }
}
