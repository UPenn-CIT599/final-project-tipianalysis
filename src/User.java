import java.util.HashMap;

/** Profile of User who is filling out TIPI Analysis */
public class User {

  // instance variables
  int age;
  private String name;
  private String sex;
  private HashMap<String, Double> TipiScore;

  // Constructor
  public User(String name, int age, String sex) {
    this.name = name;
    this.age = age;
    this.sex = sex;
  }

  // Getter for instance variables

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public String getSex() {
    return sex;
  }

  public HashMap<String, Double> getTipiScore() {
    return TipiScore;
  }

  /**
   * Setter for tipi Score
   *
   * @param tipiScore
   */
  public void setTipiScore(HashMap<String, Double> tipiScore) {
    this.TipiScore = tipiScore;
  }
}
