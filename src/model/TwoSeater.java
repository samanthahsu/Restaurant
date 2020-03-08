package model;

public class TwoSeater extends Table {

    //EFFECTS: constructs a new two seater table with given x and y coordinate
    public TwoSeater(int newX, int newY) {
        this.seats = 2;
        this.x = newX;
        this.y = newY;
    }

}
