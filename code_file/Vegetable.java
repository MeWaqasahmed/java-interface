public abstract class Vegetable extends Plant implements Eatable {
  protected int weight;

  public void setWeight(int weight) {
      this.weight = weight;
  }

  public int getWeight() {
      return weight;
  }

  @Override
  public String chop() {
      return "Chop the vegetable, don't bite it.";
  }

  @Override
  public String eat() {
      return "You should eat vegetables cooked.";
  }
}
