package code_file;
public class Flower extends Plant {
    private String name;
    private int intensity; // 1: very strong, 2: strong, 3: middle, 4: weak, 5: very weak

    public Flower(String name, String color, int intensity) {
        this.name = name;
        this.color = color;
        this.intensity = intensity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }
}
