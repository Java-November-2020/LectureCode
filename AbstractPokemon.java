import java.util.ArrayList;

public abstract class AbstractPokemon {
  protected ArrayList<Pokemon> myPokemon = new ArrayList<Pokemon>();

  public Pokemon createPokemon(String name, int health, String type) {
    System.out.println("Create Pokemon");
    Pokemon pk = new Pokemon(name, health, type);
    this.myPokemon.add(pk);
    return pk;
  }

  public abstract String pokemonInfo(Pokemon pokemon);
}