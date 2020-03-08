package ui;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class OwnerStage extends Stage {
    static final String FILE_NAME = System.getProperty("user.dir") + "\\src\\save";
    LayoutManager lm;
    RestaurantManager rm;
    AnchorPane button;
    VBox addTable;
    Button TS;
    Button FS;

    public OwnerStage() {
        super();
        BorderPane root = new BorderPane();
        setTitle("Restaurant Layout");

        rm = new RestaurantManager();
        lm = new LayoutManager(rm);
        lm.setOwner(true);

        button = new AnchorPane();
        addTable = new VBox();
        TS = new Button("2 Seats");
        FS = new Button("4 Seats");
        addTable.getChildren().addAll(TS, FS);

        button.getChildren().addAll(addTable);
        lm.getChildren().addAll(button);

        MenuBar menuBar = new MenuBar();
        initMenuBar(menuBar);
        root.setTop(menuBar);
        root.setCenter(lm);

        TS.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                lm.addTable(2);
            }
        });

        FS.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                lm.addTable(4);
            }
        });


        setScene(new Scene(root, 800, 800));
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
            rm = RestaurantManager.load(FILE_NAME);

            lm.restaurantManager = rm;
            lm.update();
        });


        MenuItem menuItemSave = new MenuItem("Save...");
        menuItemSave.setOnAction(event -> {
            RestaurantManager.save(rm, FILE_NAME);
        });
        MenuItem viewInfo = new MenuItem("View Info...");
        viewInfo.setOnAction(event -> {
            try {
                StackPane root = new StackPane();
                TableView table = new TableView();
                List list = new ArrayList();
                list.add(rm.reservations);
                table.setItems(FXCollections.observableList(list));
                root.getChildren().add(table);
                Scene scene = new Scene(root, 300, 250);
                setTitle("Details");
                setScene(scene);
                show();
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        fileMenu.getItems().addAll(menuItemOpen, menuItemSave, viewInfo);
        menuBar.getMenus().addAll(fileMenu);

    }

}
