package com.example.demo.snakeladder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String playerName;
    private int playerId;

    private int position;

    public Player(String playerName, int playerId, int position) {
        this.playerName = playerName;
        this.playerId = playerId;
        this.position = position;
    }
}
