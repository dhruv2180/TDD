package com.packtpublishing.tddjava.ch04ship;

import org.testng.annotations.*;

import static org.testng.Assert.*;

@Test
public class ShipSpec {

    private Ship ship;
    private Location location;
    private Point point;

    @BeforeMethod
    public void beforeTest(){
        point=new Point(21,13);
        location=new Location(point,Direction.NORTH);
        ship=new Ship(location);
    }

    public void whenShipsPointDirectionIsSetThenLocationIsSet(){
        assertEquals(ship.getLocation(),location);
    }

    public void whenMovedForwardThenMoveForward(){

        location.forward();
        ship.forward();
        assertEquals(location,ship.getLocation());

    }

    public void whenMovedBackwardThenMoveBackward(){
        location.backward();
        ship.backward();
        assertEquals(location,ship.getLocation());

    }

    public void whenTurnLeftThenTurnLeft(){
        Direction expectedDirection =location.getDirection().turnLeft();
        ship.turnLeft();
        assertEquals(expectedDirection,ship.getDirection());
    }

    public void whenTurnRightThenTurnRight(){
        Direction expectedDirection=location.getDirection().turnRight();
        ship.turnRight();
        assertEquals(expectedDirection,ship.getDirection());
    }
}
