package ui;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Customer;
import model.Table;

import java.util.HashMap;
import java.util.List;

public class RestaurantManager {

    /** list of all tables*/
    List<Table> allTables;


    /** integers where 0=12am and list contains tables reserved */
    HashMap<Integer, List<Table>> reservations;
    Pane pane;

//    initialize variable
    RestaurantManager() {

    }

//   corresponding table at time is added to the reservations hashmap
//    updates ui
    void addReservation(int time, Customer customer){}

//    removes corresponding reservations
//    updates ui
    void removeReservation(int time, Customer customer){}

    public EventHandler<MouseEvent> getOnMousePressedEventHandler() {
        return null;
    }


}
