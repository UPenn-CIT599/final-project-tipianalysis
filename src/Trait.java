/**
 * The class which models a specific personality trait on the basis of
 * the Tipi personality score and the research parameters used when
 * attaining that score.
 * @author michaelnarcisi
 */
public class Trait {
	private String name;
	private double userScore;
	private double mean;
	private double standardDeviation;
	private int sampleSize;
	private String comparisonToPeers;
	
	/**
	 * The constructor for the Trait class.  Stores all pertinent information
	 * regarding a trait's TIPI score and the research parameters used to 
	 * obtain that score.
	 * @param name - The name of the Trait.
	 * @param mean - The average researched score of the trait.
	 * @param standardDeviation - The standard deviation associated with
	 * the Trait's score.
	 * @param sampleSize - The sample size of the researched sample.
	 */
	public Trait(String name, double mean, double standardDeviation, int sampleSize) {
		
		// Finish Constructor
		
		this.name = name;
		this.mean = mean;
		this.standardDeviation = standardDeviation;
		this.sampleSize = sampleSize;
		comparisonToPeers = "";
	}

	/**
	 * A getter method for the name of the Trait.
	 * @return - The name of the Trait.
	 */
	public String getName() {
		return name;
	}

	/**
	 * A getter method for the current User's score.
	 * @return - The value of the current User's score.
	 */
	public double getUserScore() {
		return userScore;
	}
	
	/**
	 * A getter method for the mean score of the Trait.
	 * @return - The mean score of the Trait.
	 */
	public double getMean() {
		return mean;
	}

	/**
	 * A getter method for the standard deviation of the Trait's score.
	 * @return - The standard deviation of the Trait's score.
	 */
	public double getStandardDeviation() {
		return standardDeviation;
	}

	/**
	 * A getter method for the sample size used to form the Trait's score.
	 * @return - The sample size.
	 */
	public int getSampleSize() {
		return sampleSize;
	}

	/**
	 * A getter method for the string used to describe if the user's score
	 * is above, below, or right at average for their peer group.
	 * @return - The descriptive String.
	 */
	public String getComparisonToPeers() {
		return comparisonToPeers;
	}

	/**
	 * A setter method for the name of the Trait.
	 * @param name - The name of the trait
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * A setter method for the current User's score.
	 * @param name - The value of the current user's score
	 */
	public void setUserScore(double userScore) {
		this.userScore = userScore;
	}

	/**
	 * A setter method for the mean score of the Trait.
	 * @param name - The mean score of the trait
	 */
	public void setMean(double mean) {
		this.mean = mean;
	}

	/**
	 * A setter method for the standard deviation of the Trait's score.
	 * @param name - The standard deviation of the Trait's score
	 */
	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}

	/**
	 * A setter method for the sample size used to form the Trait's score.
	 * @param name - The sample size used to form the Trait's score
	 */
	public void setSampleSize(int sampleSize) {
		this.sampleSize = sampleSize;
	}

	/**
	 * A setter method for the string used to describe if the user's score
	 * is above, below, or right at average for their peer group.
	 * @return - The descriptive String.
	 */
	public void setComparisonToPeers(String comparisonToPeers) {
		this.comparisonToPeers = comparisonToPeers;
	}
}