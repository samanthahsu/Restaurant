package ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    HBox options;
    Button customer;
    Button owner;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Select Option");
        options = new HBox();

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

        primaryStage.setScene(new Scene(options, 1000, 800));

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
