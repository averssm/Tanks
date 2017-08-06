package Domain;

import java.awt.*;

public enum UnitType {
    LEND(0),
    STONE(1),
    BUSH(2),
    BARRAGE(3),
    TANK(4),
    BULLET(5),
    BORDER(9);

    int index;

    UnitType(int index) {
        this.index = index;
    }

    public int getIndex() { return index; }
}
