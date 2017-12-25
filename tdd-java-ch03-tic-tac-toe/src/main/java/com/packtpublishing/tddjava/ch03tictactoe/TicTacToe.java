package com.packtpublishing.tddjava.ch03tictactoe;

/**
 * Created by vfarcic on 19/03/15.
 */
public class TicTacToe {

    boolean board[][];
    public TicTacToe(){
        board=new boolean[3][3];
    }

    /*
     * This method checks if move is valid or not.
     * if valid it updates the board matrix otherwise
     * throws a runtime exception.
     */

    public void play(int x,int y){

        if(x<1 || x>3){
            throw new RuntimeException("Invalid X");
        }
        if(y<1 || y>3){
            throw new RuntimeException("Invalid Y");
        }

        if(!checkBoardSpot(x,y)){
            updateBoard(x,y);
        }else{
            throw new RuntimeException("Spot is already occupied");
        }
    }

    /*
     * This method updates the spot on the board with the move.
     */

    public void updateBoard(int x,int y){
        board[x-1][y-1]=true;
    }

    /*
     * This method checks if the spot on the board is already occupied.
     */
    public boolean checkBoardSpot(int x,int y){
        if(board[x-1][y-1]==true){
            return true;
        }
        return false;
    }
}
