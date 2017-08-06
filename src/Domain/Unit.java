package Domain;

import java.awt.*;

import static java.lang.Math.abs;

public class Unit {
    private int centerX;
    private int centerY;
    private int halfX;
    private int halfY;
    private Color color;
    private UnitType unitType;
    private boolean toDestroy = false;

    public Unit(int centerX, int centerY, int halfX, int halfY) {
        this(centerX, centerY, halfX, halfY, UnitType.BORDER,  new Color(100, 100, 100));
    }

    public Unit(int centerX, int centerY, int radius, UnitType unitType, Color color) {
        this(centerX, centerY, radius, radius,unitType,color);
    }

    public Unit(int centerX, int centerY, int halfX, int halfY, UnitType unitType, Color color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.halfX = halfX;
        this.halfY = halfY;
        this.unitType = unitType;
        this.color = color;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(centerX - halfX, centerY - halfY, getWidth(), getHeight());
    }

    public Point getCurrPosition() {
        return new Point(centerX, centerY);
    }

    public int getWidth() {
        return halfX * 2 + 1;
    }

    public int getHeight() {
        return halfY * 2 + 1;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getHalfX() {
        return halfX;
    }

    public int getHalfY() {
        return halfY;
    }

    public Color getColor() { return color; }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public boolean isToDestroy() {
        return toDestroy;
    }

    public void setToDestroy(boolean toDestroy) {
        this.toDestroy = toDestroy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        if (centerX != unit.centerX) return false;
        if (centerY != unit.centerY) return false;
        if (halfX != unit.halfX) return false;
        if (halfY != unit.halfY) return false;
        if (!color.equals(unit.color)) return false;
        return unitType == unit.unitType;
    }

    @Override
    public int hashCode() {
        int result = centerX;
        result = 31 * result + centerY;
        result = 31 * result + halfX;
        result = 31 * result + halfY;
        result = 31 * result + color.hashCode();
        result = 31 * result + unitType.hashCode();
        return result;
    }
}
