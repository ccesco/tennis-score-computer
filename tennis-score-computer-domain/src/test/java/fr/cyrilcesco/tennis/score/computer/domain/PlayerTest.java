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
        Score newScore = player.winPoint();

        assertEquals(Score.FIFTEEN, newScore);
    }

    @Test
    void should_return_player_next_score_when_win_two_point() {
        Player player = new Player("Cyril");
        player.winPoint();
        Score newScore = player.winPoint();

        assertEquals(Score.THIRTY, newScore);
    }

    @Test
    void should_return_player_next_score_when_win_three_point() {
        Player player = new Player("Cyril");
        player.winPoint();
        player.winPoint();
        Score newScore = player.winPoint();

        assertEquals(Score.FORTY, newScore);
    }

    @Test
    void should_return_player_next_score_when_win_four_point() {
        Player player = new Player("Cyril");
        player.winPoint();
        player.winPoint();
        player.winPoint();
        Score newScore = player.winPoint();

        assertEquals(Score.GAME, newScore);
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
}