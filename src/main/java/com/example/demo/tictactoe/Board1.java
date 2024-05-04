package com.example.demo.tictactoe;

public class Board1 {
    private int rows;
    private int cols;
    private char[][] grid;
    private int MAX_MOVES;
    private int currentMove = 0;

    public char[][] getGrid() {
        return grid;
    }

    public int getMAX_MOVES() {
        return MAX_MOVES;
    }

    public int getCurrentMove() {
        return currentMove;
    }

    public Board1(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.MAX_MOVES = rows*cols;
        this.grid = new char[rows][cols];
        fillBoard();
    }
    private void fillBoard() {
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++){
               grid[i][j] = 'N';
            }
        }
    }
    public void showBoard() {
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void makeMove(Player1 player,int row, int col) {
        if(isValidMove(row,col)){
            grid[row][col] = player.getCharacter();
            ++currentMove;
            showBoard();
            return;
        }
        System.out.println("Invalid Move");
    }

    private boolean isValidMove(int row,int col) {
        return ( row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 'N');

    }

    public boolean checkIfCurrentPlayerWinner(Player1 player,int row,int col){
        return checkIfRowMatches(row,player) || checkIfColMatches(col,player)
                || negativeDiagonalCheck(row,col,player) || positiveDiagonalMatches(row,col,player);
    }

    private boolean checkIfRowMatches(int row,Player1 player) {
        for(int i=0;i<this.cols;i++){
            if(grid[row][i] != player.getCharacter())
                return false;
        }
        return true;
    }

    private boolean checkIfColMatches(int col,Player1 player) {
        for(int i=0;i<this.rows;i++){
            if(grid[i][col] != player.getCharacter())
                return false;
        }
        return true;
    }

    private boolean positiveDiagonalMatches(int row,int col,Player1 player) {
        int i,j;
        for(i=0,j=0;i<this.rows && j<this.cols;i++,j++){
            if(grid[i][j] != player.getCharacter())
                return false;
        }
        return true;
    }

    private boolean negativeDiagonalCheck(int row,int col,Player1 player) {
        int i,j;
        for(i=0,j=cols-1;j>=0 && i<this.rows;j--,i++) {
            if(grid[i][j] != player.getCharacter())
                return false;
        }
        return true;
    }


}
