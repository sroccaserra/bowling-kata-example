package org.bowling.structured;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    public static final int MAX_PINS = 10;
    public static final int NB_FRAMES = 10;

    private final List<Integer> rolls = new ArrayList<>();

    public void roll(int knockedPins) {
        rolls.add(knockedPins);
    }

    public int score() {
        var result = 0;
        var frameIndex = 0;
        for (var frameNumber = 0; frameNumber < NB_FRAMES; ++frameNumber) {
            if (isStrike(frameIndex)) {
                result += MAX_PINS + getStrikeBonus(frameIndex);
                frameIndex += 1;
            } else if (isSpare(frameIndex)) {
                result += MAX_PINS + getSpareBonus(frameIndex);
                frameIndex += 2;
            } else {
                result += getRegularFramePoints(frameIndex);
                frameIndex += 2;
            }
        }
        return result;
    }

    ///
    // Private functions
    private boolean isStrike(int frameIndex) {
        return MAX_PINS == rolls.get(frameIndex);
    }

    private boolean isSpare(int frameIndex) {
        return MAX_PINS == rolls.get(frameIndex) + rolls.get(frameIndex + 1);
    }

    private int getStrikeBonus(int frameIndex) {
        return rolls.get(frameIndex + 1) + rolls.get(frameIndex + 2);
    }

    private int getSpareBonus(int frameIndex) {
        return rolls.get(frameIndex + 2);
    }

    private int getRegularFramePoints(int frameIndex) {
        return rolls.get(frameIndex) + rolls.get(frameIndex + 1);
    }
}