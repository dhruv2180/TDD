package com.packtpublishing.tddjava.ch03tictactoe;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.packtpublishing.tddjava.ch03tictactoe.mongo.TicTacToeBean;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.net.UnknownHostException;

public class TicTacToeCollection {
    private MongoCollection mongoCollection;

    protected MongoCollection getMongoCollection(){
        return mongoCollection;
    }

    public TicTacToeCollection() throws UnknownHostException{

        DB db=new MongoClient().getDB("tic-tac-toe");
        mongoCollection=new Jongo(db).getCollection("game");
    }

    public boolean saveMove(TicTacToeBean bean){
        getMongoCollection().save(bean);
        return true;
    }
}
