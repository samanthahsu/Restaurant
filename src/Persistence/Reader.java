package Persistence;

import model.*;
import ui.RestaurantManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Reader {
    public static final String DELIMITER0 = ",";
    public static final String DELIMITER1 = ";";
    public static final String DELIMITER2 = "/";

    public Reader() { }

    public static RestaurantManager readRestaurantManager(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    private static RestaurantManager parseContent(List<String> fileContent) {
        RestaurantManager restaurantLayouts = new RestaurantManager();
        int time = 0;
        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString2(line);
            List<Reservation> curReservationList = parseReservationList(lineComponents);
            restaurantLayouts.setReservation(time,curReservationList);
            time += 1;
        }
        return restaurantLayouts;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER2
    private static ArrayList<String> splitString2(String line) {
        String[] splits = line.split(DELIMITER2);
        return new ArrayList<>(Arrays.asList(splits));
    }

    private static List<Reservation> parseReservationList(List<String> components) {
        List<Reservation> reservationList = new LinkedList<>();
        for (String line : components) {
            LinkedList<String> lineComponents = splitString1(line);
            for (String singleLine : lineComponents) {
                LinkedList<String> singleLineComponents = splitString0(singleLine);
                Table curTable;
                if (2 == Integer.parseInt(singleLineComponents.get(0))) {
                    curTable = new TwoSeater(Integer.parseInt(singleLineComponents.get(1)),
                            Integer.parseInt(singleLineComponents.get(2)));
                } else {
                    curTable = new FourSeater(Integer.parseInt(singleLineComponents.get(1)),
                            Integer.parseInt(singleLineComponents.get(2)));
                }
                Customer curCustomer = new Customer(singleLineComponents.get(3),singleLineComponents.get(4));
                Reservation curReservation = new Reservation(curTable, curCustomer);
                reservationList.add(curReservation);
            }
        }
        return null;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER1
    private static LinkedList<String> splitString0(String line) {
        String[] splits = line.split(DELIMITER0);
        return new LinkedList<>(Arrays.asList(splits));
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER1
    private static LinkedList<String> splitString1(String line) {
        String[] splits = line.split(DELIMITER1);
        return new LinkedList<>(Arrays.asList(splits));
    }
}
