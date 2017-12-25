package com.packtpublishing.tddjava.ch03tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TicTacToeSpec {

    @Rule
    public ExpectedException exp = ExpectedException.none();
    private TicTacToe ticTacToe;

    @Before
    public final void before() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXisOutsideThenThrowRuntimeException() {
        exp.expect(RuntimeException.class);
        ticTacToe.play(5, 2);

    }

    @Test
    public void whenYisOutsideThenThrowRuntimeException() {
        exp.expect(RuntimeException.class);
        ticTacToe.play(2, 5);
    }

    @Test
    public void whenSpotAlreadyOccupiedThenThrowRuntimeException() {

        ticTacToe.play(1, 1);
        exp.expect(RuntimeException.class);
        ticTacToe.play(1, 1);

    }

    @Test
    public void whenGameBeginsNextPlayerIsX() {

        assertEquals(TicTacToe.player.X, ticTacToe.getNextPlayer());

    }

    @Test
    public void whenXPlayedThenNextPlayerIsO() {

        ticTacToe.play(1, 1);
        assertEquals(TicTacToe.player.Y, ticTacToe.getNextPlayer());

    }

    @Test
    public void whenOPlayedThenNextPlayerisX() {

        ticTacToe.play(1, 1);
        ticTacToe.play(2, 2);
        ticTacToe.play(1, 2);
        ticTacToe.play(2, 1);
        assertEquals(TicTacToe.player.X, ticTacToe.getNextPlayer());

    }

    @Test
    public void whenNoWinnerThenReturnNill() {
        assertEquals("No Winner", ticTacToe.play(1, 1));
    }

    @Test
    public void whenXMarkedAllHorizontalSpotsThenXisWinner() {

        ticTacToe.play(1, 1);//x
        ticTacToe.play(2, 1);//o
        ticTacToe.play(1, 2);//x
        ticTacToe.play(2, 2);//o
        assertEquals(TicTacToe.player.X.toString() + "is winner", ticTacToe.play(1, 3));

    }

    @Test
    public void whenXMarkedAllVerticalSpotsThenXisWinner() {

        ticTacToe.play(1, 1);//x
        ticTacToe.play(1, 2);//o
        ticTacToe.play(2, 1);//x
        ticTacToe.play(2, 2);//o
        assertEquals(TicTacToe.player.X.toString() + "is winner", ticTacToe.play(3, 1));

    }

    @Test
    public void whenOMarkedAllDiagonalThenOisWinner() {

        ticTacToe.play(1, 2);//x
        ticTacToe.play(1, 1);//o
        ticTacToe.play(2, 1);//x
        ticTacToe.play(2, 2);//o
        ticTacToe.play(3, 1);//x
        assertEquals(TicTacToe.player.Y.toString() + "is winner", ticTacToe.play(3, 3));


    }

    @Test
    public void WhenOppositeDiagonalThenXIsWinner() {

        ticTacToe.play(1, 3);
        ticTacToe.play(1, 2);
        ticTacToe.play(2, 2);
        ticTacToe.play(2, 3);
        assertEquals(TicTacToe.player.X.toString() + "is winner", ticTacToe.play(3, 1));


    }

    @Test

    public void WhenAllBoxesAreFilledWithNoWinningConditionThenDraw() {

        ticTacToe.play(1, 2); //X
        ticTacToe.play(1, 1); //O
        ticTacToe.play(2, 2); //X
        ticTacToe.play(1, 3);//O
        ticTacToe.play(2, 1); //X
        ticTacToe.play(2, 3);//O
        ticTacToe.play(3, 1); //X
        ticTacToe.play(3, 2);//O
        assertEquals("Game is a Draw", ticTacToe.play(3, 3));
    }
}