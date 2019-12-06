import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntroScreenTest {

	User olderUser = new User("Andrew",27,"Male");
	User youngerUser = new User("Younger Andrew",10,"Male");
	IntroScreen introScreen = new IntroScreen();

	/**
	 * Tests the method ageValidator that determines if someone is of age to
	 * take the survey. If they are 16, they are of age (and we expect true). 
	 * If they are not, they cannot take the survey (and we expect false).
	 */
	@Test
	void testAgeValidator() {

		
		boolean olderAllowedToTakeSurvey = introScreen.ageValidator(olderUser.getAge());
		boolean youngerAllowedToTakeSurvey = introScreen.ageValidator(youngerUser.getAge());
		assertEquals(olderAllowedToTakeSurvey,true);
		assertEquals(youngerAllowedToTakeSurvey,false);
		
	}

}
