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
        point=new Point(1,1);
        location=new Location(point,Direction.NORTH);
        ship=new Ship(location);
    }

    public void whenShipsPointDirectionIsSetThenLocationIsSet(){
        assertEquals(ship.getLocation(),location);
    }

}
