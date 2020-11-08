public class Barrel implements Attackable {
  private String name;
  private int health;

  public Barrel(int health) {
    this.name = "Barrel";
    this.health = health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getHealth() {
    return this.health;
  }

  public void takeDamage(int damageAmount) {
    this.health -= damageAmount;
  }
}