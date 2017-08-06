package Domain;

import java.awt.*;
import java.util.*;

import static java.lang.Math.abs;

public class Movable extends Unit {
    Direction direction;
    int iteration = 1;
    int speed;

    public Movable(int centerX, int centerY, int radius, UnitType unitType, Color color, Direction direction, int speed) {
                 super(centerX, centerY, radius, radius, unitType, color);
                 this.speed = speed;
        this.direction = direction;
    }

    private Point getOffset() {
        return new Point(speed*direction.getOffX(), speed*direction.getOffY());
    }

    public Point getNextPosition() {
        Point currPosition = getCurrPosition();
        Point offset = getOffset();
        return new Point(currPosition.x + offset.x, currPosition.y + offset.y);
    }
    public boolean nextIntersectWith(Unit unit) {
        Point thisPos = getNextPosition();
        Point thatPos = unit.getCurrPosition();
        return (abs(thisPos.x - thatPos.x) <= (getHalfX() + unit.getHalfX()))
                && (abs(thisPos.y - thatPos.y) <= (getHalfY() + unit.getHalfY()));
    }

    public void moveForward() {
        setCenterX(getNextPosition().x);
        setCenterY(getNextPosition().y);
    }

    public void changeDirection() {
        int d = direction.ordinal();

        while (d == direction.ordinal()) {
            d = new Random().nextInt(4);
        }
        direction = Direction.values()[d];
    }
}
