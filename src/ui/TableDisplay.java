package ui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Table;

import java.io.Writer;

public class TableDisplay extends Rectangle {

    final static int WIDTH = 100;
    final static int HEIGHT = 200;
    boolean reserved;
    Table table;

    TableDisplay(Table table) {
        setWidth(WIDTH);
        setHeight(HEIGHT);
        free();
        this.table = table;
    }

//    sets color of the table
    public void setColor(Color color) {
        setFill(color);
    }

    public void reserve() {
        setFill(Color.RED);
        this.reserved = true;
    }

    public void free() {
        setFill(Color.GREEN);
        this.reserved = false;
    }
}
