package com.packtpublishing.tddjava.ch03tictactoe;


import com.packtpublishing.tddjava.ch03tictactoe.mongo.TicTacToeBean;
import org.jongo.MongoCollection;
import org.junit.*;
import static org.junit.Assert.*;
import java.net.UnknownHostException;
import static  org.mockito.Mockito.*;

public class TicTacToeCollectionSpec {

    TicTacToeCollection collection;

    @Before
    public void before() throws UnknownHostException {

        collection=spy(new TicTacToeCollection());

    }
    @Test
    public void whenInstantiatedThenMongoHasDbNameTicTacToe() throws UnknownHostException{

        assertEquals(collection.getMongoCollection().getDBCollection().getDB().getName(),"tic-tac-toe");
    }

    @Test
    public void whenInstantiatedThenMongoCollectionHasNameGame() throws UnknownHostException {

        assertEquals("game",collection.getMongoCollection().getName());

    }

    @Test
    public void WhenSaveMoveThenInvokeMongoCollectionSave(){

        TicTacToeBean ticTacToeBean=new TicTacToeBean(3,2,1,'Y');
        MongoCollection mongoCollection=mock(MongoCollection.class);
        doReturn(mongoCollection).when(collection).getMongoCollection();
        collection.saveMove(ticTacToeBean);
        verify(mongoCollection,times(1)).save(ticTacToeBean);
    }

    @Test
    public void WhenSaveMoveThenReturnTrue(){

        TicTacToeBean ticTacToeBean=new TicTacToeBean(3,2,1,'Y');
        MongoCollection mongoCollection=mock(MongoCollection.class);
        doReturn(mongoCollection).when(collection).getMongoCollection();
        assertTrue(collection.saveMove(ticTacToeBean));

    }
}
