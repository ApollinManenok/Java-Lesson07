package by.itacademy.lesson07;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private static int MAX_ILLUMINATION = 4000;
    private static int MIN_ILLUMINATION = 300;
    private static int WINDOW_ILLUMINATION = 700;
    private String name;
    private int area;
    private int windows;
    private int filledArea = 0;
    private int illumination;
    private List<Furniture> furnishings = new ArrayList<>();
    private ArrayList<Lantern> lanterns = new ArrayList<>();

    public Room(String name, int area, int windows) throws IlluminanceLimitException, SpaceLimitException {
        this.name = name;
        if (area <= 0)
            throw new SpaceLimitException("Area is too little: " + area);
        this.area = area;
        illumination = windows * WINDOW_ILLUMINATION;
        lightLimit(illumination);
        this.windows = windows;
    }

    public void addLantern(Lantern lantern) throws IlluminanceLimitException {
        lightLimit(illumination + lantern.getLight());
        lanterns.add(lantern);
        illumination += lantern.getLight();
    }

    public void addFurniture(Furniture furniture) throws SpaceLimitException {
        if (filledArea + furniture.getArea() > area * 70 / 100)
            throw new SpaceLimitException("Requested space exceed 70% limit: " + this.area + " : " + (filledArea + furniture.getArea()));
        furnishings.add(furniture);
        filledArea += furniture.getArea();
    }

    private void lightLimit(int illumination) throws IlluminanceLimitException {
        if (illumination < MIN_ILLUMINATION || illumination > MAX_ILLUMINATION)
            throw new IlluminanceLimitException("Total illumination: " + illumination);
    }

    @Override
    public String toString() {
        return name + "\nArea: " + area + " (filled " + filledArea + ", free " + (area - filledArea) +
                " or " + ((area - filledArea) / (area / 100.0)) + "%)" +
                "\nIllumination " + illumination +
                " (" + windows + " windows " + WINDOW_ILLUMINATION + " lum, lanterns " + lanterns + ")" +
                "\nFurnishings: " + furnishings;
    }
}
