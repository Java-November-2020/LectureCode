import java.util.Arrays;

public class PizzaController {
  // Entry Point Method
  public static void main(String[] args) {
    String[] pizza1Toppings = new String[] { "cheese", "pepperoni", "pineapples", "Jalapeno", "black olives" };
    String[] pizza2Toppings = new String[] { "Mushrooms", "bell peppers", "the kitchen sink" };
    Pizza theDeveroni = new Pizza("The Deveroni", 'L', pizza1Toppings, 16);
    Pizza theBlakeroni = new Pizza("The Blakeroni", 'L', pizza2Toppings, 16);

    theDeveroni.setSlices(9);
    System.out.println(theDeveroni.getSlices());

    theDeveroni.displayPizza();
    theBlakeroni.displayPizza();

    System.out.println(theBlakeroni.eatSlice(6));
    Pizza.advertise();
    System.out.println(Pizza.pizzasMade);

    theDeveroni.pizzaFight(theBlakeroni);
    System.out.println(theBlakeroni.getSlices());
  }
}