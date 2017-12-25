package com.packtpublishing.tddjava.ch04ship;

public class Ship {

    private Location location;

    public Ship(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public boolean forward() {

        return location.forward();
    }

    public boolean backward() {

        return location.backward();
    }

    public Direction getDirection() {
        return location.getDirection();
    }

    public void turnLeft() {
        Direction direction = location.getDirection().turnLeft();
        location.setDirection(direction);
    }

    public void turnRight() {
        Direction direction = location.getDirection().turnRight();
        location.setDirection(direction);
    }

    public void move(String command) {

        for (char c : command.toCharArray()) {

            switch (c) {
                case 'l':
                    turnLeft();
                    break;
                case 'r':
                    turnRight();
                    break;
                case 'b':
                    backward();
                    break;
                case 'f':
                    forward();
                    break;
            }
        }


    }
}
