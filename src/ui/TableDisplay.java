package ui;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Table;

public class TableDisplay extends Rectangle {

    final static int WIDTH = 70;
    final static int HEIGHT = 50;
    boolean reserved;
    Table table;

    TableDisplay(Table table) {
        setWidth(WIDTH);
        setHeight(HEIGHT);
        free();
        this.table = table;
    }

    public void reserve() {
        setFill(Color.RED);
        this.reserved = true;
    }

    public void free() {
        setFill(Color.GREEN);
        this.reserved = false;
    }

    public Table getTable() {
        return table;
    }
}
