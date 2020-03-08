package ui;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class OwnerStage extends Stage {
    LayoutManager lm;
    RestaurantManager rm;
    AnchorPane button;
    Button addTable;

    public OwnerStage() {
        setTitle("Restaurant Layout");
        lm = new LayoutManager(rm);
        button = new AnchorPane();
        addTable = new Button("Add Table");

        button.getChildren().addAll(addTable);
        lm.getChildren().addAll(button);

        setScene(new Scene(lm, 1000, 800));
        show();
    }
}
