package Domain;

import java.awt.*;

public class Barrage extends Unit {
    public Barrage (int centerX, int centerY, int radius) {
        super(centerX, centerY, radius, radius, UnitType.BARRAGE, new Color(50, 50, 200));
    }

    @Override
    public void paint(Graphics g) {

        int x1 = getCenterX()-getHalfX()/2;
        int x2 = getCenterX()+getHalfX()/2+1;
        int y1 = getCenterY()-getHalfY()/2;
        int y2 = getCenterY()+getHalfY()/2+1;
        int offX = getHalfX()/2;
        int offY = getHalfY()/2;
//        Domain.Draw.drawPyramide(g,x1,y1,offX,offY,new Color(0,250,0));
//        Domain.Draw.drawPyramide(g,x1,y2,offX,offY,new Color(0,250,0));
//        Domain.Draw.drawPyramide(g,x2,y1,offX,offY,new Color(0,250,0));
//        Domain.Draw.drawPyramide(g,x2,y2,offX,offY,new Color(0,250,0));

        Draw.drawDiamond(g,x1,y1,offX,offY,offX/3,new Color(250,250,250));
        Draw.drawDiamond(g,x1,y2,offX,offY,offX/3,new Color(250,250,250));
        Draw.drawDiamond(g,x2,y1,offX,offY,offX/3,new Color(250,250,250));
        Draw.drawDiamond(g,x2,y2,offX,offY,offX/3,new Color(250,250,250));

    }


    }
