import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

class SurveyPageTest {
	
	
	
	@Test
	/**
	 * Tests the HBox method by creating an HBox, putting it in a linked hashmap
	 * and ensuring that the same HBox is being returned. This is done by confirming
	 * the x coordinate of the HBox is the same as the one that was entered into
	 * the linkedHashMap.
	 */
	void testGetHBox() {
		
		LinkedHashMap<HBox, ToggleGroup> testLinkedHashMap = new LinkedHashMap<HBox,ToggleGroup>();
		SurveyPage surveyPage = new SurveyPage();
		
		ToggleGroup toggleGroup1 = new ToggleGroup();
		HBox box = new HBox();
		box.setLayoutX(100);
		testLinkedHashMap.put(box, toggleGroup1);
		HBox testBox = surveyPage.getHBox(testLinkedHashMap);
		
		assertEquals(testBox.getLayoutX(), box.getLayoutX());

	}

	
}
