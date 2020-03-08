package model;

public class FourSeater extends Table {
    private static final int width = 30;
    private static final int height = 50;

    //EFFECTS: constructs a new two seater table with given x and y coordinate
    public FourSeater(int newX, int newY) {
        this.seats = 4;
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
