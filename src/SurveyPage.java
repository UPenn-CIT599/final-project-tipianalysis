import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.application.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.event.ChangeListener;

import javafx.event.ActionEvent;

/**
 * This class manages the survey page. It has three methods.
 * One method is for managing the structure of the page itself 
 * in the UI, one is for recording the user input values for the 
 * survey questions and storing them in a linked hashmap, and one is for
 * providing functionality to the "Continue to Results" page.
 * @author andrew.mcmanus
 *
 */
public class SurveyPage{
	
	//Instantiate user to receive user from 
	User surveyUser;
	private int stageX = 1000;
	private int stageY = 900;
	Stage survey = new Stage();
	BorderPane surveyBorderPane = new BorderPane();
    Scene surveyScene = new Scene(surveyBorderPane, stageX, stageY);
	
	/**
	 * This method manages the structure of the UI for the survey page.
	 */
	public Scene showSurveyPage(User user){

				//Create Stage and border
				Text pageTitle = new Text("Personality Survey");
				pageTitle.setFont(Font.font("Veranda",20));
				HBox title = new HBox();
				title.getChildren().add(pageTitle);
				title.setLayoutX(420);
				title.setLayoutY(20);
				
				Text description = new Text("Here is a number of personality traits "
						+ "that may or may not apply to you. \n"
						+"  \n"
						+ "Please indicae the extent to which you agree or disagree "
						+ "that each one describes you. You should rate the extent "
						+ "to which the pair of traits applies to you, even if one"
						+ "characteristic applies more generally than the other.");
				
				description.setWrappingWidth(800);
				description.setFont(Font.font("Veranda",15));
			    description.setTextAlignment(TextAlignment.CENTER);

				HBox instructions = new HBox(5);
				
				instructions.getChildren().add(description);
				instructions.setLayoutX(100);
				instructions.setLayoutY(70);
	
				//Create Options labels:
				Text option1 = new Text("Disagree Strongly");
				option1.setWrappingWidth(80);
				option1.setTextAlignment(TextAlignment.CENTER);
				option1.setFont(Font.font("Veranda",FontWeight.BOLD, 13));
				Text option2 = new Text("Disagree Moderately");
				option2.setWrappingWidth(80);
				option2.setTextAlignment(TextAlignment.CENTER);
				option2.setFont(Font.font("Veranda",FontWeight.BOLD, 13));
				Text option3 = new Text("Disagree a Little");
				option3.setWrappingWidth(80);
				option3.setTextAlignment(TextAlignment.CENTER);
				option3.setFont(Font.font("Veranda",FontWeight.BOLD, 13));
				Text option4 = new Text("Neither Agree nor Disagree");
				option4.setWrappingWidth(80);
				option4.setTextAlignment(TextAlignment.CENTER);
				option4.setFont(Font.font("Veranda",FontWeight.BOLD, 13));
				Text option5 = new Text("Agree a Little");
				option5.setWrappingWidth(80);
				option5.setTextAlignment(TextAlignment.CENTER);
				option5.setFont(Font.font("Veranda",FontWeight.BOLD, 13));
				Text option6 = new Text("Agree Moderately");
				option6.setWrappingWidth(80);
				option6.setTextAlignment(TextAlignment.CENTER);
				option6.setFont(Font.font("Veranda",FontWeight.BOLD, 13));
				Text option7 = new Text("Agree Strongly");
				option7.setWrappingWidth(80);
				option7.setTextAlignment(TextAlignment.CENTER);
				option7.setFont(Font.font("Veranda",FontWeight.BOLD, 13));

				
				
				//options.setFont(Font.font("Veranda",FontWeight.BOLD,10));
				HBox optionBox = new HBox(28);
				optionBox.getChildren().addAll(option1,option2,option3,option4,
											   option5,option6,option7);
				optionBox.setLayoutX(200);
				optionBox.setLayoutY(165);
				optionBox.setStyle("-fx-background-color: #D3F4FF");
				
				//Create buttons for row a
				RadioButton a1 = new RadioButton();
				RadioButton a2 = new RadioButton();
				RadioButton a3 = new RadioButton();
				RadioButton a4 = new RadioButton();
				RadioButton a5 = new RadioButton();
				RadioButton a6 = new RadioButton();
				RadioButton a7 = new RadioButton();

				ToggleGroup toggleGroup1 = new ToggleGroup();
				a1.setToggleGroup(toggleGroup1);
				a2.setToggleGroup(toggleGroup1);
				a3.setToggleGroup(toggleGroup1);
				a4.setToggleGroup(toggleGroup1);
				a5.setToggleGroup(toggleGroup1);
				a6.setToggleGroup(toggleGroup1);
				a7.setToggleGroup(toggleGroup1);
				
				HBox row2 = new HBox(90);
				row2.getChildren().addAll(a1,a2,a3,a4,a5,a6,a7);
				row2.setLayoutX(230);
				row2.setLayoutY(225);
				
				//Create buttons for row b
				RadioButton b1 = new RadioButton();
				RadioButton b2 = new RadioButton();
				RadioButton b3 = new RadioButton();
				RadioButton b4 = new RadioButton();
				RadioButton b5 = new RadioButton();
				RadioButton b6 = new RadioButton();
				RadioButton b7 = new RadioButton();

				ToggleGroup toggleGroup2 = new ToggleGroup();
				b1.setToggleGroup(toggleGroup2);
				b2.setToggleGroup(toggleGroup2);
				b3.setToggleGroup(toggleGroup2);
				b4.setToggleGroup(toggleGroup2);
				b5.setToggleGroup(toggleGroup2);
				b6.setToggleGroup(toggleGroup2);
				b7.setToggleGroup(toggleGroup2);
				
				//Create button row holder
				HBox row1 = new HBox(90);
				row1.getChildren().addAll(b1,b2,b3,b4,b5,b6,b7);
				row1.setLayoutX(230);
				row1.setLayoutY(275);
				
				//Create buttons for row c
				RadioButton c1 = new RadioButton();
				RadioButton c2 = new RadioButton();
				RadioButton c3 = new RadioButton();
				RadioButton c4 = new RadioButton();
				RadioButton c5 = new RadioButton();
				RadioButton c6 = new RadioButton();
				RadioButton c7 = new RadioButton();

				ToggleGroup toggleGroup3 = new ToggleGroup();
				c1.setToggleGroup(toggleGroup3);
				c2.setToggleGroup(toggleGroup3);
				c3.setToggleGroup(toggleGroup3);
				c4.setToggleGroup(toggleGroup3);
				c5.setToggleGroup(toggleGroup3);
				c6.setToggleGroup(toggleGroup3);
				c7.setToggleGroup(toggleGroup3);
				
				//Create button row holder
				HBox row3 = new HBox(90);
				row3.getChildren().addAll(c1,c2,c3,c4,c5,c6,c7);
				row3.setLayoutX(230);
				row3.setLayoutY(325);
				
				//Create buttons for row d
				RadioButton d1 = new RadioButton();
				RadioButton d2 = new RadioButton();
				RadioButton d3 = new RadioButton();
				RadioButton d4 = new RadioButton();
				RadioButton d5 = new RadioButton();
				RadioButton d6 = new RadioButton();
				RadioButton d7 = new RadioButton();

				ToggleGroup toggleGroup4 = new ToggleGroup();
				d1.setToggleGroup(toggleGroup4);
				d2.setToggleGroup(toggleGroup4);
				d3.setToggleGroup(toggleGroup4);
				d4.setToggleGroup(toggleGroup4);
				d5.setToggleGroup(toggleGroup4);
				d6.setToggleGroup(toggleGroup4);
				d7.setToggleGroup(toggleGroup4);

				//Create button row holder
				HBox row4 = new HBox(90);
				row4.getChildren().addAll(d1,d2,d3,d4,d5,d6,d7);
				row4.setLayoutX(230);
				row4.setLayoutY(375);
				
				//Create buttons for row e
				RadioButton e1 = new RadioButton();
				RadioButton e2 = new RadioButton();
				RadioButton e3 = new RadioButton();
				RadioButton e4 = new RadioButton();
				RadioButton e5 = new RadioButton();
				RadioButton e6 = new RadioButton();
				RadioButton e7 = new RadioButton();

				ToggleGroup toggleGroup5 = new ToggleGroup();
				e1.setToggleGroup(toggleGroup5);
				e2.setToggleGroup(toggleGroup5);
				e3.setToggleGroup(toggleGroup5);
				e4.setToggleGroup(toggleGroup5);
				e5.setToggleGroup(toggleGroup5);
				e6.setToggleGroup(toggleGroup5);
				e7.setToggleGroup(toggleGroup5);

				//Create button row holder
				HBox row5 = new HBox(90);
				row5.getChildren().addAll(e1,e2,e3,e4,e5,e6,e7);
				row5.setLayoutX(230);
				row5.setLayoutY(425);
				
				//Create buttons for row f
				RadioButton f1 = new RadioButton();
				RadioButton f2 = new RadioButton();
				RadioButton f3 = new RadioButton();
				RadioButton f4 = new RadioButton();
				RadioButton f5 = new RadioButton();
				RadioButton f6 = new RadioButton();
				RadioButton f7 = new RadioButton();

				ToggleGroup toggleGroup6 = new ToggleGroup();
				f1.setToggleGroup(toggleGroup6);
				f2.setToggleGroup(toggleGroup6);
				f3.setToggleGroup(toggleGroup6);
				f4.setToggleGroup(toggleGroup6);
				f5.setToggleGroup(toggleGroup6);
				f6.setToggleGroup(toggleGroup6);
				f7.setToggleGroup(toggleGroup6);

				//Create button row holder
				HBox row6 = new HBox(90);
				row6.getChildren().addAll(f1,f2,f3,f4,f5,f6,f7);
				row6.setLayoutX(230);
				row6.setLayoutY(475);
				
				//Create buttons for row g
				RadioButton g1 = new RadioButton();
				RadioButton g2 = new RadioButton();
				RadioButton g3 = new RadioButton();
				RadioButton g4 = new RadioButton();
				RadioButton g5 = new RadioButton();
				RadioButton g6 = new RadioButton();
				RadioButton g7 = new RadioButton();

				ToggleGroup toggleGroup7 = new ToggleGroup();
				g1.setToggleGroup(toggleGroup7);
				g2.setToggleGroup(toggleGroup7);
				g3.setToggleGroup(toggleGroup7);
				g4.setToggleGroup(toggleGroup7);
				g5.setToggleGroup(toggleGroup7);
				g6.setToggleGroup(toggleGroup7);
				g7.setToggleGroup(toggleGroup7);

				//Create button row holder
				HBox row7 = new HBox(90);
				row7.getChildren().addAll(g1,g2,g3,g4,g5,g6,g7);
				row7.setLayoutX(230);
				row7.setLayoutY(525);
				
				//Create buttons for row h
				RadioButton h1 = new RadioButton();
				RadioButton h2 = new RadioButton();
				RadioButton h3 = new RadioButton();
				RadioButton h4 = new RadioButton();
				RadioButton h5 = new RadioButton();
				RadioButton h6 = new RadioButton();
				RadioButton h7 = new RadioButton();

				ToggleGroup toggleGroup8 = new ToggleGroup();
				h1.setToggleGroup(toggleGroup8);
				h2.setToggleGroup(toggleGroup8);
				h3.setToggleGroup(toggleGroup8);
				h4.setToggleGroup(toggleGroup8);
				h5.setToggleGroup(toggleGroup8);
				h6.setToggleGroup(toggleGroup8);
				h7.setToggleGroup(toggleGroup8);

				//Create button row holder
				HBox row8 = new HBox(90);
				row8.getChildren().addAll(h1,h2,h3,h4,h5,h6,h7);
				row8.setLayoutX(230);
				row8.setLayoutY(575);
				
				//Create buttons for row i
				RadioButton i1 = new RadioButton();
				RadioButton i2 = new RadioButton();
				RadioButton i3 = new RadioButton();
				RadioButton i4 = new RadioButton();
				RadioButton i5 = new RadioButton();
				RadioButton i6 = new RadioButton();
				RadioButton i7 = new RadioButton();

				ToggleGroup toggleGroup9 = new ToggleGroup();
				i1.setToggleGroup(toggleGroup9);
				i2.setToggleGroup(toggleGroup9);
				i3.setToggleGroup(toggleGroup9);
				i4.setToggleGroup(toggleGroup9);
				i5.setToggleGroup(toggleGroup9);
				i6.setToggleGroup(toggleGroup9);
				i7.setToggleGroup(toggleGroup9);

				//Create button row holder
				HBox row9 = new HBox(90);
				row9.getChildren().addAll(i1,i2,i3,i4,i5,i6,i7);
				row9.setLayoutX(230);
				row9.setLayoutY(625);
				
				//Create buttons for row g
				RadioButton j1 = new RadioButton();
				RadioButton j2 = new RadioButton();
				RadioButton j3 = new RadioButton();
				RadioButton j4 = new RadioButton();
				RadioButton j5 = new RadioButton();
				RadioButton j6 = new RadioButton();
				RadioButton j7 = new RadioButton();

				ToggleGroup toggleGroup10 = new ToggleGroup();
				j1.setToggleGroup(toggleGroup10);
				j2.setToggleGroup(toggleGroup10);
				j3.setToggleGroup(toggleGroup10);
				j4.setToggleGroup(toggleGroup10);
				j5.setToggleGroup(toggleGroup10);
				j6.setToggleGroup(toggleGroup10);
				j7.setToggleGroup(toggleGroup10);

				//Create button row holder
				HBox row10 = new HBox(90);
				row10.getChildren().addAll(j1,j2,j3,j4,j5,j6,j7);
				row10.setLayoutX(230);
				row10.setLayoutY(675);
				
				//Create left-hand labels
				Text extroverted = new Text("Extroverted, enthusiastic"); 
				Text critical = new Text("Critical, quarrelsome"); 
				Text dependable = new Text("Dependable, self-disciplined"); 
				Text anxious = new Text("Anxious, easily upset"); 
				Text open = new Text("Open to expeiences, complex"); 
				Text reserved = new Text("Reserved, quiet"); 
				Text sympathetic = new Text("Sympathetic, warm"); 
				Text disorganized = new Text("Disorganized, careless"); 
				Text calm = new Text("Calm, emotionally stable"); 
				Text conventional = new Text("Conventional, uncreative"); 
				
				VBox personalities = new VBox(34);
				personalities.getChildren().addAll(extroverted,critical,
						dependable, anxious,open,reserved,sympathetic,disorganized,
						calm,conventional);
				personalities.setLayoutX(30);
				personalities.setLayoutY(225);
				
				
				//Create continue button with functionality and styling
				Button results = new Button("Save and Continue to Results");
				results.setWrapText(true);
				results.setMinWidth(200);
				HBox resultsButton = new HBox();
				resultsButton.getChildren().add(results);
				resultsButton.setLayoutX(420);
				resultsButton.setLayoutY(730);
				
				//Set button action
				results.setOnAction(e -> {
					
					try {
						//Loops through each personality trait and captures scores from user
						LinkedHashMap<String,ToggleGroup> inputs = new LinkedHashMap<String, ToggleGroup>();
						inputs.put("Extraverted", toggleGroup1);
						inputs.put("Critical", toggleGroup2);
						inputs.put("Dependable", toggleGroup3);
						inputs.put("Anxious", toggleGroup4);
						inputs.put("Open", toggleGroup5);
						inputs.put("Reserved", toggleGroup6);
						inputs.put("Sympathetic", toggleGroup7);
						inputs.put("Disorganized", toggleGroup8);
						inputs.put("Calm", toggleGroup9);
						inputs.put("Conventional", toggleGroup10);
						LinkedHashMap<String,Integer> finalScores = new LinkedHashMap<String,Integer>();
						int counter = 0;
						for(String key : inputs.keySet()) {
							RadioButton item = (RadioButton) inputs.get(key).getSelectedToggle();
							double index = item.getBoundsInParent().getMinX();
							int score;
							if(index < 106) {
								score = 1;
							}
							else if(index < 214) {
								score = 2;
							}
							else if(index < 322) {
								score = 3;
							}
							else if(index < 430) {
								score = 4;
							}
							else if(index < 538) {
								score = 5;
							}
							else if(index < 646) {
								score = 6;
							}
							else {
								score = 7;
							}
							finalScores.put(key,score);
							System.out.println(key + ": " + finalScores.get(key));
							counter++;
						}
					}
					catch(RuntimeException e11) {
						Text error = new Text("Please fill all fields to continue.");
						error.setFont(Font.font("Veranda",15));
						error.setFill(Color.web("#FF1000"));
						HBox errorBox = new HBox();
						errorBox.setMinWidth(300);
						errorBox.setLayoutX(410);
						errorBox.setLayoutY(710);
						errorBox.getChildren().add(error);
						surveyBorderPane.getChildren().add(errorBox);
					}
					
				});
				//Add all boxes to page
				surveyBorderPane.getChildren().addAll(title,instructions,personalities,
						optionBox,row1,row2,row3,row4,row5, row6,row7,row8,row9, row10,
						resultsButton);

		
				return(surveyScene);
	}
	
}
