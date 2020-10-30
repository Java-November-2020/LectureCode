import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class Day2 {
  public static void main(String[] args) {
    // Array
    String[] people = { "Aaron", "Christopher", "Jackson" };
    int[] numbers = new int[10];
    Object[] myObjs = { false, "Aaron", 19 };

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = i + 1;
    }
    // ForEach Loop
    for (int num : numbers) {
      System.out.println(num);
    }
    System.out.println(Arrays.toString(numbers));

    // ArrayList
    ArrayList<String> stringList = new ArrayList<String>();
    stringList.add("Aaron");
    stringList.add("Christopher");
    stringList.add("Jackson");

    System.out.println(stringList.contains("Matt"));

    // for (String name : stringList) {
    // System.out.println(name);
    // }

    // for (int numb = 0; numb < stringList.size(); numb++) {
    // System.out.println(stringList.get(numb));
    // }

    // Hash Maps
    HashMap<String, String> ourHobbies = new HashMap<String, String>();
    ourHobbies.put("Laura", "Sewing/Quilting");
    ourHobbies.put("Victoria", "Anime");
    ourHobbies.put("Aaron", "Camping");
    ourHobbies.put("Jessica", "Hiking");
    ourHobbies.put("Thomas", "Movies");
    ourHobbies.put("Tony", "Hockey");
    ourHobbies.put("Jackson", "Watching Movies");
    ourHobbies.put("Christopher", "Gaming");
    ourHobbies.put("Matthew", "Photography");
    ourHobbies.put("Platt", "Webfun");

    for (HashMap.Entry<String, String> entry : ourHobbies.entrySet()) {
      System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    }

    System.out.println(MaxArrayValue(numbers));

    System.out.println("I'm still standing");
  }

  public static void sayHello() {
    System.out.println("Hello");

  }

  public static int MaxArrayValue(int[] arrayOfNumbers) {
    // Variable to compare each value to first element of array
    // Variable to hold the current max
    // Starting Point to loop through array
    // If currentMax is bigger than the array of numbers, reassign
    // return currentMax
    int currentMax = arrayOfNumbers[0];

    for (int i = 0; i <= arrayOfNumbers.length; i++)
      try {
        if (currentMax < arrayOfNumbers[i]) {
          currentMax = arrayOfNumbers[i];
        }
      } catch (Exception e) {
        System.out.println(e);
      }
    return currentMax;
  }
}