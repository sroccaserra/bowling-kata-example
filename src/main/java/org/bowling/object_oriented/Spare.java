package org.bowling.object_oriented;

public class Spare extends Frame {
    private Spare(int bonus) {
        super(MAX_PINS + bonus, 2);
    }

    public static Spare withBonus(int bonus) {
        return new Spare(bonus);
    }
}