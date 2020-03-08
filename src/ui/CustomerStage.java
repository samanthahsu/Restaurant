package ui;

import java.beans.EventHandler;

import javax.swing.text.html.ListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CustomerStage extends Stage {
    ListView<Integer> listOfTimes;
    ObservableList<Integer> times;
    RestaurantManager restaurantManager;
    LayoutManager layoutManager;

    public CustomerStage() {
        setTitle("Restaurant Reservation");

        listOfTimes = new ListView<>();
        times = FXCollections.observableArrayList();
        for (int i = 0; i < 24; i++) {
            times.add(i);
        }
        listOfTimes.setPrefSize(100,275);
        listOfTimes.setItems(times);

        restaurantManager = new RestaurantManager();
        layoutManager = new LayoutManager(restaurantManager);

        listOfTimes.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Integer time = listOfTimes.getSelectionModel().getSelectedItems().get(0);
                layoutManager.displayAtTime(time);
            }
        });

        BorderPane bPane = new BorderPane();
        bPane.setLeft(listOfTimes);
        bPane.setCenter(layoutManager);


        setScene(new Scene(bPane, 1000, 800));
        show();
    }
}
