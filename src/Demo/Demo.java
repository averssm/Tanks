package Demo;

import Services.BattleField;

import javax.swing.*;

public class Demo extends JPanel {

    public static void main(String[] args) throws Exception {
        BattleField bf = new BattleField();
        bf.init();
        boolean isContinue;
        do {
            isContinue = bf.nextTurn();
            bf.repaint();
            Thread.sleep(50);
        } while (isContinue);

    }

}
