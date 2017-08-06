package Domain;

import java.awt.*;

import static java.lang.Math.abs;

public class Tank extends Movable{
    Team team;

    public Tank(int centerX, int centerY, int radius, Team team) {
       this(centerX, centerY, radius, Direction.UP,Settings.SPEED_TANK, team);
    }

    public Tank(int centerX, int centerY, int radius, Direction direction, Team team) {
        this(centerX, centerY, radius, direction,Settings.SPEED_TANK, team);
    }

    public Tank(int centerX, int centerY, int radius, Direction direction, int speed, Team team) {
        super(centerX, centerY, radius, UnitType.TANK, team.colorMain, direction, speed);
        this.team = team;
        this.team.incTanks();
    }

    public Bullet fire() {
        Bullet bullet = new Bullet(getCenterX()+direction.getOffX()*(Settings.SCALE+Settings.SCALE/3),getCenterY()+direction.getOffY()*(Settings.SCALE+Settings.SCALE/3),Settings.SCALE/6, direction,team);
        return bullet;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;


        g.setColor(team.colorMain);
        Draw.drawDiamond(g,getCenterX(),getCenterY(),getHalfX()-10 * abs(direction.getOffY()) -5 * abs(direction.getOffX()), getHalfY()-10 * abs(direction.getOffX())-5 * abs(direction.getOffY()), 3, team.colorMain);

        g.setColor(team.colorCaterpillar);
        Stroke s = g2D.getStroke();

        int k = iteration%2;
        iteration++;
        float[] f;
        if (k==1) {
            f = new float[]{1, 2, 3, 2, 2, 0};
        } else {
            f = new float[]{3, 2, 3, 2};
        }

        g2D.setStroke(new BasicStroke(1.0f, 2, 0, 10.0f, f, 5.0f));

        for (int x = -5 * abs(direction.getOffY()); x <= 5 * abs(direction.getOffY()); x++) {
            for (int y = -5 * abs(direction.getOffX()); y <= 5 * abs(direction.getOffX()); y++) {
                g2D.drawLine(x + getCenterX() + (direction.getOffX() * Settings.SCALE) + (direction.getOffY() * (Settings.SCALE-5)), y + getCenterY() + (direction.getOffY() * Settings.SCALE) + (direction.getOffX() * (Settings.SCALE-5)),
                        x + getCenterX() - (direction.getOffX() * Settings.SCALE) + (direction.getOffY() * (Settings.SCALE-5)), y + getCenterY() - (direction.getOffY() * Settings.SCALE) + (direction.getOffX() * (Settings.SCALE-5)));
                g2D.drawLine(x + getCenterX() + (direction.getOffX() * Settings.SCALE) - (direction.getOffY() * (Settings.SCALE-5)), y + getCenterY() + (direction.getOffY() * Settings.SCALE) - (direction.getOffX() * (Settings.SCALE-5)),
                        x + getCenterX() - (direction.getOffX() * Settings.SCALE) - (direction.getOffY() * (Settings.SCALE-5)), y + getCenterY() - (direction.getOffY() * Settings.SCALE) - (direction.getOffX() * (Settings.SCALE-5)));
            }
        }
        g2D.setStroke(s);

        Draw.drawDiamond(g,getCenterX(),getCenterY(),(int) (getHalfX()*0.4), (int) (getHalfY() *0.4), 4, team.colorTower);

        g.fillOval(getCenterX()-4,getCenterY()-4,8,8);
        g.setColor(team.colorBarrel);
        for (int x = -3 * abs(direction.getOffY()); x <= 3 * abs(direction.getOffY()); x++) {
            for (int y = -3 * abs(direction.getOffX()); y <= 3 * abs(direction.getOffX()); y++) {
                g.drawLine(x + getCenterX() + (direction.getOffX() * (Settings.SCALE-17)), y + getCenterY() + (direction.getOffY() * (Settings.SCALE-17)),
                           x + getCenterX() + (direction.getOffX() * (Settings.SCALE-2)), y + getCenterY() + (direction.getOffY() * (Settings.SCALE-2)));
            }
        }

    }

    public Team getTeam() {
        return team;
    }
}
