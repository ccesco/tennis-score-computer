package fr.cyrilcesco.tennis.score.computer.domain;

import fr.cyrilcesco.tennis.score.computer.domain.exceptions.ScoreNotAllowedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    void should_return_FIFTEEN_when_player_with_LOVE_win_point() {
        Score nextScore = Score.getNextScore(Score.LOVE);
        assertEquals(Score.FIFTEEN, nextScore);
    }

    @Test
    void should_return_THIRTY_when_player_with_FIFTEEN_win_point() {
        Score nextScore = Score.getNextScore(Score.FIFTEEN);
        assertEquals(Score.THIRTY, nextScore);
    }

    @Test
    void should_return_FORTY_when_player_with_THIRTY_win_point() {
        Score nextScore = Score.getNextScore(Score.THIRTY);
        assertEquals(Score.FORTY, nextScore);
    }

    @Test
    void should_return_GAME_when_player_with_FORTY_win_point() {
        Score nextScore = Score.getNextScore(Score.FORTY);
        assertEquals(Score.GAME, nextScore);
    }

    @Test
    void should_return_ADVANTAGE_when_player_win_in_deuce() {
        Score nextScore = Score.getNextScoreScoreDeuce();
        assertEquals(Score.ADVANTAGE, nextScore);
    }

    @Test
    void should_return_FORTY_when_player_loose_in_avantage() {
        Score nextScore = Score.getPreviousScoreAdvantage();
        assertEquals(Score.FORTY, nextScore);
    }

    @Test
    void should_throw_error_if_no_next_score() {
        ScoreNotAllowedException scoreNotAllowedException = assertThrows(ScoreNotAllowedException.class, () -> Score.getNextScore(Score.GAME));
        assertEquals("Score not allowed", scoreNotAllowedException.getMessage());
    }
}