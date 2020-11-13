import java.util.ArrayList;

public class Pokedex extends AbstractPokemon {

  public String pokemonInfo(Pokemon pokemon) {
    return String.format("This is a %s pokemon with %d health and %s type", pokemon.getName(), pokemon.getHealth(),
        pokemon.getType());
  }

  public void listPokemon() {
    for (int i = 0; i < myPokemon.size(); i++) {
      System.out.println(myPokemon.get(i).getName());
    }
  }
}