package fr.cyrilcesco.tennis.score.computer.domain.service;

import fr.cyrilcesco.tennis.score.computer.domain.Game;
import fr.cyrilcesco.tennis.score.computer.domain.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameScoreComputerServiceTest {

    @Test
    void should_return_empty_if_lineToCompute_null() {
        GameScoreComputerService service = new GameScoreComputerService();

        Game result = service.computeScoreFromString(null);

        assertEquals(Score.LOVE, result.getPlayer1().getScore());
        assertEquals(Score.LOVE, result.getPlayer2().getScore());
    }

    @Test
    void should_return_display_score_with_A() {
        GameScoreComputerService service = new GameScoreComputerService();

        Game result = service.computeScoreFromString("A");

        assertEquals(Score.FIFTEEN, result.getPlayer1().getScore());
        assertEquals(Score.LOVE, result.getPlayer2().getScore());
    }

    @Test
    void should_return_display_score_with_B() {
        GameScoreComputerService service = new GameScoreComputerService();

        Game result = service.computeScoreFromString("B");

        assertEquals(Score.LOVE, result.getPlayer1().getScore());
        assertEquals(Score.FIFTEEN, result.getPlayer2().getScore());
    }

    @Test
    void should_return_display_score_with_AAA() {
        GameScoreComputerService service = new GameScoreComputerService();

        Game result = service.computeScoreFromString("AAA");

        assertEquals(Score.FORTY, result.getPlayer1().getScore());
        assertEquals(Score.LOVE, result.getPlayer2().getScore());
    }

    @Test
    void should_return_display_score_with_BBBB() {
        GameScoreComputerService service = new GameScoreComputerService();

        Game result = service.computeScoreFromString("BBBB");

        assertEquals(Score.LOVE, result.getPlayer1().getScore());
        assertEquals(Score.GAME, result.getPlayer2().getScore());
    }

    @Test
    void should_return_display_score_with_ABABAA() {
        GameScoreComputerService service = new GameScoreComputerService();

        Game result = service.computeScoreFromString("ABABAA");

        assertEquals(Score.GAME, result.getPlayer1().getScore());
        assertEquals(Score.THIRTY, result.getPlayer2().getScore());
    }

}