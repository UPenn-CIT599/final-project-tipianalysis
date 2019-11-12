import java.util.HashMap;

/**
 * A class used to store the method to be unit tested as part of the first
 * project milestone.
 * @author michaelnarcisi
 */
public class LogicCheck {
	
	/**
	 * The constructor for the testing class.
	 */
	public LogicCheck() {
	}
	
	/**
	 * A method which takes the answers from the reverse-scored items in the
	 * Tipi questionnaire and recodes their scores to produce the correct
	 * outcome.  For example, using the 1-7 scale, a reverse-scored item
	 * scored as a 6 would become a 2, etc.
	 */
	public HashMap<String, Integer> recodeReverseScoredItems(HashMap<String, Integer> inputs) {
		// Reverse-scored items: (Should be: 2, 4, 6, 8, 10.)  
		// The following code will be used when I figure out how to order the items in a keySet
		
//		int reverseItemMarker = 1;
//		for (String scaleTrait : inputs.keySet()) {
//			// Ensure logic only processes the even portions of the map
//			if (reverseItemMarker % 2 == 0) {
//				inputs.put(scaleTrait, 8 - inputs.get(scaleTrait));
//			}
//			reverseItemMarker++;
//		}
//		return inputs;
		
		// Code for this submission.  (In this iteration, reverse scored items: 4, 6, 7, 9, 10)
		int reverseItemMarker = 1;
		for (String scaleTrait : inputs.keySet()) {
			if (reverseItemMarker == 4 || reverseItemMarker == 6 || reverseItemMarker == 7 ||
					reverseItemMarker == 9 || reverseItemMarker == 10) {
				inputs.put(scaleTrait, 8 - inputs.get(scaleTrait));
			}
			reverseItemMarker++;
		}
		return inputs;
	}
}