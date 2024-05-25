import java.util.ArrayList;
import java.util.List;

public class DayHr {
    private String day;
    private int hour;
    private int duration;

    public DayHr(String day, int hour, int duration) {
        this.day = day;
        this.hour = hour;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return day + ", " + hour + ":00, " + duration + " minutes";
    }

    public static List<DayHr> getDefaultWateringPlan() {
        List<DayHr> plan = new ArrayList<>();
        plan.add(new DayHr("Monday", 10, 60));
        return plan;
    }
}
