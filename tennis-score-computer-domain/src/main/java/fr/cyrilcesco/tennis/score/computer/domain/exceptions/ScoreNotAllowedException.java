package fr.cyrilcesco.tennis.score.computer.domain.exceptions;

public class ScoreNotAllowedException extends RuntimeException {

    public ScoreNotAllowedException() {
        super("Score not allowed");
    }
}
