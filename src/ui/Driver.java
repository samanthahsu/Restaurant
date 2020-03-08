package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Driver extends Application {
    /**
     * Launches the temperature converter application.
     * @param primaryStage a Stage
     * @throws IOException
     */
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("Welcome");
        ReservationWindow r = new ReservationWindow();

    }
    /**
     * Launches the JavaFX application.
     *
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
