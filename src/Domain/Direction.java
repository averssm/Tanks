package Domain;

public enum Direction {
    UP(0, -1), RIGHT(1, 0), DOWN(0, 1), LEFT(-1, 0);

    int offX;
    int offY;

    Direction(int offX, int offY) {
        this.offX = offX;
        this.offY = offY;
    }

    public int getOffX() {
        return offX;
    }

    public int getOffY() {
        return offY;
    }
}
