public class Pokemon {
  private String name;
  private int health;
  private String type;
  static int count;

  public Pokemon(String name, int health, String type) {
    this.name = name;
    this.health = health;
    this.type = type;
    count++;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return this.name;
  }

  public int getHealth() {
    return this.health;
  }

  public String getType() {
    return this.type;
  }

  public void attackPokemon(Pokemon otherPokemon) {
    otherPokemon.setHealth(otherPokemon.getHealth() - 10);
    System.out.println(otherPokemon.getHealth() + " is not this pokemons health");
  }
}