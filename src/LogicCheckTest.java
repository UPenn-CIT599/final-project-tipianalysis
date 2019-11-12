import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class LogicCheckTest {

	LogicCheck tester = new LogicCheck();
	
	@Test
	void testRecodeReverseScoredItems() {
		
		HashMap<String, Integer> inputResponses;
		HashMap<String, Integer> outputsToMatch;
		
		///// Change the integer values in both HashMaps to test different scenarios.
		
		inputResponses = new HashMap<String, Integer>();
		// Assign input values to each of the 10 items in TIPI
		inputResponses.put("Extraverted", 5);
		inputResponses.put("Critical", 7);
		inputResponses.put("Dependable", 6);
		inputResponses.put("Anxious", 2);
		inputResponses.put("Open", 5);
		inputResponses.put("Reserved", 1);
		inputResponses.put("Sympothetic", 7);
		inputResponses.put("Disorganized", 3);
		inputResponses.put("Calm", 2);
		inputResponses.put("Conventional", 3);
		
		outputsToMatch = new HashMap<String, Integer>();
		/* These values are what the input values should evaluate to after
		going through the "RecodeReverseScoredItems" method. */
		outputsToMatch.put("Extraverted", 5);
		outputsToMatch.put("Critical", 1);
		outputsToMatch.put("Dependable", 6);
		outputsToMatch.put("Anxious", 6);
		outputsToMatch.put("Open", 5);
		outputsToMatch.put("Reserved", 7);
		outputsToMatch.put("Sympothetic", 7);
		outputsToMatch.put("Disorganized", 5);
		outputsToMatch.put("Calm", 2);
		outputsToMatch.put("Conventional", 5);
		
		System.out.println(inputResponses);
		System.out.println(outputsToMatch);
		
		assertEquals(tester.recodeReverseScoredItems(inputResponses), outputsToMatch);
	}
}