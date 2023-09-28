package fr.cyrilcesco.tennis.score.computer.domain;

import fr.cyrilcesco.tennis.score.computer.domain.exceptions.ScoreNotAllowedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {

    @Test
    void should_return_player_with_initial_values_when_created() {
        Player player = new Player("Cyril");

        assertEquals("Cyril", player.getName());
        assertEquals(Score.LOVE, player.getScore());
    }

    @Test
    void should_return_player_next_score_when_win_one_point() {
        Player player = new Player("Cyril");
        player.winPoint();

        assertEquals(Score.FIFTEEN, player.getScore());
    }

    @Test
    void should_return_player_next_score_when_win_two_point() {
        Player player = new Player("Cyril");
        player.winPoint();
        player.winPoint();

        assertEquals(Score.THIRTY, player.getScore());
    }

    @Test
    void should_return_player_next_score_when_win_three_point() {
        Player player = new Player("Cyril");
        player.winPoint();
        player.winPoint();
        player.winPoint();

        assertEquals(Score.FORTY, player.getScore());
    }

    @Test
    void should_return_player_next_score_when_win_four_point() {
        Player player = new Player("Cyril");
        player.winPoint();
        player.winPoint();
        player.winPoint();
        player.winPoint();

        assertEquals(Score.GAME, player.getScore());
    }

    @Test
    void should_throw_error_when_illegal_state() {
        Player player = new Player("Cyril");
        player.winPoint();
        player.winPoint();
        player.winPoint();
        player.winPoint();

        ScoreNotAllowedException scoreNotAllowedException = assertThrows(ScoreNotAllowedException.class, player::winPoint);
        assertEquals("Score not allowed", scoreNotAllowedException.getMessage());
    }

    @Test
    void should_return_advantage_when_player_win_deuce() {
        Player player = new Player("Cyril");
        player.winPointInDeuce();

        assertEquals(Score.ADVANTAGE, player.getScore());
    }

    @Test
    void should_return_FORTY_when_player_loose_advantage() {
        Player player = new Player("Cyril");
        player.loosePointInAdvantage();

        assertEquals(Score.FORTY, player.getScore());
    }
}