package com.packtpublishing.tddjava.ch03tictactoe;

/**
 * Created by vfarcic on 19/03/15.
 */
public class TicTacToe {

    player board[][];
    int numOfMoves=0;

    enum player {
        X,
        Y
    }

    private player nextPlayer;

    public TicTacToe() {
        board = new player[3][3];
        nextPlayer = player.X;

    }

    /*
     * This method checks if move is valid or not.
     * if valid it updates the board matrix otherwise
     * throws a runtime exception.
     */

    public String play(int x, int y) {

        if (x < 1 || x > 3) {
            throw new RuntimeException("Invalid X");
        }
        if (y < 1 || y > 3) {
            throw new RuntimeException("Invalid Y");
        }

        if (!checkBoardSpot(x, y)) {
            updateBoard(x, y);
        } else {
            throw new RuntimeException("Spot is already occupied");
        }

        numOfMoves++;
        return checkWinner();
    }

    /*
     * This method updates the spot on the board with the move.
     */

    public void updateBoard(int x, int y) {
        board[x - 1][y - 1] = nextPlayer;
        if (nextPlayer.equals(player.X)) {
            nextPlayer = player.Y;
        } else {
            nextPlayer = player.X;
        }
    }

    /*
     * This method checks if the spot on the board is already occupied.
     */
    public boolean checkBoardSpot(int x, int y) {
        if (board[x - 1][y - 1] != null) {
            return true;
        }
        return false;
    }

    /*
     * This method return the next player that is expected to move
     */

    public player getNextPlayer() {
        return nextPlayer;
    }

     /*
     * This method checks if there is a winner
     */

    public String checkWinner() {


        player winner = checkHorizontalWinner();
        if (winner != null) {
            return winner.toString() + "is winner";
        }

        winner = checkVerticalWinner();
        if (winner != null) {
            return winner.toString() + "is winner";
        }
        winner=checkDiagonalWinner();
        if (winner != null) {
            return winner.toString() + "is winner";
        }

        if(numOfMoves==9){
            return "Game is a Draw";
        }

        return "No Winner";
    }

    /*
     * Check Horizontal winner
     */

    public player checkHorizontalWinner() {

        player first;
        player second;
        player third;

        for (int i = 0; i < 3; i++) {
            //constant x
            first = board[i][0];
            second = board[i][1];
            third = board[i][2];

            if (first == second && second == third) {
                return first;
            } else {
                continue;
            }
        }

        return null;
    }
    /*
     * Check Vertical winner
     */

    public player checkVerticalWinner() {

        player first;
        player second;
        player third;

        for (int i = 0; i < 3; i++) {
            //constant y
            first = board[0][i];
            second = board[1][i];
            third = board[2][i];

            if (first == second && second == third) {
                return first;
            } else {
                continue;
            }
        }

        return null;
    }

    /*
     * Check Diagnoal winner
     */

    public player checkDiagonalWinner() {

        player first;
        player second;
        player third;


        first = board[0][0];
        second = board[1][1];
        third = board[2][2];

        if (first == second && second == third) {
            return first;
        }

        first = board[0][2];
        second = board[1][1];
        third = board[2][0];

        if (first == second && second == third) {
            return first;
        }


        return null;
    }
}
