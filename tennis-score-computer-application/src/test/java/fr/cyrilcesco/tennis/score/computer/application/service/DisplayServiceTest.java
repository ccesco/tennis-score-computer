package fr.cyrilcesco.tennis.score.computer.application.service;

import fr.cyrilcesco.tennis.score.computer.domain.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayServiceTest {

    @Test
    void should_return_empty_without_append() {
        DisplayService displayService = new DisplayService();

        assertEquals("", displayService.showTextToDisplay());
    }

    @Test
    void should_return_display_score_when_player_1_win_1_game() {
        DisplayService displayService = new DisplayService();
        Game game = new Game("1", "2");
        makePlayerWithNameWin(displayService, game, "1");

        String result = displayService.showTextToDisplay();

        String expected = "Player 1 : 15 / Player 2 : 0\n";
        assertEquals(expected, result);
    }

    @Test
    void should_return_display_score_when_B() {
        DisplayService displayService = new DisplayService();
        Game game = new Game("1", "2");
        makePlayerWithNameWin(displayService, game, "2");

        String result = displayService.showTextToDisplay();

        String expected = "Player 1 : 0 / Player 2 : 15\n";
        assertEquals(expected, result);
    }

    @Test
    void should_return_display_score_when_player_1_win_2_game() {
        DisplayService displayService = new DisplayService();
        Game game = new Game("1", "2");
        makePlayerWithNameWin(displayService, game, "1");
        makePlayerWithNameWin(displayService, game, "1");

        String result = displayService.showTextToDisplay();

        String expected = """
                Player 1 : 15 / Player 2 : 0
                Player 1 : 30 / Player 2 : 0
                """;
        assertEquals(expected, result);
    }

    @Test
    void should_return_display_score_when_player_1_win_the_game() {
        DisplayService displayService = new DisplayService();
        Game game = new Game("1", "2");
        makePlayerWithNameWin(displayService, game, "1");
        makePlayerWithNameWin(displayService, game, "1");
        makePlayerWithNameWin(displayService, game, "1");
        makePlayerWithNameWin(displayService, game, "1");

        String result = displayService.showTextToDisplay();

        String expected = """
                Player 1 : 15 / Player 2 : 0
                Player 1 : 30 / Player 2 : 0
                Player 1 : 40 / Player 2 : 0
                Player 1 wins the game""";
        assertEquals(expected, result);
    }

    @Test
    void should_return_display_score_when_player_2_win_the_game() {
        DisplayService displayService = new DisplayService();
        Game game = new Game("1", "2");
        makePlayerWithNameWin(displayService, game, "2");
        makePlayerWithNameWin(displayService, game, "2");
        makePlayerWithNameWin(displayService, game, "2");
        makePlayerWithNameWin(displayService, game, "2");

        String result = displayService.showTextToDisplay();

        String expected = """
                Player 1 : 0 / Player 2 : 15
                Player 1 : 0 / Player 2 : 30
                Player 1 : 0 / Player 2 : 40
                Player 2 wins the game""";
        assertEquals(expected, result);
    }

    @Test
    void should_return_display_score_when_player_1_win_the_game_andplayer_2_has_30() {
        DisplayService displayService = new DisplayService();
        Game game = new Game("1", "2");
        makePlayerWithNameWin(displayService, game, "1");
        makePlayerWithNameWin(displayService, game, "2");
        makePlayerWithNameWin(displayService, game, "1");
        makePlayerWithNameWin(displayService, game, "2");
        makePlayerWithNameWin(displayService, game, "1");
        makePlayerWithNameWin(displayService, game, "1");

        String result = displayService.showTextToDisplay();

        String expected = """
                Player 1 : 15 / Player 2 : 0
                Player 1 : 15 / Player 2 : 15
                Player 1 : 30 / Player 2 : 15
                Player 1 : 30 / Player 2 : 30
                Player 1 : 40 / Player 2 : 30
                Player 1 wins the game""";
        assertEquals(expected, result);
    }

    private static void makePlayerWithNameWin(DisplayService displayService, Game game, String playerName) {
        game.playerWinAPoint(playerName);
        displayService.appendGameScore(game);
    }
}