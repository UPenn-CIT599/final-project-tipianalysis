/** Profile of User who is filling out TIPI Analysis */
public class User {

    // instance variables
  int age;
  private String name;
  private String sex;

  // Constructor
  public User(String name, int age, String sex) {
    this.name = name;
    this.age = age;
    this.sex = sex;
  }

  //Getter for instance variables

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

}
