package com.evergreen.titz;

/**
 * Created by apollo on 11/12/2016.
 */
public enum SpritesheetValues {
    SPRITESHEET(13, 21),
    WALK_BACK(8, 1, 8),
    WALK_LEFT(9, 1, 8),
    WALK_FRONT(10, 1, 8),
    WALK_RIGHT(11, 1, 8),
    SHOOT_BACK(16, 1, 12),
    SHOOT_LEFT(17, 1, 12),
    SHOOT_FRONT(18, 1, 12),
    SHOOT_RIGHT(19, 1, 12),;

    public int WIDTH, HEIGHT;
    public int ROW, START_COL, END_COL;

    SpritesheetValues(int pWidth, int pHeight) {
        this.WIDTH = pWidth;
        this.HEIGHT = pHeight;
    }

    SpritesheetValues(int pRow, int pStartCol, int pEncCol) {
        this.ROW = pRow;
        this.START_COL = pStartCol;
        this.END_COL = pEncCol;
    }
}
