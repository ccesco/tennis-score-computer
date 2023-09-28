package fr.cyrilcesco.tennis.score.computer.domain;

import fr.cyrilcesco.tennis.score.computer.domain.exceptions.InvalidPlayerNameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {

    public static final String NAME_PLAYER_1 = "Cyril";
    public static final String NAME_PLAYER_2 = "Cesco";
    private Game gameToTest;

    @BeforeEach
    void init() {
        gameToTest = new Game(NAME_PLAYER_1, NAME_PLAYER_2);
    }

    @Test
    void souhld_return_game_with_initial_value_when_created() {
        Player player1 = gameToTest.getPlayer1();
        assertEquals("Cyril", player1.getName());
        assertEquals(Score.LOVE, player1.getScore());

        Player player2 = gameToTest.getPlayer2();
        assertEquals("Cesco", player2.getName());
        assertEquals(Score.LOVE, player2.getScore());
    }

    @Test
    void souhld_return_game_with_when_player1_win_1_point() {
        gameToTest.playerWinAPoint(NAME_PLAYER_1);

        Player player1 = gameToTest.getPlayer1();
        assertEquals("Cyril", player1.getName());
        assertEquals(Score.FIFTEEN, player1.getScore());

        Player player2 = gameToTest.getPlayer2();
        assertEquals("Cesco", player2.getName());
        assertEquals(Score.LOVE, player2.getScore());
    }

    @Test
    void souhld_return_game_with_when_player2_win_1_point() {
        gameToTest.playerWinAPoint(NAME_PLAYER_2);

        Player player1 = gameToTest.getPlayer1();
        assertEquals(Score.LOVE, player1.getScore());

        Player player2 = gameToTest.getPlayer2();
        assertEquals(Score.FIFTEEN, player2.getScore());
    }

    @Test
    void souhld_return_game_when_player1_win_2_point_and_player2_win_1_point() {
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);

        Player player1 = gameToTest.getPlayer1();
        assertEquals(Score.THIRTY, player1.getScore());

        Player player2 = gameToTest.getPlayer2();
        assertEquals(Score.FIFTEEN, player2.getScore());
    }

    @Test
    void souhld_return_game_when_player1_win_3_point_and_player2_win_1_point() {
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);

        Player player1 = gameToTest.getPlayer1();
        assertEquals(Score.FORTY, player1.getScore());

        Player player2 = gameToTest.getPlayer2();
        assertEquals(Score.FIFTEEN, player2.getScore());
    }

    @Test
    void souhld_return_game_when_player1_win_4_point_and_player2_win_1_point() {
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);

        Player player1 = gameToTest.getPlayer1();
        assertEquals(Score.GAME, player1.getScore());

        Player player2 = gameToTest.getPlayer2();
        assertEquals(Score.FIFTEEN, player2.getScore());
    }

    @Test
    void souhld_throw_error_when_player_name_not_present() {
        assertThrows(InvalidPlayerNameException.class, () -> gameToTest.playerWinAPoint("TEST"));
    }

    @Test
    void souhld_return_game_deuce_when_player1_is_40_and_player2_is_40() {
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);

        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);

        Player player1 = gameToTest.getPlayer1();
        assertEquals(Score.FORTY, player1.getScore());

        Player player2 = gameToTest.getPlayer2();
        assertEquals(Score.FORTY, player2.getScore());
    }

    @Test
    void souhld_return_player1_advantage_when_player1_is_40_and_player2_is_40_and_player1_win_point() {
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        // Player 1 : 40 / Player 2 : 40

        gameToTest.playerWinAPoint(NAME_PLAYER_1);

        Player player1 = gameToTest.getPlayer1();
        assertEquals(Score.ADVANTAGE, player1.getScore());

        Player player2 = gameToTest.getPlayer2();
        assertEquals(Score.FORTY, player2.getScore());
    }

    @Test
    void souhld_return_player2_advantage_when_player1_is_40_and_player2_is_40_and_player2_win_point() {
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        // Player 1 : 40 / Player 2 : 40

        gameToTest.playerWinAPoint(NAME_PLAYER_2);

        Player player1 = gameToTest.getPlayer1();
        assertEquals(Score.FORTY, player1.getScore());

        Player player2 = gameToTest.getPlayer2();
        assertEquals(Score.ADVANTAGE, player2.getScore());
    }

    @Test
    void souhld_return_player1_win_game_when_player1_is_advantage_and_player2_is_40_and_player1_win_point() {
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        // Player 1 : ADV / Player 2 : 40

        gameToTest.playerWinAPoint(NAME_PLAYER_1);

        Player player1 = gameToTest.getPlayer1();
        assertEquals(Score.GAME, player1.getScore());

        Player player2 = gameToTest.getPlayer2();
        assertEquals(Score.FORTY, player2.getScore());
    }

    @Test
    void souhld_return_player2_win_game_when_player2_is_advantage_and_player1_is_40_and_player2_win_point() {
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        // Player 1 : 40 / Player 2 : ADV

        gameToTest.playerWinAPoint(NAME_PLAYER_2);

        Player player1 = gameToTest.getPlayer1();
        assertEquals(Score.FORTY, player1.getScore());

        Player player2 = gameToTest.getPlayer2();
        assertEquals(Score.GAME, player2.getScore());
    }

    @Test
    void souhld_return_deuce_when_player1_is_advantage_and_player2_is_40_and_player2_win_point() {
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        // Player 1 : ADV / Player 2 : 40

        gameToTest.playerWinAPoint(NAME_PLAYER_2);

        Player player1 = gameToTest.getPlayer1();
        assertEquals(Score.FORTY, player1.getScore());

        Player player2 = gameToTest.getPlayer2();
        assertEquals(Score.FORTY, player2.getScore());
    }

    @Test
    void souhld_return_deuce_when_player2_is_advantage_and_player1_is_40_and_player1_win_point() {
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        // Player 1 : 40 / Player 2 : ADV

        gameToTest.playerWinAPoint(NAME_PLAYER_1);

        Player player1 = gameToTest.getPlayer1();
        assertEquals(Score.FORTY, player1.getScore());

        Player player2 = gameToTest.getPlayer2();
        assertEquals(Score.FORTY, player2.getScore());
    }

    @Test
    void souhld_player1_win_game_when_return_deuce_and_player1_win_point() {
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        // Player 1 : 40 / Player 2 : ADV

        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        // Player 1 : 40 / Player 2 : 40

        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        // Player 1 : ADV / Player 2 : 40

        gameToTest.playerWinAPoint(NAME_PLAYER_1);

        Player player1 = gameToTest.getPlayer1();
        assertEquals(Score.GAME, player1.getScore());

        Player player2 = gameToTest.getPlayer2();
        assertEquals(Score.FORTY, player2.getScore());
    }

    @Test
    void souhld_player2_win_game_when_return_deuce_and_player2_win_point() {
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        // Player 1 : 40 / Player 2 : ADV

        gameToTest.playerWinAPoint(NAME_PLAYER_1);
        // Player 1 : 40 / Player 2 : 40

        gameToTest.playerWinAPoint(NAME_PLAYER_2);
        // Player 1 : 40 / Player 2 : ADV

        gameToTest.playerWinAPoint(NAME_PLAYER_2);

        Player player1 = gameToTest.getPlayer1();
        assertEquals(Score.FORTY, player1.getScore());

        Player player2 = gameToTest.getPlayer2();
        assertEquals(Score.GAME, player2.getScore());
    }
}