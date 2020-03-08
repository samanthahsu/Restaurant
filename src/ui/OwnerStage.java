package ui;

import Persistence.Reader;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class OwnerStage extends Stage {
    LayoutManager lm;
    RestaurantManager rm;
    AnchorPane button;
    Button addTable;

    public OwnerStage() {
        BorderPane root = new BorderPane();
        setTitle("Restaurant Layout");
        lm = new LayoutManager(rm);
        button = new AnchorPane();
        addTable = new Button("Add Table");

        button.getChildren().addAll(addTable);
        lm.getChildren().addAll(button);

        MenuBar menuBar = new MenuBar();
        initMenuBar(menuBar);
        root.setTop(menuBar);
        root.setCenter(lm);

        setScene(new Scene(root, 1000, 800));
        show();
    }

    private void initMenuBar(MenuBar menuBar) {
        Menu fileMenu = new Menu("File");
        MenuItem menuItemNew = new MenuItem("New...");
        menuItemNew.setOnAction(event -> {

        });
        MenuItem menuItemOpen = new MenuItem("Open...");
        menuItemOpen.setOnAction(event -> {
            Reader reader = new Reader();
            try {
                rm = Reader.readRestaurantManager(new File(System.getProperty("user.dir") + "\\src\\save"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        MenuItem menuItemSave = new MenuItem("Save...");
        MenuItem menuItemSaveAs = new MenuItem("Save As...");
        fileMenu.getItems().addAll(menuItemNew, menuItemOpen, menuItemSave, menuItemSaveAs);
        menuBar.getMenus().addAll(fileMenu);
    }

}
