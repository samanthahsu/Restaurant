//package Persistence;
//
//import model.Reservation;
//import model.Table;
//import ui.RestaurantManager;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.*;
//
//public class Reader {
//    public static final String DELIMITER = ",";
//
//    // EFFECTS: constructs a reader that will read textbook data from file
//    public Reader() { }
//
//    public static List<RestaurantManager> readRestaurantManager(File file) throws IOException {
//        List<String> fileContent = readFile(file);
//        return parseContent(fileContent);
//    }
//
//    // EFFECTS: returns content of file as a list of strings, each string
//    // containing the content of one row of the file
//    private static List<String> readFile(File file) throws IOException {
//        return Files.readAllLines(file.toPath());
//    }
//
//    // EFFECTS: returns a list of textbooks parsed from list of strings
//    // where each string contains data for one textbook
//    private static List<RestaurantManager> parseContent(List<String> fileContent) {
//        List<RestaurantManager> restaurantLayouts = new ArrayList<>();
//
//        for (String line : fileContent) {
//            ArrayList<String> lineComponents = splitString(line);
//            restaurantLayouts.add(parseRestaurantManager(lineComponents));
//        }
//
//        return restaurantLayouts;
//    }
//
//    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
//    private static ArrayList<String> splitString(String line) {
//        String[] splits = line.split(DELIMITER);
//        return new ArrayList<>(Arrays.asList(splits));
//    }
//
//    // REQUIRES: components has size 1 where element 0 represents the
//    // reservation map
//    // EFFECTS: returns a RestaurantManager constructed from components
//    private static RestaurantManager parseRestaurantManager(List<String> components) {
//        HashMap<Integer, List<Reservation>> reservations = Map.parseMap(components.get(1));
//        return new RestaurantManager(allTables, reservations);
//    }
//}
