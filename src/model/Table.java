package model;

import java.io.Serializable;

/**/
public abstract class Table implements Serializable {
    protected int seats;
    protected int x;
    protected int y;

    public void setPosition(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract int getHeight();

    public abstract int getWidth();

}

