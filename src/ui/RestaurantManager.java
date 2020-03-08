package ui;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Pair;
import model.Customer;
import model.Reservation;
import model.Table;

import java.util.HashMap;
import java.util.List;

public class RestaurantManager {

    HashMap<Integer, List<Reservation>> reservations;

//    initialize variable
     public RestaurantManager() {
        reservations = new HashMap<>();
    }

//   corresponding table at time is added to the reservations hashmap
//    updates ui
    public void addReservation(Integer time, Table table, Customer customer) {
         if (time <= 24) {
             List<Reservation> reservs = reservations.get(time);
             for (Reservation r: reservs) {
                 if (!r.getTable().equals(table)) {
                     reservations.get(time).add(new Reservation(table, customer));
                 }
             }
         }
    }

//    removes corresponding reservations
//    updates ui
    public void removeReservation(Integer time, Table table, Customer customer) {
        List<Reservation> reservs = reservations.get(time);
        for (Reservation r: reservs) {
            if (r.getCustomer().equals(customer)) {
                reservations.get(time).remove(r);
            }
        }
    }


    public List<Reservation> getReservations(Integer time) {
         if (time <= 24) {
             return reservations.get(time);
         }
         return null;
    }

}
