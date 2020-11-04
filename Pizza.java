import java.util.Arrays;

public class Pizza {
  // Things Pizzas Have
  private String name;
  private char size;
  private String[] toppings;
  private int slices;
  static int pizzasMade;

  public Pizza(String name, char size, String[] toppings, int slices) {
    this.name = name;
    this.size = size;
    this.toppings = toppings;
    this.slices = slices;
    pizzasMade++;
  }
  // Methods

  // Setters
  public void setToppings(String[] toppings) {
    this.toppings = toppings;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSlices(int slices) {
    if (slices < 3) {
      System.err.println("We don't do small pizzas");
      return;
    }
    this.slices = slices;
  }

  public void setSize(char size) {
    this.size = size;
  }

  // Getters
  public String[] getToppings() {
    return this.toppings;
  }

  public char getSize() {
    return this.size;
  }

  public String getName() {
    return this.name;
  }

  public int getSlices() {
    return this.slices;
  }

  // Things You Can Do
  // Eat Method
  // Advertise

  public int eatSlice(int slicesToEat) {
    this.slices -= slicesToEat;
    return this.slices;
  }

  public void pizzaFight(Pizza otherPizza) {

    int beginningSlices = otherPizza.getSlices();
    int totalSlices = beginningSlices - 2;
    otherPizza.setSlices(totalSlices);

    System.out.println(this.name + " pizza just took 2 slices from " + otherPizza.name);

  }

  public void displayPizza() {
    System.out.println("This is " + this.name + " that is a size " + this.size + " With: "
        + Arrays.toString(this.toppings) + " toppings");
  }

  public static void advertise() {
    System.out.println("Hey you, come check out these pizzas at these prices!");
  }

}