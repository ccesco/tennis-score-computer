package fr.cyrilcesco.tennis.score.computer.domain;

import fr.cyrilcesco.tennis.score.computer.domain.exceptions.InvalidPlayerNameException;

import java.util.List;

public class Game {

    private final Player player1;
    private final Player player2;

    public Game(String namePlayer1, String namePlayer2) {
        this.player1 = new Player(namePlayer1);
        this.player2 = new Player(namePlayer2);
    }

    public void playerWinAPoint(String playerName) {
        if(!List.of(player1.getName(), player2.getName()).contains(playerName)) {
            throw new InvalidPlayerNameException(playerName);
        }

        if(playerName.equals(player1.getName())) {
            player1.winPoint();
        } else {
            player2.winPoint();
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
