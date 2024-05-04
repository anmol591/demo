package com.example.demo.tictactoe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Driver {
    public static void main(String[] args) throws IOException {
        Player1 player1 = new Player1.Player1Builder().setCharacter('x').setName("anmol").build();
        Player1 player11 = new Player1.Player1Builder().setCharacter('y').setName("rahul").build();

        List<Player1> player1List = new ArrayList<>();
        player1List.add(player11);
        player1List.add(player1);

        Board1 board1 = new Board1(3,3);

        Game1 game1 = new Game1.Game1Builder().setBoard1(board1).setStatus("Game started").setPlayer1s(player1List).build();
        game1.play();

    }
}
