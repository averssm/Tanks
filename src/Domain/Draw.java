package Domain;

import java.awt.*;

public class Draw {

    static public void drawDiamond(Graphics g,int centerX,int centerY,int offX, int offY, int border, Color color) {
        int x1 = centerX - offX;
        int xx1 = x1+border;
        int x2 = centerX + offX;
        int xx2 = x2-border;
        int y1 = centerY - offY;
        int yy1 = y1+border;
        int y2 = centerY + offY;
        int yy2 = y2-border;

        int cR = color.getRed()/5;
        int cG = color.getGreen()/5;
        int cB = color.getBlue()/5;

        int i = 5;
        g.setColor(new Color(cR*i, cG*i, cB*i));
        i--;
        g.fillPolygon(new int[]{x1,x1,xx1,xx1,x1},
                new int[]{y2,y1,yy1,yy2,y2},5);
        g.setColor(new Color(cR*i, cG*i, cB*i));
        i--;
        g.fillPolygon(new int[]{x1,x2,xx2,xx1,x1},
                new int[]{y1,y1,yy1,yy1,y1},5);
        g.setColor(new Color(cR*i, cG*i, cB*i));
        i--;
        g.fillPolygon(new int[]{x2,x2,xx2,xx2,x2},
                new int[]{y1,y2,yy2,yy1,y1},5);
        g.setColor(new Color(cR*i, cG*i, cB*i));
//        i--;
        g.fillPolygon(new int[]{x2,x1,xx1,xx2,x2},
                      new int[]{y2,y2,yy2,yy2,y2},5);

        g.setColor(color);
        g.fillPolygon(new int[]{xx1,xx2,xx2,xx1,xx1},
                new int[]{yy1,yy1,yy2,yy2,yy1},5);

//        g.setColor(new Color (150,150,150));
//        g.setColor(new Color(cR*i, cG*i, cB*i));
//        g.drawPolyline(new int[]{xx1,xx2,xx2,xx1,xx1},
//                new int[]{yy1,yy1,yy2,yy2,yy1},5);

    }


    static public void drawPyramide(Graphics g,int centerX,int centerY,int offX, int offY, Color color) {
        int x0 = centerX;
        int x1 = centerX - offX;
        int x2 = centerX + offX;
        int y0 = centerY;
        int y1 = centerY - offY;
        int y2 = centerY + offY;

        int cR = color.getRed()/5;
        int cG = color.getGreen()/5;
        int cB = color.getBlue()/5;

        int i = 5;
        g.setColor(new Color(cR*i, cG*i, cB*i));
        i--;
        g.fillPolygon(new int[]{x0,x1,x1,x0},
                new int[]{y0,y2,y1,y0},4);
        g.setColor(new Color(cR*i, cG*i, cB*i));
        i--;
        g.fillPolygon(new int[]{x0,x1,x2,x0},
                new int[]{y0,y1,y1,y0},4);
        g.setColor(new Color(cR*i, cG*i, cB*i));
        i--;
        g.fillPolygon(new int[]{x0,x2,x2,x0},
                new int[]{y0,y1,y2,y0},4);
        g.setColor(new Color(cR*i, cG*i, cB*i));
        i--;
        g.fillPolygon(new int[]{x0,x2,x1,x0},
                new int[]{y0,y2,y2,y0},4);
    }

}
