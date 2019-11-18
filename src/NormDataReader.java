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
	private User currentUser;
	private final int NUMBER_OF_TRAITS;
	private Trait[] personalityTraitMetrics;
	
	/**
	 * The constructor for the NormDataReader class.  Reads the appropriate
	 * researched data file given the fileName (based on the user's sex) and
	 * saves only the information that corresponds to the user's age.
	 * @param currentUser - The attributes of the current user which decide
	 * which researched file to pull data from, and what information from that
	 * file to pull.
	 */
	public NormDataReader(User currentUser) {
		this.currentUser = currentUser;
		NUMBER_OF_TRAITS = 5;  // Models the 5 big traits of Tipi
		personalityTraitMetrics = new Trait[NUMBER_OF_TRAITS];
		if(currentUser.getSex().equals("Male")) {
			fileName = "TIPINormsMale.csv";
		}
		else {
			fileName = "TIPINormsFemale.csv";
		}
	}

	/**
	 * A method which reads the appropriate researched norm data file and 
	 * collects all of the information which aligns with the user's age.
	 */
	public void readFileAndRecordTraitMetrics() {
		try {
			Scanner in = new Scanner(new File(fileName));
			
			
			
			
		} 
		catch (FileNotFoundException e) {
			System.out.println("Problem found.  Please restart the program.");
			e.printStackTrace();
		}
		
		
		
		// Finish 
		
		
		
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
	 * A getter method for the object representing the user of the program.
	 * @return - The name of the user object.
	 */
	public User getCurrentUser() {
		return currentUser;
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
		return personalityTraitMetrics;
	}
}