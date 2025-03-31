package org.bowling.object_oriented;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameShould {
    @Test
    public void return_0_for_aGutterGame() {
        BowlingGame game = new BowlingGame();
        rollNbTimesWithValue(game, 20, 0);
        int result = game.score();
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void return_20_for_all_1() {
        BowlingGame game = new BowlingGame();
        rollNbTimesWithValue(game, 20, 1);
        int result = game.score();
        assertThat(result).isEqualTo(20);
    }

    @Test
    public void return_18_for_aSpare_and_3_2() {
        BowlingGame game = new BowlingGame();
        game.roll(6);
        game.roll(4);
        game.roll(3);
        game.roll(2);
        rollNbTimesWithValue(game, 16, 0);

        int result = game.score();

        assertThat(result).isEqualTo(18);
    }

    @Test
    public void return_20_for_aStrike_and_3_2() {
        BowlingGame game = new BowlingGame();
        game.roll(10);
        game.roll(3);
        game.roll(2);
        rollNbTimesWithValue(game, 16, 0);

        int result = game.score();

        assertThat(result).isEqualTo(20);
    }

    ///
    // Helper methods
    private static void rollNbTimesWithValue(BowlingGame game, int nbTimes, int value) {
        for (int i = 0; i < nbTimes; i++) {
            game.roll(value);
        }
    }
}