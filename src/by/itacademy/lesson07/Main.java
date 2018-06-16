package by.itacademy.lesson07;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            Building building = new Building("House 01", 70);
            building.addRoom("Room 01", 20, 2);
            building.addRoom("Room 02", 12, 1);
            building.addRoom("Room 03", 38, 3);
            building.add(1, new Lantern(1000));
            building.add(2, new Lantern(2000));
            building.add(2, new Lantern(700));
            building.add(3, new Lantern(1500));
            building.add(1, new Table("Round table", 7));
            building.add(1, new Chair("Bar stool", 2));
            building.add(1, new Shelve("Huge light shelve", 10));
            building.add(3, new Table("Coffee table", 5));
            building.add(2, new Shelve("Huge light shelve", 10));
            building.add(1, new Chair("Soft sofa", 5));
            building.add(1, new Shelve("Huge light shelve", 10));
            building.info();
        } catch (IlluminanceLimitException | SpaceLimitException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
