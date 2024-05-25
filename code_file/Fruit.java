public abstract class Fruit extends Plant implements Eatable {
  protected int price;

  public void setPrice(int price) {
      this.price = price;
  }

  public int getPrice() {
      return price;
  }

  @Override
  public String chop() {
      return "Don't chop the fruit, bite it.";
  }

  @Override
  public String eat() {
      return "You should eat fruits raw.";
  }
}
