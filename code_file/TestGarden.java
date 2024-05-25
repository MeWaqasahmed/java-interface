public class TestGarden {
  public static void main(String[] args) {
      Citrus citrus = new Citrus("Orange");
      citrus.setColor("Orange");
      citrus.setPrice(100);

      Apple apple = new Apple("Red Apple");
      apple.setColor("Red");
      apple.setPrice(150);

      Tomato tomato = new Tomato("Cherry Tomato");
      tomato.setColor("Red");
      tomato.setWeight(200);

      Flower flower = new Flower("Rose", "Red", 2);

      System.out.println("Citrus: " + citrus.chop() + " - " + citrus.eat() + " - Color: " + citrus.getColor() + " - Price: " + citrus.getPrice());
      System.out.println("Apple: " + apple.chop() + " - " + apple.eat() + " - Color: " + apple.getColor() + " - Price: " + apple.getPrice());
      System.out.println("Tomato: " + tomato.chop() + " - " + tomato.eat() + " - Color: " + tomato.getColor() + " - Weight: " + tomato.getWeight());
      System.out.println("Flower: Name: " + flower.getName() + " - Color: " + flower.getColor() + " - Intensity: " + flower.getIntensity());

      System.out.println("Tomato Products: " + tomato.products());
      System.out.println("Tomato Watering Schedule: " + tomato.getWatered());

      System.out.println("Flower Watering Schedule: " + flower.getWatered());
  }
}
