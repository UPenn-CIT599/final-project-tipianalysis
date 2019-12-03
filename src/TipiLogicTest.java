import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * A test class used to unit test the methods of the TipiLogic class.
 * @author michaelnarcisi
 */
class TipiLogicTest {

	// Initialize test instances of the parameters for the TipiLogic class.
	static User testUser;
	static LinkedHashMap<String, Integer> testHashMap;
	
	@BeforeAll
	
	/***
	 * Construct the parameters needed to run tests on the methods in the TipiLogic class.
	 */
	public static void setupVariablesForTesting() {
		testUser = new User("Bob", 35, "Male");
		testHashMap = new LinkedHashMap<String, Integer>();
		// The puts account for the answers the user would have given
		testHashMap.put("Extraverted", 6);
		testHashMap.put("Critical", 5);
		testHashMap.put("Dependable", 4);
		testHashMap.put("Anxious", 6);
		testHashMap.put("Open", 7);
		testHashMap.put("Reserved", 3);
		testHashMap.put("Sympathetic", 2);
		testHashMap.put("Disorganized", 5);
		testHashMap.put("Calm", 2);
		testHashMap.put("Conventional", 5);
	}
	
	@Test
	
	/**
	 * The test case for the TipiLogic.runLogic() method.
	 */
	void testRunLogic() {
		TipiLogic logicTestOne = new TipiLogic(testUser, testHashMap);
		// Create a separate Trait[] with all expected answers to compare to the written method
		Trait[] testTraitArray = new Trait[5];
		Trait traitOne = new Trait("Extraversion", 5.5, 3.81, 1.54, 14752, "High");
		testTraitArray[0] = traitOne;
		Trait traitTwo = new Trait("Agreeableness", 2.5, 4.55, 1.21, 14752, "Low");
		testTraitArray[1] = traitTwo;
		Trait traitThree = new Trait("Conscientiousness", 3.5, 4.77, 1.35, 14752, "Low");
		testTraitArray[2] = traitThree;
		Trait traitFour = new Trait("Emotional Stability", 2.0, 4.63, 1.42, 14752, "Low");
		testTraitArray[3] = traitFour;
		Trait traitFive = new Trait("Openness", 5.0, 5.49, 1.12, 14752, "Average");
		testTraitArray[4] = traitFive;
		
		// Create a second test array for the runLogic() method to add values to
		Trait[] secondTestArray = logicTestOne.runLogic();
		
		// Cycle through each piece of the Trait array and make assertions for each
		for(int i = 0; i < 5; i++) {
			assertEquals(testTraitArray[i].getName() + ": " + testTraitArray[i].getUserScore() + ", " + 
					testTraitArray[i].getMean() + ", " + testTraitArray[i].getStandardDeviation() + ", " + 
					testTraitArray[i].getSampleSize() + ", " + testTraitArray[i].getComparisonToPeers(), 
					secondTestArray[i].getName() + ": " + secondTestArray[i].getUserScore() + ", " + 
					secondTestArray[i].getMean() + ", " + secondTestArray[i].getStandardDeviation() + ", " + 
					secondTestArray[i].getSampleSize() + ", " + secondTestArray[i].getComparisonToPeers());
		}
	}
	
	@Test
	
	/**
	 * The test case for the TipiLogic.recodeReverseScoredItems() method.
	 */
	void testRecodeReverseScoredItems() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		TipiLogic logicTestTwo = new TipiLogic(testUser, testHashMap);
		
		// Prepare to test private method
		Class testClassTwo = logicTestTwo.getClass();
		Method privateRecodeReverseScoredItemsMethod = testClassTwo.getDeclaredMethod("recodeReverseScoredItems");
		privateRecodeReverseScoredItemsMethod.setAccessible(true);
		
		// Invoke private method
		privateRecodeReverseScoredItemsMethod.invoke(logicTestTwo);
		
