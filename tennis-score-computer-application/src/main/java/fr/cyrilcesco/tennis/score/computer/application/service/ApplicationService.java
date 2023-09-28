package fr.cyrilcesco.tennis.score.computer.application.service;

import fr.cyrilcesco.tennis.score.computer.domain.service.GameScoreComputerService;

public class ApplicationService {

    public String getDisplayTennisScoreComputer(String lineToCompute) {
        GameScoreComputerService service = new GameScoreComputerService(new DisplayService());
        return service.computeScoreFromStringAndReturnTextToDisplay(lineToCompute);
    }
}
