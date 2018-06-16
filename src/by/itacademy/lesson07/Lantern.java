package by.itacademy.lesson07;

public class Lantern {
    private int light;

    public Lantern(int light) {
        this.light = light;
    }

    public int getLight() {
        return light;
    }

    @Override
    public String toString() {
        return light + " lum";
    }
}
