public class Animal {
  private String name;
  private int strength;
  private int health;

  // Constructor
  public Animal(String name, int strength, int health) {
    this.name = name;
    this.strength = strength;
    this.health = health;
  }

  // Method Overloading
  public Animal(String name, int strength) {
    this.name = name;
    this.strength = strength;
    this.health = 100;
  }

  public Animal() {

  }

  public String getName() {
    return this.name;
  }

  public int getStrength() {
    return this.strength;
  }

  public int getHealth() {
    return this.health;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  // Method that attacks another animal
  public void battle(Animal targetAnimal, String powerMove) {
    // define logic of how an animal attacks
    int damage;
    if (powerMove.equals("roar")) {
      damage = 3;
    } else if (powerMove.equals("swipe")) {
      damage = 5;
    } else {
      System.out.println("Move Not Recognized");
      return;
    }

    // multiple strength x damage
    int effectoveDamage = this.strength * damage;

    // Reduce the targetAnimal's healtyh accordingly
    targetAnimal.health -= effectoveDamage;

    // print to the console what happened using a formatted string
    System.out.printf("%s attacks %s for %d health points\n", this.name, targetAnimal.name, effectoveDamage);
  }

  // Attacks another animal, with default damage amount
  public void battle(Animal targetAnimal) {
    battle(targetAnimal, "roar");
  }
}