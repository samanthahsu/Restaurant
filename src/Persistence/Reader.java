package Persistence;

import model.Reservation;
import model.Table;
import ui.RestaurantManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Reader {
    public static final String DELIMITER = ",";

    public Reader() { }

    public static List<RestaurantManager> readRestaurantManager(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    private static List<RestaurantManager> parseContent(List<String> fileContent) {
        List<RestaurantManager> restaurantLayouts = new ArrayList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            restaurantLayouts.add(parseRestaurantManager(lineComponents));
        }

        return restaurantLayouts;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has size 2 where element 0 represents the
    // reservation map
    // EFFECTS: returns a RestaurantManager constructed from components
    private static RestaurantManager parseRestaurantManager(List<String> components) {
//        RestaurantManager reservations = new HashMap<>()
//        for (int i = 0; i < 24; i++) {
//            reservations.put(i, new LinkedList<Reservation>());
//        return ;
        return null;
    }
}
