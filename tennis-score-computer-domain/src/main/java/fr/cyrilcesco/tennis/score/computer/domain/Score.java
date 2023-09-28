package fr.cyrilcesco.tennis.score.computer.domain;

import fr.cyrilcesco.tennis.score.computer.domain.exceptions.ScoreNotAllowedException;

public enum Score {
    LOVE("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    ADVANTAGE("ADVANTAGE"),
    GAME("45");

    private final String value;

    Score(String value) {
        this.value = value;
    }

    public static Score getNextScore(Score actualScore) {
        return switch (actualScore) {
            case LOVE -> Score.FIFTEEN;
            case FIFTEEN -> Score.THIRTY;
            case THIRTY -> Score.FORTY;
            case FORTY, ADVANTAGE -> Score.GAME;
            default -> throw new ScoreNotAllowedException();
        };
    }

    public static Score getNextScoreScoreDeuce() {
        return Score.ADVANTAGE;
    }

    public static Score getPreviousScoreAdvantage() {
        return Score.FORTY;
    }
}
