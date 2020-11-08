import java.util.ArrayList;

public class ZooController {
  public static void main(String[] args) {
    Mammal slasher = new Mammal("Dog", 100);
    Gorilla dk = new Gorilla();
    slasher.attack(dk);
    dk.thumpChest();

    Barrel b1 = new Barrel(10);
    dk.attack(b1);
    // ArrayList<Mammal> animals = new ArrayList<Mammal>();
    // animals.add(slasher);
    // animals.add(dk);

    // for (Mammal m : animals) {
    // System.out.println(m.getSpecies());
    // }
  }
}