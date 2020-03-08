package model;

import java.io.Serializable;

/**/
public abstract class Table implements Serializable {
    protected int seats;
    protected double x;
    protected double y;

    public void setPosition(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public abstract int getHeight();

    public abstract int getWidth();

}

