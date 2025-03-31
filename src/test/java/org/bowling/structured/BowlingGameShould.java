package org.bowling.structured;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.bowling.structured.BowlingGame.NB_FRAMES;

public class BowlingGameShould {
    @Test
    void return_0_for_aGutterGame() {
        var bowlingGame = new BowlingGame();
        rollNbTimesWithValue(bowlingGame, 2 * NB_FRAMES, 0);

        int result = bowlingGame.score();

        assertThat(result).isEqualTo(0);
    }

    @Test
    void return_5_forRolls_3_2() {
        var bowlingGame = new BowlingGame();
        bowlingGame.roll(3);
        bowlingGame.roll(2);
        rollNbTimesWithValue(bowlingGame, 18, 0);

        int result = bowlingGame.score();

        assertThat(result).isEqualTo(5);
    }

    @Test
    void return_18_for_aSpare_andRoll_3_2() {
        var bowlingGame = new BowlingGame();
        bowlingGame.roll(6);
        bowlingGame.roll(4);
        bowlingGame.roll(3);
        bowlingGame.roll(2);
        rollNbTimesWithValue(bowlingGame, 16, 0);

        int result = bowlingGame.score();

        assertThat(result).isEqualTo((10 + 3) + (3 + 2));
    }

    @Test
    void return_22_for_aStrike_andRoll_5_1() {
        var bowlingGame = new BowlingGame();
        bowlingGame.roll(10);
        bowlingGame.roll(5);
        bowlingGame.roll(1);
        rollNbTimesWithValue(bowlingGame, 16, 0);

        int result = bowlingGame.score();

        assertThat(result).isEqualTo((10 + 6) + 6);
    }

    @Test
    void return_300_for_aPerfectGame() {
        var bowlingGame = new BowlingGame();
        rollNbTimesWithValue(bowlingGame, NB_FRAMES + 2, 10);

        int result = bowlingGame.score();

        assertThat(result).isEqualTo(300);
    }

    ///
    // Helper function(s)
    private static void rollNbTimesWithValue(BowlingGame bowlingGame, int nbTimes, int value) {
        for (int i = 0; i < nbTimes; ++i) {
            bowlingGame.roll(value);
        }
    }
}