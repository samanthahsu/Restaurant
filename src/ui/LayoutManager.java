package ui;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Pair;
import model.Customer;
import model.Table;

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
        for (int i = 0; i < 12; i++) {
            TableDisplay new_td = new TableDisplay(new Table());
            getChildren().add(new_td);
//            todo if statement to make second row of table
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
            List<Pair<Customer, Table>> currState = restaurantManager.reservations.get(time);
            for (Pair<Customer, Table> reservation : currState) {
                if (reservation.getValue() == tableDisplay.table) {
                    if (reservation.getValue() == null) {
                        tableDisplay.setColor(Color.GREEN);
                    } else {
                        tableDisplay.setColor(Color.RED);
                    }
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
