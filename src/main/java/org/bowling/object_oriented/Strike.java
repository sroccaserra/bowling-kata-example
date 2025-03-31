package org.bowling.object_oriented;

public class Strike extends Frame {
    private Strike(int bonus) {
        super(MAX_PINS + bonus, 1);
    }

    public static Strike withBonus(int bonus) {
        return new Strike(bonus);
    }
}