package fr.cyrilcesco.tennis.score.computer.domain.stub;

import fr.cyrilcesco.tennis.score.computer.domain.Game;
import fr.cyrilcesco.tennis.score.computer.domain.Player;
import fr.cyrilcesco.tennis.score.computer.domain.Score;
import fr.cyrilcesco.tennis.score.computer.domain.spi.DisplayServicePort;

public class DisplayServiceStub implements DisplayServicePort {

    private final StringBuilder textToDisplay;

    public DisplayServiceStub() {
        textToDisplay = new StringBuilder();
    }

    public void appendGameScore(Game game) {
        String textToAppend;
        if(game.getPlayer1().getScore().equals(Score.GAME)) {
            textToAppend = displayPlayerWinGame(game.getPlayer1());
        } else if(game.getPlayer2().getScore().equals(Score.GAME)) {
            textToAppend = displayPlayerWinGame(game.getPlayer2());
        } else {
            textToAppend = displayPlayerInfo(game.getPlayer1()) + " | " + displayPlayerInfo(game.getPlayer2()) + " ---- ";
        }
        textToDisplay.append(textToAppend);
    }

    public String showTextToDisplay() {
        return textToDisplay.toString();
    }

    private String displayPlayerInfo(Player player) {
        return "Player " + player.getName() + " : " + player.getScore().getValue();
    }

    private String displayPlayerWinGame(Player player) {
        return "Player " + player.getName() + " wins the game";
    }
}
