import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class TipiLogicTest {

	@Test
	
	void testRunLogic() {
		// Initiate test TipiLogic class in order to return the Trait[] from the  runLogic() method
		LinkedHashMap<String, Integer> testHashMap = new LinkedHashMap<String, Integer>();
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
		TipiLogic logicTest = new TipiLogic(new User("Bob", 35, "Male"), testHashMap);
		
		// Create a separate Trait[] with all expected answers to compare to the written method
		Trait[] testTraitArray = new Trait[5];
		Trait traitOne = new Trait("Extraversion", 5.5, 3.81, 1.54, 14752, "High");
		testTraitArray[0] = traitOne;
		Trait traitTwo = new Trait("Agreeableness", 2.5, 4.55, 1.21, 14752, "Low");
		testTraitArray[1] = traitTwo;
		Trait traitThree = new Trait("Conscientiousness", 3.5, 4.77, 1.35, 14752, "Average");
		testTraitArray[2] = traitThree;
		Trait traitFour = new Trait("Emotional Stability", 2.0, 4.63, 1.42, 14752, "Low");
		testTraitArray[3] = traitFour;
		Trait traitFive = new Trait("Openness", 5.0, 5.49, 1.12, 14752, "Average");
		testTraitArray[4] = traitFive;
		
		// Create a second test array for the runLogic() method to add values to
		Trait[] secondTestArray = logicTest.runLogic();
		
		// Cycle through each piece of the Trait array and make assertions for each
		for(int i = 0; i < 5; i++) {
			assertEquals(testTraitArray[i].getName() + ": " + testTraitArray[i].getUserScore() + ", " + testTraitArray[i].getMean() + ", " + testTraitArray[i].getStandardDeviation() + ", " + testTraitArray[i].getSampleSize() + ", " + testTraitArray[i].getComparisonToPeers(), secondTestArray[i].getName() + ": " + secondTestArray[i].getUserScore() + ", " + secondTestArray[i].getMean() + ", " + secondTestArray[i].getStandardDeviation() + ", " + secondTestArray[i].getSampleSize() + ", " + secondTestArray[i].getComparisonToPeers());
		}
	}
}
