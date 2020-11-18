public class Human {
  private String name;
  private String gender;
  private int weight;

  public Human(String name, String gender, int weight) {
    this.name = name;
    this.gender = gender;
    this.weight = weight;
  }

  public void getSleep() {
    System.out.println("zzzz");
  }

  public void eat(){
    System.out.println("Getting something to eat");
  }
}