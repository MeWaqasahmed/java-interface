import java.util.List;

public abstract class Plant {
    protected String color;
    protected List<DayHr> wateringSchedule;

    public Plant() {
        this.wateringSchedule = DayHr.getDefaultWateringPlan();
    }

    public List<DayHr> getWatered() {
        return wateringSchedule;
    }

    public void setWatered(String day, int hour, int duration) {
        this.wateringSchedule.add(new DayHr(day, hour, duration));
    }

    public abstract void setColor(String color);

    public abstract String getColor();
}
