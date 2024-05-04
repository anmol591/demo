package com.example.demo.tictactoe;

public class Player1 {
    private String name;
    private Character character;

    private Player1(Player1Builder player1Builder){
        this.character = player1Builder.character;
        this.name = player1Builder.name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    static class Player1Builder{
        private String name;
        private Character character;

        public Player1Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Player1Builder setCharacter(Character character) {
            this.character = character;
            return this;
        }

        public Player1 build() {
            return new Player1(this);
        }
    }

}

