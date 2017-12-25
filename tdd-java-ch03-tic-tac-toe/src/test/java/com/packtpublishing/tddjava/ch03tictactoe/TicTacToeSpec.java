package com.packtpublishing.tddjava.ch03tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeSpec {

    @Rule
    public ExpectedException exp=ExpectedException.none();
    private TicTacToe ticTacToe;

    @Before
    public final void before(){
        ticTacToe=new TicTacToe();
    }

    @Test
    public void whenXisOutsideThenThrowRuntimeException(){
        exp.expect(RuntimeException.class);
        ticTacToe.play(5,2);

    }}
