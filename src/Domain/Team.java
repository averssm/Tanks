package Domain;

import java.awt.*;

public class Team {
    String name;
    int countTanks = 0;
    Color colorMain;
    Color colorTower;
    Color colorBarrel;
    Color colorCaterpillar;
    Color colorBullet;

    public Team (String name, Color colorMain, Color colorTower, Color colorBarrel, Color colorCaterpillar, Color colorBullet) {
        this.name = name;
        this.colorMain = colorMain;
        this.colorTower = colorTower;
        this.colorBarrel = colorBarrel;
        this.colorCaterpillar = colorCaterpillar;
        this.colorBullet = colorBullet;
    }

    public void incTanks() {
        countTanks++;
    };
    public void decTanks() {
        countTanks--;
    };

    public int getCountTanks() {
        return countTanks;
    }

    public String getName() {
        return name;
    }

    public Color getColorMain() {
        return colorMain;
    }
}
