package ui;

import Persistence.Reader;
import Persistence.Savable;
import model.Customer;
import model.Reservation;
import model.Table;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

public class RestaurantManager implements Savable {


    /** integers where 0=12am and list contains tables reserved */
    HashMap<Integer, List<Reservation>> reservations;

//    initialize variable
    RestaurantManager() {
        reservations = new HashMap<>();
    }

//   corresponding table at time is added to the reservations hashmap
//    updates ui
    void addReservation(int time, Table table, Customer customer) {
        List<Reservation> reservs = reservations.get(time);
        Reservation r = new Reservation(table, customer);
        reservations.get(time).add(r);
    }

//    removes corresponding reservations
//    updates ui
    void removeReservation(int time, Table table, Customer customer) {
        List<Reservation> reservs = reservations.get(time);
        Reservation r = new Reservation(table, customer);
        reservations.get(time).remove(r);
    }


    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(reservations);
    }
}
