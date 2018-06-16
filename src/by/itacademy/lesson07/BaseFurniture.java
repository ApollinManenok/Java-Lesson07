package by.itacademy.lesson07;

public abstract class BaseFurniture implements Furniture {
    private int area;
    private String name;

    public BaseFurniture(String name, int area) {
        this.name = name;
        this.area = area;
    }

    @Override
    public int getArea() {
        return area;
    }

    @Override
    public String toString() {
        return name + " (area " + this.getArea() + " m^2)";
    }
}
