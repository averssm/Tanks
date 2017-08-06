package Domain;

import java.awt.*;

public class Stone extends Unit {
    public Stone (int centerX, int centerY, int radius) {
        super (centerX, centerY, radius, radius,UnitType.STONE,new Color(100, 100, 100));
    }

    @Override
    public void paint(Graphics g) {
        Draw.drawPyramide(g,getCenterX(),getCenterY(),getHalfX(),getHalfY(),new Color(250,250,250));

    }

}
