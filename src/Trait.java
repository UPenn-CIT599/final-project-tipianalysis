/**
 * The class which models a specific personality trait on the basis of
 * the Tipi personality score and the research parameters used when
 * attaining that score.
 * @author michaelnarcisi
 */
public class Trait {
	private String name;
	private double mean;
	private double standardDeviation;
	private int sampleSize;
	private String categoryComparedToPeers;
	
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
		categoryComparedToPeers = "";
	}

	/**
	 * A getter method for the name of the Trait.
	 * @return - The name of the Trait.
	 */
	public String getName() {
		return name;
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
	 * @return
	 */
	public String getCategoryComparedToPeers() {
		return categoryComparedToPeers;
	}
}