public class Apple extends Fruit {
  private String aname;

  public Apple(String aname) {
      this.aname = aname;
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
