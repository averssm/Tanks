package Domain;

public class Settings {
    public final static int[][] field = {
            {0, 4, 0, 0, 2, 2, 2, 0, 2, 0, 0},
            {0, 1, 1, 0, 0, 0, 0, 0, 2, 4, 0},
            {0, 1, 1, 2, 2, 2, 2, 0, 2, 0, 0},
            {0, 1, 1, 0, 0, 4, 0, 0, 1, 1, 0},
            {0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
            {2, 2, 2, 0, 1, 1, 3, 1, 0, 2, 0},
            {0, 0, 0, 0, 0, 0, 0, 2, 4, 2, 0},
            {4, 2, 2, 0, 0, 1, 0, 0, 0, 2, 3},
            {0, 2, 4, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 2, 0, 2, 0, 1, 0, 0, 0, 2, 4},
            {0, 2, 0, 0, 2, 2, 2, 0, 0, 2, 0}
    };

    public final static int SCALE = 25;
    public final static int BORDER_RADIUS = 5;
    public final static int COUNT_X = 11;
    public final static int COUNT_Y = 11;
    public final static int FIRST_X = 11;
    public final static int FIRST_Y = 11;
    public final static int SPEED_TANK = 1;
    public final static int SPEED_BULLET = 3;

    public int BF_WIDTH = (2 * SCALE + 1) * COUNT_X + 2 * (2 * BORDER_RADIUS + 1);
    public int BF_HEIGHT = (2 * SCALE + 1) * COUNT_Y + 2 * (2 * BORDER_RADIUS + 1);



}
