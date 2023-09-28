package fr.cyrilcesco.tennis.score.computer.domain;

public class Player {

    private final String name;
    private Score score;

    public Player(String name) {
        this.name = name;
        this.score = Score.LOVE;
    }

    public void winPoint() {
        this.score = Score.getNextScore(this.score);
    }

    public void winPointInDeuce() {
        this.score = Score.getNextScoreScoreDeuce();
    }

    public void loosePointInAdvantage() {
        this.score = Score.getPreviousScoreAdvantage();
    }


    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }
}
