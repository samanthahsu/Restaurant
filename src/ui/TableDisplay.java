package ui;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Table;

public class TableDisplay extends Rectangle {

    boolean reserved;
    Table table;

    TableDisplay(Table table) {
        setWidth(table.getWidth());
        setHeight(table.getHeight());
        free();
        this.table = table;
    }

    public void reserve() {
        setFill(Color.DARKRED);
        this.reserved = true;
    }

    public void free() {
        setFill(Color.LIGHTSEAGREEN);
        this.reserved = false;
    }

    public Table getTable() {
        return table;
    }
}
