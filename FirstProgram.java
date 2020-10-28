public class FirstProgram {
  // Entry Point Method
  public static void main(String[] args) {
    // Primitive
    byte myByte = 100; // Stores whole numbers from -128 to 127
    short myShort = 1000; // Stores whole numbers from -32,768 to 32,767
    int myInt = 1000000; // Stores whole numbers from -2,147,483,648 to 2,147,483,647
    long myLong = 1000000000; // Stores whole numbers from -9,223,372,036,854,775,808 to
                              // 9,223,372,036,854,775,807
    float myFloat = 3.14f; // Stores fractional numbers, sufficient for storing 6 to 7 decimal digits
    double myDouble = 3.147433456d; // Stores fractional numbers, succifient for storing 15 decimal digits.

    boolean myBool = true; // Stores true or false values
    char myChar = 'c'; // stores a single character/letter or ASCII values

    // Wrapper Class
    // the full word spelled out and capitalized;

    Integer myInteger = 1000000;
    Character myCharacter = 'c';

    String myString = "Java November 2020";

    System.out.println(myString.length());

    String bootcamp = "Java";
    String bootCamp = "November";
    String bootCAMP = "2020";

    System.out.println(bootcamp + bootCamp + bootCAMP);

    // Operators and Conditionals
    int myInt2 = 200;
    int myInt3 = 200;
    System.out.println(myInt2 == myInt3);
    String matt = "Matt";
    String aaron = "Matt";

    int isOdd = 5;

    if (isOdd % 2 != 0) {
      System.out.println("Number is Odd");
    } else {
      System.out.println("Number is not odd");
    }

    // Loops
    int counter = 0;
    while (counter < 4) {
      System.out.println(counter);
      counter++;
    }

    for (int i = 0; i < 4; i++) {
      System.out.println(i);
    }

    sayHello("Aaron");
  }

  public static void sayHello(String name) {
    System.out.println("Hello " + name);
  }

}