package ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.awt.*;
import java.io.FileInputStream;

public class Main extends Application {
    HBox options;
    Button customer;
    Button owner;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Select Option");
        BorderPane root = new BorderPane();
        options = new HBox();
        FileInputStream input = new FileInputStream("111.jfif");
        Image img = new Image(input);
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        // create Background
        Background background = new Background(backgroundimage);

        // set background
        options.setBackground(background);

        MenuBar menuBar = new MenuBar();
        initMenuBar(menuBar);


        customer = new Button("Customer");
        customer.setMinSize(200,150);
        customer.setStyle("-fx-font-size: xx-large");

        owner = new Button("Owner");
        owner.setMinSize(200, 150);
        owner.setStyle("-fx-font-size: xx-large");

        options.getChildren().addAll(customer,owner);
        options.setAlignment(Pos.CENTER);

        customer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                new CustomerStage();
            }
        });

        owner.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                new OwnerStage();
            }
        });

        root.setCenter(options);
        root.setTop(menuBar);

        primaryStage.setScene(new Scene(root, 1000, 800));

        primaryStage.show();

    }

    private void initMenuBar(MenuBar menuBar) {
        Menu fileMenu = new Menu("File");
        MenuItem menuItemNew = new MenuItem("New...");
        MenuItem menuItemOpen = new MenuItem("Open...");
        MenuItem menuItemSave = new MenuItem("Save...");
        MenuItem menuItemSaveAs = new MenuItem("Save As...");
        fileMenu.getItems().addAll(menuItemNew, menuItemOpen, menuItemSave, menuItemSaveAs);
        menuBar.getMenus().addAll(fileMenu);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
