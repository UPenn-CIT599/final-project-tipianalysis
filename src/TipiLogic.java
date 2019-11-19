import java.util.*;

/**
 * The class which performs all of the logic behind the Tipi analysis.
 * This includes producing the user's scores for the "Big 5 Personality Traits"
 * and showing the comparison of those scores to the user's peer group.
 * @author michaelnarcisi
 */
public class TipiLogic {
	private User currentUser;
	private NormDataReader resultsComparison;
	private LinkedHashMap<String, Integer> userResponses;
	private final int NUMBER_OF_TRAITS;  // Models the 5 big traits of Tipi
	private Trait[] bigFivePersonalityScoresAndMetrics;
	
	
	
	
	// Make getters and java doc comments for all instance variables
	// Eliminate logic check function and unit test??????

	
	/**
	 * The constructor for the TipiLogic class which takes the user's answers
	 * to the Tipi questionnaire and calculates their scores for the "Big
	 * Five Personality Traits".
	 * @param currentUser - The class outlining the user currently using 
	 * the program.
	 * @param userResponses - The HashMap containing the questions and user
	 * answers modeling each part of the "Ten Item Personality Inventory"
	 */
	public TipiLogic(User currentUser, LinkedHashMap<String, Integer> responses) {
		this.currentUser = currentUser;
		this.userResponses = new LinkedHashMap<String, Integer>(responses);
		resultsComparison = new NormDataReader(currentUser.getSex());
		NUMBER_OF_TRAITS = 5;
		bigFivePersonalityScoresAndMetrics = new Trait[NUMBER_OF_TRAITS];
	}

	/**
	 * The method which runs the entire Tipi Logic and returns all data
	 * that will be output to the user.
	 */
	public void runLogic() {
		
		
		
		
		
		
	}
	
	/**
	 * A helper method which takes the answers from the reverse-scored items 
	 * in the Tipi questionnaire and recodes their scores to produce the 
	 * correct outcome.  For example, using the 1-7 scale, a reverse-scored 
	 * item scored as a 6 would become a 2, etc.
	 */
	private void recodeReverseScoredItems() {
		// Reverse-scored items: (Should be: 2, 4, 6, 8, 10.)  
		int reverseItemMarker = 1;
		for (String scaleTrait : userResponses.keySet()) {
			// Ensure logic only processes the even portions of the map
			if (reverseItemMarker % 2 == 0) {
				userResponses.put(scaleTrait, 8 - userResponses.get(scaleTrait));
			}
			reverseItemMarker++;
		}
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
	 * A getter method for the object representing the current user of
	 * the program.
	 * @return - the User object.
	 */
	public User getCurrentUser() {
		return currentUser;
	}

	/**
	 * A getter method for the map representing the current user's input
	 * responses to the questionnaire questions.
	 * @return - The map representing the user's answers.
	 */
	public LinkedHashMap<String, Integer> getUserResponses() {
		return userResponses;
	}

	/**
	 * A getter method for the object which will read and process the
	 * researched sample of Tipi participants.
	 * @return - The data reader object.
	 */
	public NormDataReader getResultsComparison() {
		return resultsComparison;
	}

//	/**
//	 * A getter method for the HashMap storing the final personality scores
//	 * of each of the "Big Five Personality Traits".
//	 * @return - The HashMap storing trait scores.
//	 */
//	public HashMap<String, Double> getBigFivePersonalityScores() {
//		return bigFivePersonalityScores;
//	}

	
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> inputResponses = new LinkedHashMap<>();
		inputResponses.put("Extraverted", 5);
		inputResponses.put("Critical", 4);
		inputResponses.put("Dependable", 6);
		inputResponses.put("Anxious", 2);
		inputResponses.put("Open", 5);
		inputResponses.put("Reserved", 3);
		inputResponses.put("Sympothetic", 7);
		inputResponses.put("Disorganized", 5);
		inputResponses.put("Calm", 2);
		inputResponses.put("Conventional", 7);
		
		TipiLogic logic = new TipiLogic(new User("Sam", 30, "Male"), inputResponses);
		
		System.out.println(logic.getUserResponses());
		logic.recodeReverseScoredItems();
		System.out.println(logic.getUserResponses());
		
		
	}
	
	
}