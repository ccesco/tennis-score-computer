package fr.cyrilcesco.tennis.score.computer.application.service;

import fr.cyrilcesco.tennis.score.computer.domain.service.GameScoreComputerService;
import jakarta.annotation.Nonnull;

public class ApplicationService {

    public String getDisplayTennisScoreComputer(@Nonnull String lineToCompute, @Nonnull String player1Name, @Nonnull String player2Name) {
        GameScoreComputerService service = new GameScoreComputerService(new DisplayService(), player1Name, player2Name);
        return service.computeScoreFromStringAndReturnTextToDisplay(lineToCompute);
    }
}
