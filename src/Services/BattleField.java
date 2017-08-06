package Services;

import Domain.*;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class BattleField extends JPanel {

    int[][] field = Settings.field;
    int SCALE = Settings.SCALE;
    int borderRadius = Settings.BORDER_RADIUS;
    int COUNT_X = Settings.COUNT_X;
    int COUNT_Y = Settings.COUNT_Y;
    int firstX = Settings.FIRST_X;
    int firstY = Settings.FIRST_Y;
    int BF_WIDTH = (2 * SCALE + 1) * COUNT_X + 2 * (2 * borderRadius + 1);
    int BF_HEIGHT = (2 * SCALE + 1) * COUNT_Y + 2 * (2 * borderRadius + 1);

    Point getCenterField(int x, int y) {
        return new Point(firstX + (2 * x - 1) * (SCALE) + x - 1, firstY + (2 * y - 1) * (SCALE) + y - 1);
    }

    Point getCornerField(int x, int y) {
        return new Point(firstX + 2 * (x - 1) * (SCALE) + x, firstY + 2 * (y - 1) * (SCALE) + y);
    }

    UnitList<Lend> lends = new UnitList<>();
    UnitList<Unit> units = new UnitList<>();

    int k = 0;


    Team teamNavy = new Team("Navy",
            new Color(50, 50, 250),
            new Color(0, 0, 250),
            new Color(50, 50, 50),
            new Color(50, 50, 50),
            new Color(0, 0, 250)
    );
    Team teamYellow = new Team("Yellow",
            new Color(250, 250, 50),
            new Color(250, 250, 0),
            new Color(50, 50, 50),
            new Color(50, 50, 50),
            new Color(250, 250, 50)
    );

    public BattleField() throws Exception {
        JFrame frame = new JFrame("Demo");
        frame.setLocation(750, 50);
        frame.setMinimumSize(new Dimension(BF_WIDTH + 16, BF_HEIGHT + 38));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    public void init() {
        units.add(new Unit(5, 291, 5, 291));
        units.add(new Unit(577, 291, 5, 291));
        units.add(new Unit(291, 5, 291, 5));
        units.add(new Unit(291, 577, 291, 5));
        int z = 0;
        for (int i = 1; i <= Settings.COUNT_X; i++) {
            for (int j = 1; j <= Settings.COUNT_Y; j++) {
                Point cen = getCenterField(i, j);
                lends.add(new Lend(cen.x, cen.y, SCALE));

                if (UnitType.STONE.equals(UnitType.values()[field[j - 1][i - 1]])) {
                    units.add(new Stone(cen.x, cen.y, SCALE));
                }
                if (UnitType.BUSH.equals(UnitType.values()[field[j - 1][i - 1]])) {
                    units.add(new Bush(cen.x, cen.y, SCALE));
                }
                if (UnitType.BARRAGE.equals(UnitType.values()[field[j - 1][i - 1]])) {
                    units.add(new Barrage(cen.x, cen.y, SCALE));
                }
                if (UnitType.TANK.equals(UnitType.values()[field[j - 1][i - 1]])) {
                    lends.add(new Lend(cen.x, cen.y, SCALE));
                }
                if (UnitType.TANK.equals(UnitType.values()[field[j - 1][i - 1]])) {
                    Tank tank = new Tank(cen.x, cen.y, SCALE, Direction.values()[z], (z % 2 == 0) ? teamNavy : teamYellow);
                    units.add(tank);
                    z++;
                    if (z >= 4) {
                        z = 0;
                    }
                }

            }
        }
    }

    public boolean nextTurn() throws Exception {
        recalcTanks();
        recalcBullet();
        removeUnits();
        int z = k % 100;
        if (z == 0) {
            shotTanks();
        }
        k++;
        return chechTeamWin();
    }

    void recalcTanks() {
        for (Unit moveUnit : units) {
            if (moveUnit instanceof Tank) {
                Tank moveTank = (Tank) moveUnit;
                boolean moveAllow = true;
                for (Unit otherUnit : units) {
                    if (moveTank == otherUnit) {
                        continue;
                    }
                    if (!(otherUnit instanceof Bullet)) {
                        moveAllow = moveAllow && !moveTank.nextIntersectWith(otherUnit);
                        if (!moveAllow) {
                            break;
                        }
                    }
                }
                if (!moveAllow) {
                    moveTank.changeDirection();
                    continue;
                }
                moveTank.moveForward();
            }
        }
    }

    void recalcBullet() {
        for (Unit moveUnit : units) {
            if (moveUnit == null) {
                continue;
            }
            if (moveUnit instanceof Bullet) {
                Bullet moveBullet = (Bullet) moveUnit;
                boolean moveAllow = true;
                for (Unit otherUnit : units) {
                    if (moveBullet == otherUnit) {
                        continue;
                    }
                    moveAllow = moveAllow && !moveBullet.nextIntersectWith(otherUnit);

                    if (!moveAllow) {
                        if (otherUnit instanceof Bullet) {
                            otherUnit.setToDestroy(true);
                        }
                        if (otherUnit instanceof Bush) {
                            otherUnit.setToDestroy(true);
                        }
                        if (otherUnit instanceof Tank) {
                            otherUnit.setToDestroy(true);
                        }
                        moveUnit.setToDestroy(true);
                        break;
                    }
                }
                if (!moveAllow) {
                    moveBullet.changeDirection();
                    continue;
                }
                moveBullet.moveForward();
            }
        }
    }

    void removeUnits() {
        Iterator iterator = units.iterator();
        while (iterator.hasNext()) {
            Unit unit = (Unit) iterator.next();
            if (unit.isToDestroy()) {
                if (unit instanceof Tank) {
                    Tank tank = (Tank) unit;
                    tank.getTeam().decTanks();
                }
                iterator.remove();
            }
        }

    }

    void shotTanks() {
        UnitList<Tank> tanks = new UnitList<>();
        for (Unit moveUnit : units) {
            if (moveUnit instanceof Tank) {
                tanks.add((Tank) moveUnit);
            }
        }
        for (Tank tank : tanks) {
            units.add(tank.fire());
        }
    }

    boolean chechTeamWin() {
        if (teamNavy.getCountTanks() <= 0) {
            System.out.printf("Domain.Team " + teamYellow.getName() + " WIN!");
            return false;
        } else if (teamYellow.getCountTanks() <= 0) {
            System.out.printf("Domain.Team " + teamNavy.getName() + " WIN!");
            return false;
        }
        return true;
    }

    void drawTeamWin(Graphics g, Team team) {
        Draw.drawDiamond(g, BF_WIDTH / 2, BF_HEIGHT / 2, 100, 30, 5, new Color(100, 250, 250));
//        g.setColor(new Color(250, 0, 0));
        g.setColor(team.getColorMain());
        g.setFont(g.getFont().deriveFont(20.0f));
        g.drawString("Team " + team.getName() + " WIN!", BF_WIDTH / 2 - 80, BF_HEIGHT / 2 + 5);
    }


    @Override
    protected void paintComponent(Graphics g) {

        for (Unit unit : lends) {
            unit.paint(g);
        }
        for (Unit unit : units) {
            unit.paint(g);
        }

        if (teamNavy.getCountTanks() <= 0) {
            drawTeamWin(g, teamYellow);
        } else if (teamYellow.getCountTanks() <= 0) {
            drawTeamWin(g, teamNavy);
        }

    }


}
