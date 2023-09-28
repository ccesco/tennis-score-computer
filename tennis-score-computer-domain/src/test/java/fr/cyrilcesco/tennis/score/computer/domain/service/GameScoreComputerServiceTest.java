package fr.cyrilcesco.tennis.score.computer.domain.service;

import fr.cyrilcesco.tennis.score.computer.domain.spi.DisplayServicePort;
import fr.cyrilcesco.tennis.score.computer.domain.stub.DisplayServiceStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameScoreComputerServiceTest {

    private DisplayServicePort displayService;

    @BeforeEach
    void init() {
        displayService = new DisplayServiceStub();
    }

    @Test
    void should_return_empty_if_lineToCompute_null() {
        GameScoreComputerService service = new GameScoreComputerService(displayService);

        String result = service.computeScoreFromStringAndReturnTextToDisplay(null);

        assertEquals("", result);
    }

    @Test
    void should_return_display_score_with_A() {
        GameScoreComputerService service = new GameScoreComputerService(displayService);

        String result = service.computeScoreFromStringAndReturnTextToDisplay("A");

        String expected = "Player A : 15 | Player B : 0 ---- ";
        assertEquals(expected, result);
    }

    @Test
    void should_return_display_score_with_B() {
        GameScoreComputerService service = new GameScoreComputerService(displayService);

        String result = service.computeScoreFromStringAndReturnTextToDisplay("B");

        String expected = "Player A : 0 | Player B : 15 ---- ";
        assertEquals(expected, result);
    }

    @Test
    void should_return_display_score_with_AAA() {
        GameScoreComputerService service = new GameScoreComputerService(displayService);

        String result = service.computeScoreFromStringAndReturnTextToDisplay("AAA");

        String expected = "Player A : 15 | Player B : 0 ---- " +
                "Player A : 30 | Player B : 0 ---- " +
                "Player A : 40 | Player B : 0 ---- ";
        assertEquals(expected, result);
    }

    @Test
    void should_return_display_score_with_BBBB() {
        GameScoreComputerService service = new GameScoreComputerService(displayService);

        String result = service.computeScoreFromStringAndReturnTextToDisplay("BBBB");

        String expected = "Player A : 0 | Player B : 15 ---- " +
                "Player A : 0 | Player B : 30 ---- " +
                "Player A : 0 | Player B : 40 ---- "+
                "Player B wins the game";
        assertEquals(expected, result);
    }

    @Test
    void should_return_display_score_with_ABABAA() {
        GameScoreComputerService service = new GameScoreComputerService(displayService);

        String result = service.computeScoreFromStringAndReturnTextToDisplay("ABABAA");

        String expected = "Player A : 15 | Player B : 0 ---- " +
                "Player A : 15 | Player B : 15 ---- " +
                "Player A : 30 | Player B : 15 ---- " +
                "Player A : 30 | Player B : 30 ---- " +
                "Player A : 40 | Player B : 30 ---- " +
                "Player A wins the game";
        assertEquals(expected, result);
    }

}