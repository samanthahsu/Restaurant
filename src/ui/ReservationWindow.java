package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Customer;
import ui.RestaurantManager;
import ui.TableDisplay;

import java.io.IOException;

public class ReservationWindow extends Stage {

    public ReservationWindow(final int reserveTime, final RestaurantManager restaurantManager, final TableDisplay tableDisplay) throws IOException {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setStyle("-fx-background-color: antiquewhite");

        Text scenetitle = new Text("Welcome!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Name:");
        grid.add(userName, 0, 1);

        final TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pn = new Label("Phonenumber:");
        grid.add(pn, 0, 2);

        final TextField pnBox = new TextField();
        grid.add(pnBox, 1, 2);

        Label seats = new Label("seat number:");
        grid.add(seats, 0, 3);

        final TextField seat = new TextField();
        grid.add(seat, 1, 3);

        final Label time = new Label("seating time:");
        grid.add(time, 0, 4);

        final TextField timee = new TextField();
        grid.add(timee, 1, 4);

        Button btn = new Button("submit");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 5);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                String name = userTextField.getText();
                String phone = pnBox.getText();
                String s = seat.getText();
                String t = timee.getText();
                int h = Integer.parseInt(t);
                int s1 = Integer.parseInt(s);
                if (s1 == 2 || s1 == 4) {
                    if (h < 3) {
                        Customer customer =new Customer(name, phone);
                        restaurantManager.addReservation(reserveTime, tableDisplay, customer);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Table reserved!");
                        alert.showAndWait();
                        close();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("error");
                        alert.setHeaderText("wrong no. of hours entered");
                        alert.setContentText("enter a value less than 3");
                        alert.showAndWait();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("error");
                    alert.setHeaderText("wrong no. seats for table entered");
                    alert.setContentText("either 2 seater or 4 seater is available.");
                    alert.showAndWait();
                }
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        setTitle("book yourself");
        setScene(scene);
        show();
    }

}
