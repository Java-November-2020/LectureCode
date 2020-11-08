public class Mammal implements Attackable {
  protected String species;
  protected int health;

  public String getSpecies() {
    return this.species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public int getHealth() {
    return this.health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public Mammal(String species, int health) {
    this.species = species;
    this.health = health;
  }

  public void takeDamage(int damageAmount) {
    this.health -= damageAmount;
  }

  public void attack(Attackable target) {
    target.setHealth(health -= 10);
    System.out.printf("% was targeted and it's health was decreased by 10", target.health);
  }
}