package ui;

import Persistence.Reader;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {
    HBox options;
    Button customer;
    Button owner;
    Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        primaryStage.setTitle("Select Option");
        BorderPane root = new BorderPane();
        options = new HBox();
            FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "\\src\\111.jfif");
            Image img = new Image(input);
            BackgroundImage backgroundimage = new BackgroundImage(img,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);
            // create Background
            Background background = new Background(backgroundimage);

            // set background
            options.setBackground(background);
            options.setStyle("-fx-background-size: 1024 768");

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

    private void initData() {
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
                reader.readRestaurantManager(new File(System.getProperty("user.dir") + "\\src\\save"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        MenuItem menuItemSave = new MenuItem("Save...");
        MenuItem menuItemSaveAs = new MenuItem("Save As...");
        fileMenu.getItems().addAll(menuItemNew, menuItemOpen, menuItemSave, menuItemSaveAs);
        menuBar.getMenus().addAll(fileMenu);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
