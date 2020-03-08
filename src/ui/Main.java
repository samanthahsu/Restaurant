package ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileInputStream;

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
                primaryStage.hide();
            }
        });
        owner.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                new OwnerStage();
                primaryStage.hide();
            }
        });

        root.setCenter(options);

        primaryStage.setScene(new Scene(root, 1000, 800));

        primaryStage.show();

//        closes all offending windows when main window is closed
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
