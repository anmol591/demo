package com.example.demo.tictactoe;


import com.example.demo.snakeladder.Status;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Game {
    private Board board;
    List<Player> playerList;

    private String status;

    public Game(Board board, List<Player> playerList) {
        this.board = board;
        this.playerList = playerList;
        this.status = Status.NOT_STARTED.name();
    }

    public void startGame() {
        System.out.println("Let's start the game");
        this.status = Status.IN_PROGRESS.name();
        boolean isGameOver = false;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(!isGameOver) {
            for(Player player : playerList) {
                try {
                    if(this.board.getCurrentMove() == this.board.getMAX_MOVES()) {
                        System.out.println("Game draw");
                        isGameOver = true;
                        break;
                    }
                    String input = bufferedReader.readLine();
                    String[] command = input.split(" ");
                    int row = Integer.parseInt(command[0]);
                    int col = Integer.parseInt(command[1]);
                    if(row == -1){
                        System.out.println("Game is terminated");
                        isGameOver = true;
                        break;
                    }
                    if(this.board.isValidGrid(row,col)) {
                        if(this.board.isValidMove(row,col)) {
                            this.board.makeMove(player,row,col);
                            if(this.board.checkIfCurrentPlayerWinner(player,row,col)) {
                                System.out.println("Player " + player.getName() + " has won");
                                isGameOver = true;
                                break;
                            }
                        } else {
                            System.out.println("Invalid move");
                        }
                    } else {
                        System.out.println("Row or col is outside the grid");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }

    }
}
