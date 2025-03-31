package org.bowling.object_oriented;

public class RegularFrame extends Frame {
    private RegularFrame(int score) {
        super(score, 2);
    }

    public static RegularFrame withScore(int score) {
        return new RegularFrame(score);
    }
}