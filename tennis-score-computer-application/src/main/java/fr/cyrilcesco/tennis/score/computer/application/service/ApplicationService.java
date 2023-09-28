package fr.cyrilcesco.tennis.score.computer.application.service;

import fr.cyrilcesco.tennis.score.computer.domain.service.GameScoreComputerService;

public class ApplicationService {

    public String getDisplayTennisScoreComputer(String lineToCompute, String player1Name, String player2Name) {
        GameScoreComputerService service = new GameScoreComputerService(new DisplayService(), player1Name, player2Name);
        return service.computeScoreFromStringAndReturnTextToDisplay(lineToCompute);
    }
}
