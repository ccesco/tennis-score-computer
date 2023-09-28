package fr.cyrilcesco.tennis.score.computer.domain;

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
}