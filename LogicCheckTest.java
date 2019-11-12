import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

/**
 * The JUnit Test which will test a method to be used during the final project.
 * @author michaelnarcisi
 */
class LogicCheckTest {

	LogicCheck tester = new LogicCheck();
	
	
	@Test
	public void testRecodeReverseScoredItems() {
		
		HashMap<String, Integer> inputResponses;
		HashMap<String, Integer> outputsToMatch;
		
                // Change the integer values in both HashMaps to test different scenarios.  Possible values: 1-7
		
		inputResponses = new HashMap<String, Integer>();
		// Assign input values to each of the 10 items in TIPI
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
		
		outputsToMatch = new HashMap<String, Integer>();
		/* These values are what the input values should evaluate to after
		going through the "RecodeReverseScoredItems" method. */
		outputsToMatch.put("Extraverted", 5);
		outputsToMatch.put("Critical", 4);
		outputsToMatch.put("Dependable", 6);
		outputsToMatch.put("Anxious", 6);
		outputsToMatch.put("Open", 5);
		outputsToMatch.put("Reserved", 5);
		outputsToMatch.put("Sympothetic", 7);
		outputsToMatch.put("Disorganized", 3);
		outputsToMatch.put("Calm", 2);
		outputsToMatch.put("Conventional", 1);
		
		System.out.println(inputResponses);
		System.out.println(outputsToMatch);
		
		assertEquals(tester.recodeReverseScoredItems(inputResponses), outputsToMatch);
	}
}
