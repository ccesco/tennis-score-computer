package fr.cyrilcesco.tennis.score.computer.domain.spi;

import fr.cyrilcesco.tennis.score.computer.domain.Game;

public interface DisplayServicePort {

    void appendGameScore(Game game);

    String showTextToDisplay();
}
