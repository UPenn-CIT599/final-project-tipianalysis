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
	 * @param sexOfUser - The sex of the current user
	 * @param ageOfUser - The age of the current user
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
						// Try to grab age range from first cell of row
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
	 * A getter method for the name of the file used to pull data from.
	 * @return - The name of the file.
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * A getter method for the matrix of relevant data obtained from the external file.
	 * @return - The matrix of important metrics
	 */
	public String[][] getRelevantMetrics() {
		return relevantMetrics;
	}

	/**
	 * A getter method for the constant defining the number of rows in the matrix.
	 * @return - The row constant
	 */
	public int getNUMBER_OF_ROWS() {
		return NUMBER_OF_ROWS;
	}

	/**
	 * A getter method for the constant defining the number of columns in the matrix.
	 * @return - The column constant
	 */
	public int getNUMBER_OF_COLUMNS() {
		return NUMBER_OF_COLUMNS;
	}
}