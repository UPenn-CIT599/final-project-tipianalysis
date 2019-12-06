import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * A test class used to unit test the methods of the NormDataReader class.
 * @author michaelnarcisi
 */
class NormDataReaderTest {

	static NormDataReader testDataReader;  // Create test instance of NormDataReader class.
	
	@BeforeAll
	
	/**
	 * Initialize test instance of NormDataReader class.
	 */
	public static void initializeNormDataReader() {
		testDataReader = new NormDataReader("Female", 27);
	}
	
	@Test
	
	/**
	 * The test case for the NormDataReader.getFileName() method.
	 */
	void testGetFileName() {
		assertEquals(testDataReader.getFileName(), "TIPINormsFemale.csv");
	}

	@Test
	
	/**
	 * The test case for the NormDataReader.getRelevantMetrics() method.
	 */
	void testGetRelevantMetrics() {
		// Initialize and populate a test 2-D String array with all correct values populated in it.
		String[][] testMetrics = new String[testDataReader.getNUMBER_OF_ROWS()][testDataReader.getNUMBER_OF_COLUMNS()];
		testMetrics[0][0] = "4.07";
		testMetrics[0][1] = "4.88";
		testMetrics[0][2] = "4.78";
		testMetrics[0][3] = "4.09";
		testMetrics[0][4] = "5.55";
		testMetrics[1][0] = "1.61";
		testMetrics[1][1] = "1.19";
		testMetrics[1][2] = "1.41";
		testMetrics[1][3] = "1.45";
		testMetrics[1][4] = "1.12";
		for(int i = 0; i < 5; i++) {
			testMetrics[2][i] = "46530";
		}
		
		// Check that each section of the relevantMetrics 2-D array is correct
		for(int i = 0; i < testDataReader.getNUMBER_OF_ROWS(); i++) {
			for(int j = 0; j < testDataReader.getNUMBER_OF_COLUMNS(); j++) {
				assertEquals(testDataReader.getRelevantMetrics()[i][j], testMetrics[i][j]);
			}
		}
	}
}
