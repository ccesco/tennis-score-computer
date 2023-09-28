package fr.cyrilcesco.tennis.score.computer.domain.service;

import fr.cyrilcesco.tennis.score.computer.domain.Game;

import java.util.List;
import java.util.Objects;

public class GameScoreComputerService {

    private final Game game;

    public GameScoreComputerService() {
        this.game = new Game("A", "B");
    }

    public Game computeScoreFromString(String lineToCompute) {
        if(Objects.isNull(lineToCompute)) {
            return game;
        }

        List<Character> playerWinPoints = lineToCompute.chars().mapToObj(c -> (char)c).toList();

        for (Character playerWinPoint: playerWinPoints) {
            game.playerWinAPoint(String.valueOf(playerWinPoint));
        }
        return game;
    }

}
