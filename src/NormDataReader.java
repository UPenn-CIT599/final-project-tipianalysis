import java.io.*;
import java.util.*;

/**
 * The class which reads the norm data collected from a sample of Tipi
 * participants and saves only the information that aligns with the current 
 * user on the basis of age and sex.
 * @author michaelnarcisi
 */
public class NormDataReader {
	private String fileName;
	private String[][] relevantMetrics;
	private final int NUMBER_OF_ROWS;
	private final int NUMBER_OF_COLUMNS;
	
	/**
	 * The constructor for the NormDataReader class.  Reads the appropriate
	 * researched data file given the fileName (based on the user's sex) and
	 * saves only the information that corresponds to the user's age.
	 * @param currentUser - The attributes of the current user which decide
	 * which researched file to pull data from, and what information from that
	 * file to pull.
	 */
	public NormDataReader(String sexOfUser, int ageOfUser) {
		NUMBER_OF_ROWS = 3; // There are three types of metrics to collect
		NUMBER_OF_COLUMNS = 5; // There are five traits to collect metrics from
		if(sexOfUser.equals("Male")) {
			fileName = "TIPINormsMale.csv";
		}
		else {
			fileName = "TIPINormsFemale.csv";
		}
		relevantMetrics = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		// Read input file
		try (Scanner in = new Scanner(new File(fileName))){
			int lowerAgeBound = 0;
			int upperAgeBound = 0;
			int rowCount = 0;
			in.nextLine();  // Skip the header row
			// Read the relevant information for the Five main personality traits and store them
			while (in.hasNextLine()) {
				String nextRow = in.nextLine();
				String[] elementsOfRow = nextRow.split(",");
				// Ensure next row isn't a blank row
				if (elementsOfRow.length != 0) {
					String firstCellOfRow = elementsOfRow[0];	
					// If first cell of row isn't blank, it's listing an age range
					if(!firstCellOfRow.equals("")) {
						// Try to grab age range from first cell on row
						try {
							lowerAgeBound = Integer.parseInt(firstCellOfRow.substring(0, 2));
							upperAgeBound = Integer.parseInt(firstCellOfRow.substring(6, 8));
						}
						catch (NumberFormatException e) {
							// Highest age range starts at 61
							lowerAgeBound = 61;
							// highest age range has no upper bound
							upperAgeBound = (int)Double.POSITIVE_INFINITY;
							}
					}
					//  Read file values if age is within boundaries
					if(ageOfUser >= lowerAgeBound && ageOfUser <= upperAgeBound) {
						for(int i = 0; i < 5; i++) {
							relevantMetrics[rowCount][i] = elementsOfRow[i + 2];  // Adjusted to correctly read input file
						}
						rowCount++;	
					}
				}
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("Problem found.  Please restart the program.");
			e.printStackTrace();
		}
	}

	/**
	 * A method which reads the appropriate researched norm data file and 
	 * collects all of the information which aligns with the user's age.
	 */
	public void readFileAndRecordTraitMetrics(int ageOfUser) {
		
		
		
		
		// Finish 
		
		
		
	}
	
	
	
	
	// Make UpdateTrait Method more dry	
	
	/**
	 * A helper method which updates the Trait[] given the current
	 * line of the file that is being read.
	 */
	private void updateTrait(String[] lineOfFile, String storedInformation) {
		// Reads the .csv file from the third column to the seventh
		for(int i = 2; i < 7; i++) {
			if(storedInformation.equals("Mean")) {
				try {
					personalityTraits[i - 2].setMean(Double.parseDouble(lineOfFile[i]));
				}
				catch (NumberFormatException e) {
					// Leave value as Null
				}	
			}
			else if(storedInformation.equals("SD")) {
				try {
					personalityTraits[i - 2].setStandardDeviation(Double.parseDouble(lineOfFile[i]));
				}
				catch (NumberFormatException e) {
					// Leave value as Null
				}
			}
			else if(storedInformation.equals("n =")) {
				try {
					personalityTraits[i - 2].setSampleSize(Integer.parseInt(lineOfFile[i]));
				}
				catch (NumberFormatException e) {
					// Leave value as Null
				}
			}
			else {
				System.out.println("mean");
				System.out.println(Arrays.toString(lineOfFile));
				System.out.println(lineOfFile[i]);
				personalityTraits[i - 2].setName(lineOfFile[i]);
			}
		}
	}
	
	
	
	
	/**
	 * A helper method which calculates if the user's scores is average,
	 * above average, or below average relative to the user's peer group.
	 * @return - The String describing where the user's score falls compared
	 * to their peers
	 */
	public String findPeerComparison() {
		
		
		
		
		// Finish
		
		
		
	}
	
	/**
	 * A getter method for the name of the file used to pull data from.
	 * @return - The name of the file.
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * A getter method for the number of personality traits analyzed.
	 * @return - The number of personality traits analyzed.
	 */
	public int getNUMBER_OF_TRAITS() {
		return NUMBER_OF_TRAITS;
	}

	/**
	 * A getter method for the personality trait array which contains each
	 * trait's name and pertinent researched score information.
	 * @return - The personality trait array.
	 */
	public Trait[] getPersonalityTraitMetrics() {
		return personalityTraits;
	}
	
	public static void main(String[] args) {
		NormDataReader data = new NormDataReader("Male", 18);
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.println(data.relevantMetrics[i][j]);
			}
		}
		
		
	}
	
}