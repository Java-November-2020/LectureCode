import sun.awt.image.ImageCache.PixelsKey;

public class PokeTest {
  public static void main(String[] args) {
    Pokedex pokedex = new Pokedex();
    Pokemon pikachu = pokedex.createPokemon("Pikachu", 100, "Electric");
    Pokemon giraffa = pokedex.createPokemon("Giraffa", 100, "earth");
    System.out.println(Pokemon.count);
    System.out.println(pokedex.pokemonInfo(pikachu));
  }
}