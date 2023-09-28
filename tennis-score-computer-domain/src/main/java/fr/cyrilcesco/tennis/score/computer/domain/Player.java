package fr.cyrilcesco.tennis.score.computer.domain;

public class Player {

    private final String name;
    private Score score;

    public Player(String name) {
        this.name = name;
        this.score = Score.LOVE;
    }

    public Score winPoint() {
        Score nextScore = Score.getNextScore(this.score);
        this.score = nextScore;
        return nextScore;
    }

    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }
}
