package org.bowling.object_oriented;

import java.util.List;

public abstract class Frame {
    public static final int MAX_PINS = 10;

    public final int score;
    public final int nbRolls;

    protected Frame(int score, int nbRolls) {
        this.score = score;
        this.nbRolls = nbRolls;
    }

    public static Frame createFor(List<Integer> rolls) {
        var firstRoll = rolls.getFirst();
        var nextRoll = rolls.get(1);
        if (firstRoll == MAX_PINS) {
            return Strike.withBonus(nextRoll + rolls.get(2));
        }
        if (firstRoll + nextRoll == MAX_PINS) {
            return Spare.withBonus(rolls.get(2));
        }
        return RegularFrame.withScore(firstRoll + nextRoll);
    }
}