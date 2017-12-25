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
    public void whenSpotAlreadyOccupiedThenThrowRuntimeException(){

        ticTacToe.play(1,1);
        exp.expect(RuntimeException.class);
        ticTacToe.play(1,1);

    }

    @Test
    public void whenGameBeginsNextPlayerIsX(){

        assertEquals(TicTacToe.player.X,ticTacToe.getNextPlayer());

    }

    @Test
    public void whenXPlayedThenNextPlayerIsO(){

        ticTacToe.play(1,1);
        assertEquals(TicTacToe.player.Y,ticTacToe.getNextPlayer());

    }

    @Test
    public void whenOPlayedThenNextPlayerisX(){

        ticTacToe.play(1,1);
        ticTacToe.play(2,2);
        ticTacToe.play(1,2);
        ticTacToe.play(2,1);
        assertEquals(TicTacToe.player.X,ticTacToe.getNextPlayer());

    }
}