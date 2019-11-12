import java.util.HashMap;

/**
 * The class which performs all of the logic behind the Tipi analysis.
 * This includes producing the user's scores for the "Big 5 Personality Traits"
 * and showing the comparison of those scores to the user's peer group.
 * @author michaelnarcisi
 */
public class TipiLogic {
	private NormDataReader resultsComparison;
	HashMap<String, Integer> userResponses;
	HashMap<String, Double> bigFivePersonalityScores;
	HashMap<HashMap<String, Double>, Trait[]> dataToOuput;
	
	/**
	 * The constructor for the TipiLogic class which takes the user's answers
	 * to the Tipi questionnaire and calculates their scores for the "Big
	 * Five Personality Traits".
	 * @param userResponses - The HashMap containing the questions and user
	 * answers modeling each part of the "Ten Item Personality Inventory"
	 */
	public TipiLogic(HashMap<String, Integer> userResponses) {
		
		// Finish Constructor
		
		this.userResponses = ;
		
		/* Integrate User class into constructor call for 
		NormDataReader */
		resultsComparison = new NormDataReader();
		
		bigFivePersonalityScores = new HashMap<String, Double>();
		dataToOuput = new HashMap<HashMap<String, Double>, Trait[]>();
	}

	/**
	 * The method which runs the entire Tipi Logic and returns all data
	 * that will be output to the user.
	 * @return - A HashMap with a key as another HashMap containing the "Big
	 * Five Personality Traits" and their respective scores, and the value
	 * as being an object array of Traits and their respective metrics.
	 */
	public HashMap<HashMap<String, Double>, Trait[]> runLogic() {
		
		
		
		
		// Finish
		
		
		
		
	}
	
	/**
	 * A method which takes the answers from the reverse-scored items in the
	 * Tipi questionnaire and recodes their scores to produce the correct
	 * outcome.  For example, using the 1-7 scale, a reverse-scored item
	 * scored as a 6 would become a 2, etc.
	 */
	public void recodeReverseScoredItems() {
		
		
		
		// Example now in LogicCheck - will flesh out so method is more DRY
		
		
		
	}
	
	/**
	 * A method which takes the two scores associated with a specific
	 * "Big Five" trait and finds their average to compute a total score
	 * for that trait.
	 * @param traitScoreOne - The first of two recorded scores
	 * @param traitScoreTwo - The second of two recorded scores
	 * @return - The final score for the trait in question
	 */
	public double computeFinalTraitScore(int traitScoreOne, int traitScoreTwo) {
		
		
		
		
		// Finish
		
		
		
		
	}

	/**
	 * A getter method for the object which will read and process the
	 * researched sample of Tipi participants.
	 * @return - The data reader object.
	 */
	public NormDataReader getResultsComparison() {
		return resultsComparison;
	}

	/**
	 * A getter method for the HashMap with user responses to the questions
	 * of the Tipi questionnaire.
	 * @return - The HashMap of user responses.
	 */
	public HashMap<String, Integer> getUserResponses() {
		return userResponses;
	}

	/**
	 * A getter method for the HashMap storing the final personality scores
	 * of each of the "Big Five Personality Traits".
	 * @return - The HashMap storing trait scores.
	 */
	public HashMap<String, Double> getBigFivePersonalityScores() {
		return bigFivePersonalityScores;
	}
}