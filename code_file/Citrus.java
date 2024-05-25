public class Citrus extends Fruit {
  private String cname;

  public Citrus(String cname) {
      this.cname = cname;
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
