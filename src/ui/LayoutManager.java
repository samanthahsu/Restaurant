package ui;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**main pane that displays all the tables
 * observes the restaurant manager*/
public class LayoutManager extends Pane {

//    list of all the table displays
    ObservableList<Node> tableDisplays;
    RestaurantManager restaurantManager;

//    populates pane with 12 tables at set layout places
    LayoutManager(RestaurantManager restaurantManager) {
        tableDisplays = getChildren();
    }


//    retrieves drawing information, iterate thru all tables, set colors based on if inside current time list.
//    green for open, red for occupied
    public void displayAtTime(int time) {
    }

}
