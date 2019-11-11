import java.util.HashMap;

/**
 * User class that holds the information/results of a given user 
 * who is taking the survey/using the program.
 * @author andrew.mcmanus
 *
 */
public class User {

  //User age instance variable
  private int age;
  //User name instance variable
  private String name;
  //User sex instance variable
  private String sex;
  //User survey scores instance variable.
  private HashMap<String, Double> TipiScore;

  /**
   * Constructor for the User class to get the information we need
   * on a user to populate the results tab.
   * @param name String value for the user name
   * @param age int Value for the user age
   * @param sex int value for the user Sex
   */
  public User(String name, int age, String sex) {
    this.name = name;
    this.age = age;
    this.sex = sex;
  }


  /**
   * Returnes the value in the "age" variable
   * @return Int value for age
   */
  public int getAge() {
    return age;
  }

  /**
   * Returnes the value in the "name" variable
   * @return String value for name
   */
  public String getName() {
    return name;
  }

  /**
   * Returnes the value in the "sex" variable
   * @return String value for sex
   */
  public String getSex() {
    return sex;
  }

  /**
   * Returns the scores from the TIPI survey in the form of a hashmap
   * @return Hashmap with String keys and double values.
   */
  public HashMap<String, Double> getTipiScore() {
    return TipiScore;
  }

  /**
   * Setter for tipi Score. Allows us to set the score once the survey is filled 
   * in.
   * @param tipiScore A hashmap with String key and Double value.
   */
  public void setTipiScore(HashMap<String, Double> tipiScore) {
    this.TipiScore = tipiScore;
  }
  
}
