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
	private Trait[] userScoresAndMetrics;
	
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
	
	public void setName(String uname) {
		this.name = uname;
	}
	
	public void setAge(int uage) {
		this.age = uage;
	}
	
	public void setSex(String usex) {
		this.sex = usex;
	}

	/**
	 * Returns the calculated scores from the TIPI survey and the comparison
	 * metrics from others in the user's peer group who have taken a TIPI
	 * analysis.
	 * @return - A Trait array containing the user's score as well as their
	 * associated comparison metrics.
	 */
	public Trait[] getUserScoresAndMetrics() {
		return userScoresAndMetrics;
	}

	public void setUserScoresAndMetrics(Trait[] userScoresAndMetrics) {
		this.userScoresAndMetrics = userScoresAndMetrics;
	}
}
