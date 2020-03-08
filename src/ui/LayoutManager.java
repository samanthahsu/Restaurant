package ui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.*;

import java.io.IOException;
import java.util.List;

/**main pane that displays all the tables
 * observes the restaurant manager*/
public class LayoutManager extends Pane {

//    list of all the table displays
    final static int OFFSET_X = 100;
    final static int OFFSET_Y = 200;
    int displayTime = 0;
    RestaurantManager restaurantManager;

//    populates pane with 12 tables at set layout places
    LayoutManager(RestaurantManager restaurantManager) {
        for (int i = 0; i < 6; i++) {
            TableDisplay new_td = new TableDisplay(new TwoSeater(OFFSET_X * i, OFFSET_Y));
            getChildren().add(new_td);
            new_td.setTranslateX(new_td.getTable().getX());
            new_td.setTranslateY(new_td.getTable().getY());

            new_td.addEventFilter(MouseEvent.MOUSE_CLICKED, onMouseClickedEH);
        }
        for (int i = 0; i < 6; i++) {
            TableDisplay new_td = new TableDisplay(new FourSeater(OFFSET_X * i, OFFSET_Y * 2));
            getChildren().add(new_td);
            new_td.setTranslateX(new_td.getTable().getX());
            new_td.setTranslateY(new_td.getTable().getY());
            new_td.addEventFilter(MouseEvent.MOUSE_CLICKED, onMouseClickedEH);
        }
        this.restaurantManager = restaurantManager;

        test();

    }

    private void test() {
        restaurantManager.addReservation(10, (TableDisplay) getChildren().get(0), new Customer( "", ""));
        restaurantManager.addReservation(10, (TableDisplay) getChildren().get(5), new Customer( "", ""));
    }

    /**
 * @param time
   iterate thru all tables,
    set colors based on if inside current time list.
        green for open, red for occupied
*/
    public void displayAtTime(int time) {
        displayTime = time;
        List<Reservation> currState = restaurantManager.reservations.get(displayTime);
        System.out.println("reservations at time; " + displayTime);

//        set all to green
        for(Node node : getChildren()) {
            TableDisplay tableDisplay = (TableDisplay) node;
            tableDisplay.free();
        }

        for(Node node : getChildren()) {
            TableDisplay tableDisplay = (TableDisplay) node;

            for (Reservation reservation : currState) {
                if (reservation.getTable() == tableDisplay.getTable()) {
                    System.out.println("reserved");
                        tableDisplay.reserve();
                }
            }
        }
    }


    private EventHandler<MouseEvent> onMouseClickedEH = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            Node node = (Node) event.getSource();
            System.out.println(node);

            if (node instanceof TableDisplay) {
                try {
                    new main.ReservationWindow(displayTime, restaurantManager, (TableDisplay) node);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("reservation window");
            } else {
                System.out.println("Clicker something else");
            }
        }
    };

    private EventHandler onMouseDrag = new EventHandler() {
        @Override
        public void handle(Event event) {

        }
    };


}
