import java.util.Arrays;

public class Pizza {
  // Things Pizzas Have
  // Access Modifiers
  private String name;
  private char size;
  private String[] toppings;
  private int slices;
  static int pizzasMade;

  // Constructor
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

  // The point of having private properties and using public getters and setters
  // to access them is being able to add an extra layer of security to what the
  // user is allowed to do. Here we would deny a user from being able to set the
  // sauce to blank. Essentially making it a required field.
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

  // Things we can do with the pizza
  public int eatSlice(int slicesToEat) {
    this.slices -= slicesToEat;
    return this.slices;
  }

  // Example on how an object can interact with another object. By importing
  // "otherPizza" into here, we now have access to all the otherObject's
  // attributes and can modify them as we please
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