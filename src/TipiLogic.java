import java.util.*;

/**
 * The class which performs all of the logic behind the Tipi analysis.
 * This includes producing the user's scores for the "Big 5 Personality Traits"
 * and showing the comparison of those scores to the user's peer group.
 * @author michaelnarcisi
 */
public class TipiLogic {
	private User currentUser;
	private NormDataReader comparisonData;
	private LinkedHashMap<String, Integer> userResponses;
	private final int NUMBER_OF_TRAITS;
	private Trait[] bigFivePersonalityScoresAndMetrics;
	
	/**
	 * The constructor for the TipiLogic class which takes the user's answers
	 * to the Tipi questionnaire and calculates their scores for the "Big
	 * Five Personality Traits".
	 * @param currentUser - The class outlining the user currently using 
	 * the program.
	 * @param responses - The Map containing the questions and user
	 * answers modeling each part of the "Ten Item Personality Inventory"
	 */
	public TipiLogic(User currentUser, LinkedHashMap<String, Integer> responses) {
		this.currentUser = currentUser;
		this.userResponses = new LinkedHashMap<String, Integer>(responses);
		comparisonData = new NormDataReader(currentUser.getSex(), currentUser.getAge());
		NUMBER_OF_TRAITS = 5;  // Models the 5 big traits of Tipi
		bigFivePersonalityScoresAndMetrics = new Trait[NUMBER_OF_TRAITS];
	}

	/**
	 * The method which runs the entire Tipi Logic and returns all data
	 * that will be output to the user.
	 * @return - The final Trait[] containing all relevant information for each Trait
	 */
	public Trait[] runLogic() {
		// Create arrays to model the trait names
		String[] traitNames = {"Extraversion", "Agreeableness", "Conscientiousness", "Emotional Stability", "Openness to Experiences"};
		Object[] questionnaireTraits = userResponses.keySet().toArray();
		
		// Recode the necessary reverse-scored items from user responses
		recodeReverseScoredItems();
		
		// Create each Trait and add all relevant information to each
		for(int i = 0; i < NUMBER_OF_TRAITS; i++) {
			double userScore = computeFinalTraitScore(userResponses.get(questionnaireTraits[i]), userResponses.get(questionnaireTraits[i + 5]));
			double mean = Double.parseDouble(comparisonData.getRelevantMetrics()[0][i]);
			double standardDeviation = Double.parseDouble(comparisonData.getRelevantMetrics()[1][i]);
			int sampleSize = Integer.parseInt(comparisonData.getRelevantMetrics()[2][i]);
			Trait currentTrait = new Trait(traitNames[i], userScore, mean, standardDeviation, sampleSize, findPeerComparison(userScore, mean, standardDeviation));
			bigFivePersonalityScoresAndMetrics[i] = currentTrait;
		}
		
		// Return the final Trait array back to the calling class.
		return bigFivePersonalityScoresAndMetrics;
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
	 * A helper method which takes the two scores associated with a specific
	 * "Big Five" trait and finds their average to compute a total score
	 * for that trait.
	 * @param traitScoreOne - The first of two recorded scores
	 * @param traitScoreTwo - The second of two recorded scores
	 * @return - The final score for the trait in question
	 */
	private double computeFinalTraitScore(int traitScoreOne, int traitScoreTwo) {
		return (traitScoreOne + traitScoreTwo) / 2.0;
	}

	/**
	 * A helper method which calculates if the user's scores is average,
	 * above average, or below average relative to the user's peer group.
	 * This is done by calculating if the user's score is larger than one
	 * standard deviation above their peer group's mean, smaller than one
	 * standard deviation below the mean, or within that range.
	 * @param score - The current user's score
	 * @param mean - The mean score of other's in the user's peer group
	 * @param stdDeviation - The standard deviation of scores in the user's
	 * peer group
	 * @return - The String describing where the user's score falls compared
	 * to their peers
	 */
	public String findPeerComparison(double score, double mean, double stdDeviation) {
		if(score > mean + stdDeviation) {
			return "High";
		}
		else if(score < mean - stdDeviation) {
			return "Low";
		}
		else {
			return "Average";
		}
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
	 * A getter method for the object which will read and process the
	 * researched sample of Tipi participants.
	 * @return - The data reader object.
	 */
	public NormDataReader getComparisonData() {
		return comparisonData;
	}
	
	/**
	 * A getter method for the Map representing the current user's input
	 * responses to the questionnaire questions.
	 * @return - The map representing the user's answers.
	 */
	public LinkedHashMap<String, Integer> getUserResponses() {
		return userResponses;
	}

	/**
	 * A getter method for the constant describing the number of traits in TIPI.
	 * @return - The constant for the number of traits
	 */
	public int getNUMBER_OF_TRAITS() {
		return NUMBER_OF_TRAITS;
	}

	/**
	 * A getter method for the Trait array holding each of the "Big Five
	 * Personality Traits" and each of their relevant information as it
	 * pertains to the current user.
	 * @return - The trait array of relevant information
	 */
	public Trait[] getBigFivePersonalityScoresAndMetrics() {
		return bigFivePersonalityScoresAndMetrics;
	}
}