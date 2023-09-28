package fr.cyrilcesco.tennis.score.computer.domain.exceptions;

public class InvalidPlayerNameException extends RuntimeException {

    public InvalidPlayerNameException(String playerName) {
        super("Invalid player name " + playerName);
    }
}
