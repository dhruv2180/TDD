package com.packtpublishing.tddjava.ch03tictactoe;

/**
 * Created by vfarcic on 19/03/15.
 */
public class TicTacToe {

    boolean board[][];
    public TicTacToe(){
        board=new boolean[3][3];
    }

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

    public void updateBoard(int x,int y){
        board[x-1][y-1]=true;
    }

    //Funtion to
    public boolean checkBoardSpot(int x,int y){
        if(board[x-1][y-1]==true){
            return true;
        }
        return false;
    }
}
