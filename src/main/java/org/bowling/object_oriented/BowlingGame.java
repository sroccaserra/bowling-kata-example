package org.bowling.object_oriented;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    public static final int NB_FRAMES = 10;

    private final List<Integer> rolls = new ArrayList<>();

    public int score() {
        List<Frame> frames = new ArrayList<>();
        List<Integer> rest = rolls;
        for (int frameNumber = 0; frameNumber < NB_FRAMES; ++frameNumber) {
            Frame frame = Frame.createFor(rest);
            frames.add(frame);
            rest = rest.subList(frame.nbRolls, rest.size());
        }

        return frames.stream().reduce(0, (sum, frame) -> sum + frame.score, Integer::sum);
    }

    public void roll(int nbPins) {
        rolls.add(nbPins);
    }
}