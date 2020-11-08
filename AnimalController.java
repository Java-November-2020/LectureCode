public class AnimalController {
  public static void main(String[] args) {
    Animal lion = new Animal("Simba", 10, 100);
    Animal tiger = new Animal("Tony", 10, 100);
    Animal rhino = new Animal("Gloria", 12, 100);

    // System.out.println(tiger.getHealth());
    // lion.battle(tiger, "roar");
    // System.out.println(tiger.getHealth());
    // System.out.println(lion.getHealth());
    // tiger.battle(lion, "swipe");
    // System.out.println(lion.getHealth());
    // rhino.battle(lion, "stomp");

    Animal dolphin = new Animal("Ecco", 4);
    dolphin.battle(lion);
  }
}