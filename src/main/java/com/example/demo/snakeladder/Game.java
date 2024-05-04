package com.example.demo.snakeladder;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Game {
    private List<Player> players;
    private Board board;
    private Dice dice;
    private String status;

    public Game(List<Player> players, Board board, Dice dice) {
        this.players = players;
        this.board = board;
        this.dice = dice;
    }

    public void startGame() {
        System.out.println("Game has started");
        this.status = Status.IN_PROGRESS.name();
        boolean gameOver = false;
        while(!gameOver) {
            for(Player player : players) {
                int diceValue = dice.rollup();
                makeMove(player,diceValue);
                isCurrentPlayerWinner(player);
                if(Status.COMPLETED.name().equalsIgnoreCase(this.status)){
                    gameOver = true;
                    break;
                }
            }
        }
    }

    private void makeMove(Player player, int value) {
        board.makeMove(player,value);
    }

    private void isCurrentPlayerWinner(Player player) {
        if(player.getPosition() == board.getWinningPosition()) {
            this.status = Status.COMPLETED.name();
            System.out.println("Player " + player.getPlayerName() + "has won");
        }
    }


}
