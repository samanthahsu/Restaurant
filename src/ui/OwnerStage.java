package ui;

import Persistence.Reader;
import Persistence.Writer;
import javafx.application.Platform;
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
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class OwnerStage extends Stage {
    static final File FILE = new File(System.getProperty("user.dir") + "\\src\\save");
    LayoutManager lm;
    RestaurantManager rm;
    AnchorPane button;
    Button addTable;

    public OwnerStage() {
        super();
        BorderPane root = new BorderPane();
        setTitle("Restaurant Layout");

        rm = new RestaurantManager();
        lm = new LayoutManager(rm);
        lm.setOwner(true);

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

        setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
            }
        });
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
                rm = Reader.readRestaurantManager(FILE);
                System.out.println(rm);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        MenuItem menuItemSave = new MenuItem("Save...");
        menuItemSave.setOnAction(event -> {
            try {
                Writer writer = new Writer(FILE);
                writer.write(rm);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });
        MenuItem menuItemSaveAs = new MenuItem("Save As...");
        fileMenu.getItems().addAll(menuItemNew, menuItemOpen, menuItemSave, menuItemSaveAs);
        menuBar.getMenus().addAll(fileMenu);
    }

}
