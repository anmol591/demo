package com.example.demo.snakeladder;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Dice dice = new Dice();
        List<SnakeEntity> snakeEntityList = new ArrayList<>();
        List<LadderEntity> ladderEntities = new ArrayList<>();

        snakeEntityList.add(new SnakeEntity("34",64,60));
        snakeEntityList.add(new SnakeEntity("38",52,49));
        snakeEntityList.add(new SnakeEntity("28",64,60));
        snakeEntityList.add(new SnakeEntity("22",35,30));
        snakeEntityList.add(new SnakeEntity("20",25,21));

        ladderEntities.add(new LadderEntity("33",21,28));
        ladderEntities.add(new LadderEntity("39",32,37));
        ladderEntities.add(new LadderEntity("42",42,48));
        ladderEntities.add(new LadderEntity("62",55,65));
        ladderEntities.add(new LadderEntity("83",80,90));

        Board board = new Board(snakeEntityList,ladderEntities,100,100);

        List<Player> players = new ArrayList<>();
        players.add(new Player("Aman",789,0));
        players.add(new Player("Raghav",840,0));


        Game game = new Game();
        game.setBoard(board);
        game.setDice(dice);
        game.setPlayers(players);

        game.startGame();


    }
}
