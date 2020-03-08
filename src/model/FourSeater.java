package model;

public class FourSeater extends Table {

    //EFFECTS: constructs a new two seater table with given x and y coordinate
    public FourSeater(int newX, int newY) {
        this.seats = 4;
        this.x = newX;
        this.y = newY;
    }
}
