package Domain;

import java.awt.*;

public class Bullet extends Movable{
    Team team;

    public Bullet(int centerX, int centerY, int radius, Direction direction, Team team) {
        this(centerX, centerY, radius, direction, Settings.SPEED_BULLET, team);
    }

    public Bullet(int centerX, int centerY, int radius, Direction direction, int speed, Team team) {
        super(centerX, centerY, radius, UnitType.BULLET, team.colorBullet, direction, speed);
        this.team = team;
    }

    @Override
    public void paint(Graphics g) {
        Draw.drawDiamond(g, getCenterX(), getCenterY(), getHalfX(), getHalfY(), 2, getColor());

    }

    @Override
    public boolean nextIntersectWith(Unit unit) {
        if (unit instanceof Barrage) {
            return false;
        } else {
            return super.nextIntersectWith(unit);
        }
    }
}
