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
import javafx.scene.image.Image;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import javafx.event.ActionEvent;

/**
 * Provides the functionality and presentation for the Introduction screen that
 * the user will see.
 * @author andrew.mcmanus
 *
 */
public class IntroScreen{

	private int stageX = 600;
	private int stageY = 700;
	private FileInputStream input;
	
	/**
	 * Presents the Introduction page to the user when called by the TipiProgram
	 * class. It provides a brief introduction to the user on what he/she can
	 * expect, and then it allows them to continue on to the survey page with 
	 * a quick button click.
	 */
	public void start() {
		
	    /**
	     * Create Scene and Border
	     */
		//Create Stage and border
		Stage introStage = new Stage();
		BorderPane introBorderPane = new BorderPane();
	    Scene scene = new Scene(introBorderPane, stageX, stageY);
		introStage.setScene(scene);
		//set title of stage
		introStage.setTitle("TIPI Analysis Survey");
		
		
		/**
		 * Page Title Text
		 */
		// Header UserProfile
		GridPane introGrid = new GridPane();
	    Text title = new Text("TIPI Analyzer");
	    // Change Font of title
	    title.setFont(Font.font(null, FontWeight.BOLD, 30));
	    introGrid.add(title,0,0);
	    HBox titleBox = new HBox(title);
	    titleBox.setAlignment(Pos.CENTER);
		titleBox.setPadding(new Insets(45));
	    introBorderPane.setTop(titleBox);
	    
	    /**
	     * Introduction Paragraph
	     * NEEDS A GRID PANE TO SEPARATE THE BODY TEXTS. RIGHT NOW
	     * ONE IS NOT SHOWING.
	     */
	    
	    Text bodyText1 = new Text(
	    		"Welcome to the TIPI Analyzer! TIPI stands for Ten Item "
	    		+ "Personality Inventory. It's a tool used by psychologists "
	    		+ "to define our personalities on a few different scales. "
	    		+ "How we score on these scales can tell us more about our own "
	    		+ "personality traits, and how these traits might be affecting our "
	    		+ "behavior without us even knowing it! By learning more about "
	    		+ "how you score on these traits, you can determine how this may "
	    		+ "be affecting your behavior, and in turn, behave more consciously "
	    		+ "when it comes to certain decision-making points in your life."
	    		+ "\n \n"
	    		);
	    
	    Text bodyText2 = new Text(
	    		"On the next page, we'll ask you to answer ten questions where "
	    	  + "you will need to describe your personality on 7-point scales."

	    		);
	    bodyText1.setWrappingWidth(400);
	    bodyText2.setWrappingWidth(450);
	    
	    HBox bodyBox1 = new HBox();
	    bodyBox1.getChildren().add(bodyText1);
	    bodyBox1.setAlignment(Pos.CENTER);
	    
	    HBox bodyBox2 = new HBox();
	    bodyBox2.getChildren().add(bodyText2);
	    bodyBox2.setAlignment(Pos.CENTER);
	    
	    bodyBox2.setPadding(new Insets(10));
	    introBorderPane.setCenter(bodyBox1);
	    introBorderPane.setCenter(bodyBox2);

		/**
		 * Button functionality and placement
		 */
		//Add a "Continue to Survey" button
		Button btn = new Button("Continue to Survey");
		//Make button actionable - send user to survey upon clicking
		btn.setOnAction(e -> continueToSurvey()); 
		HBox buttonHolder = new HBox();
		buttonHolder.setAlignment(Pos.CENTER);
		//Sets padding from bottom
		buttonHolder.setPadding(new Insets(60));
		buttonHolder.setSpacing(10);
		buttonHolder.getChildren().add(btn);
		introBorderPane.setBottom(buttonHolder);
		
       

		BackgroundFill myBF = new BackgroundFill(Color.WHITE, new CornerRadii(1),
				new Insets(0.0,0.0,0.0,0.0));
		
		
		introBorderPane.setBackground(new Background(myBF));
		
		
		//Show the window
		introStage.show();
	}

	/*
	 * This method brings the user to the survey page. It is 
	 * executed when the user clicks the "Continue to Survey" buttons
	 */
	public void continueToSurvey() {
		
		SurveyPage surveyPage = new SurveyPage();
		surveyPage.showSurveyPage();
	
		
	}
	
	
	
}
