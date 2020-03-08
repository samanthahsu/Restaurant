package ui;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.FourSeater;
import model.Reservation;
import model.TwoSeater;

import java.util.List;

/**main pane that displays all the tables
 * observes the restaurant manager*/
public class LayoutManager extends Pane {

//    list of all the table displays
    final static int OFFSET_X = 100;
    final static int OFFSET_Y = 100;
    RestaurantManager restaurantManager;

//    populates pane with 12 tables at set layout places
    LayoutManager(RestaurantManager restaurantManager) {
        for (int i = 0; i < 6; i++) {
            TableDisplay new_td = new TableDisplay(new TwoSeater(OFFSET_X * i, 0));
            getChildren().add(new_td);
            new_td.setTranslateX(100 * i);
            new_td.setTranslateY(0);
        }
        for (int i = 0; i < 6; i++) {
            TableDisplay new_td = new TableDisplay(new FourSeater(OFFSET_X * i, OFFSET_Y));
            getChildren().add(new_td);
            new_td.setTranslateX(100 * i);
            new_td.setTranslateY(0);
        }
        addEventFilter( MouseEvent.MOUSE_CLICKED, onMouseClickedEH);
    }

/**
 * @param time
   iterate thru all tables,
    set colors based on if inside current time list.
        green for open, red for occupied
*/
    public void displayAtTime(int time) {
        for(Node node : getChildren()) {
            TableDisplay tableDisplay = (TableDisplay) node;
            List<Reservation> currState = restaurantManager.reservations.get(time);

            for (Reservation reservation : currState) {
                if (reservation.getTable() == tableDisplay.table) {
                    if (reservation.getCustomer() == null) {
                        tableDisplay.free();
                    } else {
                        tableDisplay.reserve();
                    }
                    break;
                }
            }
        }
    }

    private EventHandler<MouseEvent> onMouseClickedEH = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            Node node = (Node) event.getSource();
            if (node instanceof TableDisplay) {
                new ReservationWindow(node);
            }
        }
    };

}
