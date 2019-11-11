import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.*;
import java.util.HashMap;
import javafx.event.ActionEvent;

/**
 * This class manages the survey page. It has three methods.
 * One method is for managing the structure of the page itself 
 * in the UI, one is for recording the user input values for the 
 * survey questions and storing them in a hashmap, and one is for
 * providing functionality to the "Continue to Results" page.
 * @author andrew.mcmanus
 *
 */
public class SurveyPage{

	User surveyUser;
	
	/**
	 * This method manages the structure of the UI for the survey page.
	 */
	public void showSurveyPage(){

		//Create Stage and border
				Stage introStage = new Stage();
				BorderPane introBorderPane = new BorderPane();
				//set title of stage
				introStage.setTitle("TIPI Survey");
				
				
				//Add a "Continue to Survey" button
				Button btn = new Button("Save and View Results");
				//Make button actionable - send user to survey upon clicking

				//Create button on the screen
				StackPane btnRoot = new StackPane();
				btnRoot.getChildren().add(btn);

				
				//Create a scene where the button is present
				Scene introScene = new Scene(btnRoot, 500, 300);
				introStage.setScene(introScene);
				
				//Show the window
				introStage.show();
	}

	/**
	 * This method will capture the results that the user inputs into the 
	 * questionnaire. This will include: Name, age, sex, TIPI scores.
	 */
	public static void surveyAnswerCollection() {
		
	}
	
	public static void continueToResults() {
		ResultsViewer resultsPage = new ResultsViewer();
		resultsPage.createStage(user);
	}
	
	
}
