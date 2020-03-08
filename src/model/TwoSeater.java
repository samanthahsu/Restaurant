package model;

public class TwoSeater extends Table {
    private final int width = 80;
    private final int height = 100;

    //EFFECTS: constructs a new two seater table with given x and y coordinate
    public TwoSeater(int newX, int newY) {
        this.seats = 2;
        this.x = newX;
        this.y = newY;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }
}
