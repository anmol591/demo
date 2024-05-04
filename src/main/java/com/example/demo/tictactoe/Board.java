package com.example.demo.tictactoe;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Board {
    private final int rows;
    private final int cols;

    private char[][] grid;
    private final int MAX_MOVES;

    private int currentMove = 0;

    public Board(int size) {
        this.rows = size;
        this.cols = size;
        this.grid = new char[this.rows][this.cols];
        fillGrid();
        MAX_MOVES = size;
    }

    private void fillGrid() {
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++)
                grid[i][j] = 'N';
        }
    }

    public void makeMove(Player player,int row,int col) {
        grid[row][col] = player.getPiece();
        ++currentMove;
        showBoard();
    }

    public boolean isValidGrid(int row,int col) {
        return row < this.rows && col < this.cols;
    }

    public boolean isValidMove(int row,int col) {
       return grid[row][col] == 'N';
    }

    public boolean checkIfCurrentPlayerWinner(Player player,int row,int col){
       return checkIfRowMatches(row,player) || checkIfColMatches(col,player)
               || negativeDiagonalCheck(row,col,player) || positiveDiagonalMatches(row,col,player);
    }

    private boolean checkIfRowMatches(int row,Player player) {
        for(int i=0;i<this.cols;i++){
            if(grid[row][i] != player.getPiece())
                return false;
        }
        return true;
    }

    private boolean checkIfColMatches(int col,Player player) {
       for(int i=0;i<this.rows;i++){
           if(grid[i][col] != player.getPiece())
               return false;
       }
       return true;
    }

    private boolean positiveDiagonalMatches(int row,int col,Player player) {
        int i,j;
        for(i=0,j=0;i<this.rows && j<this.cols;i++,j++){
            if(grid[i][j] != player.getPiece())
                return false;
        }
        return true;
    }

    private boolean negativeDiagonalCheck(int row,int col,Player player) {
       int i,j;
       for(i=0,j=cols-1;j>=0 && i<this.rows;j--,i++) {
           if(grid[i][j] != player.getPiece())
               return false;
       }
       return true;
    }

    private void showBoard() {
        for(int i=0;i<this.rows;i++) {
            System.out.println();
            for(int j=0;j<this.cols;j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}
