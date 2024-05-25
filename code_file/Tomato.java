import java.util.ArrayList;
import java.util.List;

public class Tomato extends Vegetable {
    private String kind;

    public Tomato(String kind) {
        this.kind = kind;
        this.wateringSchedule = new ArrayList<>();
        this.wateringSchedule.add(new DayHr("Monday", 9, 30));
        this.wateringSchedule.add(new DayHr("Wednesday", 9, 30));
        this.wateringSchedule.add(new DayHr("Friday", 9, 30));
    }

    @Override
    public void setWatered(String day, int hour, int duration) {
        this.wateringSchedule.add(new DayHr(day, hour, duration));
    }

    @Override
    public List<DayHr> getWatered() {
        return this.wateringSchedule;
    }

    public List<String> products() {
        List<String> products = new ArrayList<>();
        products.add("Tomato Soup");
        products.add("Tomato Paste");
        products.add("Ketchup");
        return products;
    }
}
