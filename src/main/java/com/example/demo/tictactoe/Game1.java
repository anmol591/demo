package com.example.demo.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Game1 {
    private Board1 board1;
    private List<Player1> player1s;
    private String status;

    private Game1(Game1.Game1Builder game1Builder) {
        this.board1 = game1Builder.board1;
        this.status = game1Builder.status;
        this.player1s = game1Builder.player1s;
    }

    static class Game1Builder{
        private Board1 board1;
        private List<Player1> player1s;
        private String status;

        public Game1Builder setBoard1(Board1 board1) {
            this.board1 = board1;
            return this;
        }

        public Game1Builder setPlayer1s(List<Player1> player1s) {
            this.player1s = player1s;
            return this;
        }

        public Game1Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Game1 build() {
            return new Game1(this);
        }
    }

    public void play() {
        System.out.println("Let's start the game");
        this.status = "IN_PROGRESS";
        boolean isGameOver = false;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(!isGameOver) {
            try {
                for(Player1 player1 : this.player1s){
                    System.out.println(player1.getName()+"'s" + "turn.Enter row col: ");
                    String input = bufferedReader.readLine();
                    String[] command = input.split(" ");
                    int row = Integer.parseInt(command[0]);
                    int col = Integer.parseInt(command[1]);

                    this.board1.makeMove(player1,row,col);
                    if(this.board1.checkIfCurrentPlayerWinner(player1,row,col)) {
                        System.out.println("Player " + player1.getName() + " has won");
                        isGameOver = true;
                        break;
                    }

                    if(this.board1.getCurrentMove() == this.board1.getMAX_MOVES()){
                        isGameOver = true;
                        System.out.println("Game Draw");
                        break;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
