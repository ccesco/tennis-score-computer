package fr.cyrilcesco.tennis.score.computer.application.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationServiceTest {

    @Test
    void should_return_display_score_with_A() {
        ApplicationService service = new ApplicationService();

        String result = service.getDisplayTennisScoreComputer("A");

        String expected = "Player A : 15 / Player B : 0\n";
        assertEquals(expected, result);
    }

    @Test
    void should_return_display_score_with_B() {
        ApplicationService service = new ApplicationService();

        String result = service.getDisplayTennisScoreComputer("B");

        String expected = "Player A : 0 / Player B : 15\n";
        assertEquals(expected, result);
    }

    @Test
    void should_return_display_score_with_AAA() {
        ApplicationService service = new ApplicationService();

        String result = service.getDisplayTennisScoreComputer("AAA");

        String expected = "Player A : 15 / Player B : 0\n" +
                "Player A : 30 / Player B : 0\n" +
                "Player A : 40 / Player B : 0\n";
        assertEquals(expected, result);
    }

    @Test
    void should_return_display_score_with_BBBB() {
        ApplicationService service = new ApplicationService();

        String result = service.getDisplayTennisScoreComputer("BBBB");

        String expected = "Player A : 0 / Player B : 15\n" +
                "Player A : 0 / Player B : 30\n" +
                "Player A : 0 / Player B : 40\n"+
                "Player B wins the game";
        assertEquals(expected, result);
    }

    @Test
    void should_return_display_score_with_ABABAA() {
        ApplicationService service = new ApplicationService();

        String result = service.getDisplayTennisScoreComputer("ABABAA");

        String expected = "Player A : 15 / Player B : 0\n" +
                "Player A : 15 / Player B : 15\n" +
                "Player A : 30 / Player B : 15\n" +
                "Player A : 30 / Player B : 30\n" +
                "Player A : 40 / Player B : 30\n" +
                "Player A wins the game";
        assertEquals(expected, result);
    }

    @Test
    void should_return_display_score_with_ABABABAA() {
        ApplicationService service = new ApplicationService();

        String result = service.getDisplayTennisScoreComputer("ABABABAA");

        String expected = "Player A : 15 / Player B : 0\n" +
                "Player A : 15 / Player B : 15\n" +
                "Player A : 30 / Player B : 15\n" +
                "Player A : 30 / Player B : 30\n" +
                "Player A : 40 / Player B : 30\n" +
                "Player A : 40 / Player B : 40\n" +
                "Player A : ADVANTAGE / Player B : 40\n" +
                "Player A wins the game";
        assertEquals(expected, result);
    }
}