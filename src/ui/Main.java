package ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    ListView<Integer> listOfTimes;
    ObservableList<Integer> times;
    LayoutManager layoutManager;
    RestaurantManager restaurantManager;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Restaurant Reservation");

        listOfTimes = new ListView<>();
        times = FXCollections.observableArrayList();
        times.addAll(10,11,12);
        listOfTimes.setPrefSize(100,275);
        listOfTimes.setItems(times);

        restaurantManager = new RestaurantManager();
        layoutManager = new LayoutManager(restaurantManager);

        listOfTimes.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                layoutManager.displayAtTime(listOfTimes.getEditingIndex());
            }
        });

        BorderPane bPane = new BorderPane();
        bPane.setLeft(listOfTimes);
        bPane.setCenter(layoutManager);


        primaryStage.setScene(new Scene(bPane, 1000, 800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
