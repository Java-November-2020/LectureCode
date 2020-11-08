public class Gorilla extends Mammal {
  public Gorilla() {
    // Directly call the mammal constructor
    super("Gorilla", 500);
  }

  public void thumpChest() {
    System.out.printf("I am a %s thumping my chest", this.species);
  }

  @Override
  public void takeDamage(int damageAmount) {
    this.health -= (damageAmount / 2);
  }
}