		// Initialize remaining needed variables
		LinkedHashMap<String, Integer> manualHashMap = new LinkedHashMap<String, Integer>();
		manualHashMap.put("Extraverted", 6);
		manualHashMap.put("Critical", 3);
		manualHashMap.put("Dependable", 4);
		manualHashMap.put("Anxious", 2);
		manualHashMap.put("Open", 7);
		manualHashMap.put("Reserved", 5);
		manualHashMap.put("Sympathetic", 2);
		manualHashMap.put("Disorganized", 3);
		manualHashMap.put("Calm", 2);
		manualHashMap.put("Conventional", 3);
		
		// Cycle through each piece of the HashMap to ensure the proper values have been reversed
		for(String traitName : manualHashMap.keySet()) {
			assertEquals(logicTestTwo.getUserResponses().get(traitName), manualHashMap.get(traitName));
		}
	}
	
	@Test
	
	/**
	 * The test case for the TipiLogic.computeFinalTraitScore() method.
	 */
	void testComputeFinalTraitScore() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		TipiLogic logicTestThree = new TipiLogic(testUser, testHashMap);
		
		// Prepare to test private method
		Class testClassThree = logicTestThree.getClass();
		Method privateComputeFinalTraitScoreMethod = testClassThree.getDeclaredMethod("computeFinalTraitScore", int.class, int.class);
		privateComputeFinalTraitScoreMethod.setAccessible(true);
				
		// Invoke private method
		double testScore = (Double) privateComputeFinalTraitScoreMethod.invoke(logicTestThree, 
				logicTestThree.getUserResponses().get("Extraverted"), logicTestThree.getUserResponses().get("Reserved"));
		
		// Ensure calculation is completed correctly
		assertEquals(testScore, 4.5);
	}
	
	@Test
	
	/**
	 * The test case for the TipiLogic.findPeerComparison() method.
	 */
	void testFindPeerComparison() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		TipiLogic logicTestFour = new TipiLogic(testUser, testHashMap);
		
		// Prepare to test private method
		Class testClassFour = logicTestFour.getClass();
		Method privateFindPeerComparisonMethod = testClassFour.getDeclaredMethod("findPeerComparison", double.class, double.class, double.class);
		privateFindPeerComparisonMethod.setAccessible(true);
		
		//Invoke private method
		String testResult = (String)privateFindPeerComparisonMethod.invoke(logicTestFour, 3.5, 4.77, 1.35);
		
		// Ensure String is assigned correctly
		assertEquals(testResult, "Low");
	}
	
	@Test
	
	/**
	 * The test case for the TipiLogic.getCurrentUser() method.
	 */
	void testGetCurrentUser() {
		TipiLogic logicTestFive = new TipiLogic(testUser, testHashMap);
		assertEquals("The user " + logicTestFive.getCurrentUser().getName() + " is a " + 
		logicTestFive.getCurrentUser().getAge() + " year old " + logicTestFive.getCurrentUser().getSex(), 
		"The user " + "Bob" + " is a " + "35" + " year old " + "Male");
	}
	
	@Test
	
	/**
	 * The test case for the TipiLogic.getUserResponses() method.
	 */
	void testGetUserResponses() {
		TipiLogic logicTestSix = new TipiLogic(testUser, testHashMap);
		// Initialize comparative HashMap
		LinkedHashMap<String, Integer> anotherTestMap = new LinkedHashMap<String, Integer>();
		anotherTestMap.put("Extraverted", 6);
		anotherTestMap.put("Critical", 5);
		anotherTestMap.put("Dependable", 4);
		anotherTestMap.put("Anxious", 6);
		anotherTestMap.put("Open", 7);
		anotherTestMap.put("Reserved", 3);
		anotherTestMap.put("Sympathetic", 2);
		anotherTestMap.put("Disorganized", 5);
		anotherTestMap.put("Calm", 2);
		anotherTestMap.put("Conventional", 5);
		
		// Ensure all values of HashMap are correct
		for(String traitName : anotherTestMap.keySet()) {
			assertEquals(testHashMap.get(traitName), anotherTestMap.get(traitName));
		}
	}
}