package com.example.demo.snakeladder;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class Board {
    private List<SnakeEntity> snakeEntityList;

    private List<LadderEntity> ladderEntityList;

    @Setter
    private int winningPosition;

    @Setter
    private int grid;

    public Board(List<SnakeEntity> snakeEntityList, List<LadderEntity> ladderEntityList, int winningPosition, int grid) {
        this.snakeEntityList = snakeEntityList;
        this.ladderEntityList = ladderEntityList;
        this.winningPosition = winningPosition;
        this.grid = grid;
    }

    public void makeMove(Player player,int value) {
        int newPos  = player.getPosition() + value;
        if(newPos > grid) {
            System.out.println("Position is outside the grid.Next turn");
        } else {
            for(SnakeEntity snakeEntity : snakeEntityList) {
                if(snakeEntity.getHead() == newPos) {
                    player.setPosition(snakeEntity.getTail());
                    return;
                }
            }
            for(LadderEntity ladderEntity : ladderEntityList) {
                if(ladderEntity.getStart() == newPos){ //start = bottom face,end = top face
                    player.setPosition(ladderEntity.getEnd());
                    return;
                }
            }
            player.setPosition(newPos);
        }
    }

    public void addSnake(SnakeEntity snakeEntity) {
        this.snakeEntityList.add(snakeEntity);
    }

    public void addLadder(LadderEntity ladderEntity) {
        this.ladderEntityList.add(ladderEntity);
    }
}
