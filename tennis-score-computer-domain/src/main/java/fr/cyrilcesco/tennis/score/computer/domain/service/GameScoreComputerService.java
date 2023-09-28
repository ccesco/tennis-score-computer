package fr.cyrilcesco.tennis.score.computer.domain.service;

import fr.cyrilcesco.tennis.score.computer.domain.Game;
import fr.cyrilcesco.tennis.score.computer.domain.spi.DisplayServicePort;

import java.util.List;
import java.util.Objects;

public class GameScoreComputerService {

    private final Game game;

    private final DisplayServicePort displayService;

    public GameScoreComputerService(DisplayServicePort displayService) {
        this.game = new Game("A", "B");
        this.displayService = displayService;
    }

    public String computeScoreFromStringAndReturnTextToDisplay(String lineToCompute) {
        if(Objects.isNull(lineToCompute)) {
            return "";
        }

        List<Character> playerWinPoints = lineToCompute.chars().mapToObj(c -> (char)c).toList();

        for (Character playerWinPoint: playerWinPoints) {
            game.playerWinAPoint(String.valueOf(playerWinPoint));
            displayService.appendGameScore(game);
        }
        return displayService.showTextToDisplay();
    }

}
