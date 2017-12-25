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
        Location expected=location.copy();
        Direction expectedDirection =expected.getDirection().turnLeft();
        ship.turnLeft();
        assertEquals(expectedDirection,ship.getDirection());
    }

    public void whenTurnRightThenTurnRight(){
        Location expected=location.copy();
        Direction expectedDirection=expected.getDirection().turnRight();
        ship.turnRight();
        assertEquals(expectedDirection,ship.getDirection());
    }

    public void whenCommandsAreReceivedThenExecuteTheCommands(){
        
        Location expected=location.copy();
        expected.turnRight();
        expected.forward();
        expected.turnLeft();
        expected.backward();
        ship.move("rflb");
        assertEquals(ship.getLocation(),expected);



    }
}
