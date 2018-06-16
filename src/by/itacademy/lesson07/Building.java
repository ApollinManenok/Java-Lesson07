package by.itacademy.lesson07;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Building {
    private static final Logger LOGGER = Logger.getLogger(Building.class.getName());
    private String name;
    private int area;
    private int filledArea = 0;
    private List<Room> rooms = new ArrayList<>();

    public Building(String name, int area) throws SpaceLimitException {
        this.name = name;
        if (area <= 0)
            throw new SpaceLimitException("Area is too little: " + area);
        this.area = area;
    }

    public void addRoom(String name, int area, int windows) throws IlluminanceLimitException, SpaceLimitException {
        if (this.filledArea + area > this.area)
            throw new SpaceLimitException("Requested space exceed building area: " + this.area + " < " + (this.filledArea + area));
        rooms.add(new Room(name, area, windows));
        filledArea += area;
    }

    public void add(int index, Furniture furniture) {
        try {
            rooms.get(index - 1).addFurniture(furniture);
        } catch (SpaceLimitException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
    }

    public void add(int index, Lantern lantern) {
        try {
            rooms.get(index - 1).addLantern(lantern);
        } catch (IlluminanceLimitException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
    }

    public void info() {
        System.out.println("Building: " + name + " Area: " + area);
        for (Room room : rooms) {
            System.out.println("\n" + room);
        }
    }
}
