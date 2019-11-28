import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Group;
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
	//private Stage survey = new Stage();
	private BorderPane surveyBorderPane = new BorderPane();
    private Scene surveyScene = new Scene(surveyBorderPane, stageX, stageY);
	
	/**
	 * This method manages the structure of the UI for the survey page.
	 */
	public Scene showSurveyPage(User user, Stage primaryStage){

				//Create Stage and border
				Text pageTitle = new Text("Personality Survey");
				pageTitle.setFont(Font.font("Veranda",30));
				pageTitle.setFill(Color.rgb(255,255,255));
				HBox title = new HBox();
				title.getChildren().add(pageTitle);
				title.setLayoutX(375);
				title.setLayoutY(20);
				
				primaryStage.setMaxWidth(1000);
				primaryStage.setMinWidth(1000);
				
				//Header Gray Box
				Rectangle header = new Rectangle(1000,72);
				header.setFill(Color.rgb(59,58,58));
				    
				Group headerGroup = new Group();
				headerGroup.getChildren().add(header);
				headerGroup.setLayoutX(0);
				headerGroup.setLayoutY(0);
				headerGroup.setViewOrder(5.0);
				
				Text description = new Text("Here is a number of personality traits "
						+ "that may or may not apply to you. Please indicae the extent "
						+ "to which you agree or disagree "
						+ "that each one describes you. You should rate the extent "
						+ "to which the pair of traits applies to you, even if one "
						+ "characteristic applies more generally than the other.");
				
				description.setWrappingWidth(800);
				description.setFont(Font.font("Veranda",15));
			    description.setTextAlignment(TextAlignment.CENTER);

				HBox instructions = new HBox(5);
				
				instructions.getChildren().add(description);
				instructions.setLayoutX(100);
				instructions.setLayoutY(92);
	
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
				optionBox.setLayoutX(220);
				optionBox.setLayoutY(175);
				optionBox.setStyle("-fx-background-color: #D3F4FF");
				
				//HBox and ToggleGroup A
				LinkedHashMap<HBox, ToggleGroup> indexForRowA = createButtonBox('a',1,245);
				HBox row1 = getHBox(indexForRowA);
				ToggleGroup toggleGroupA = getToggleGroup(indexForRowA);
				ToggleGroup toggleGroup1 = toggleGroupA;

				//HBox and ToggleGroup B
				LinkedHashMap<HBox, ToggleGroup> indexForRowB = createButtonBox('b',2,295);
				HBox row2 = getHBox(indexForRowB);
				ToggleGroup toggleGroupB = getToggleGroup(indexForRowB);
				ToggleGroup toggleGroup2 = toggleGroupB;
				
				//HBox and ToggleGroup C
				LinkedHashMap<HBox, ToggleGroup> indexForRowC = createButtonBox('c',3,345);
				HBox row3 = getHBox(indexForRowC);
				ToggleGroup toggleGroupC = getToggleGroup(indexForRowC);
				ToggleGroup toggleGroup3 = toggleGroupC;
				
				//HBox and ToggleGroup D
				LinkedHashMap<HBox, ToggleGroup> indexForRowD = createButtonBox('d',4,395);
				HBox row4 = getHBox(indexForRowD);
				ToggleGroup toggleGroupD = getToggleGroup(indexForRowD);
				ToggleGroup toggleGroup4 = toggleGroupD;
			
				//HBox and ToggleGroup E
				LinkedHashMap<HBox, ToggleGroup> indexForRowE = createButtonBox('e',5,445);
				HBox row5 = getHBox(indexForRowE);
				ToggleGroup toggleGroupE = getToggleGroup(indexForRowE);
				ToggleGroup toggleGroup5 = toggleGroupE;
				
				//HBox and ToggleGroup F
				LinkedHashMap<HBox, ToggleGroup> indexForRowF = createButtonBox('f',6,495);
				HBox row6 = getHBox(indexForRowF);
				ToggleGroup toggleGroupF = getToggleGroup(indexForRowF);
				ToggleGroup toggleGroup6 = toggleGroupF;
			
				//HBox and ToggleGroup G
				LinkedHashMap<HBox, ToggleGroup> indexForRowG = createButtonBox('g',7,545);
				HBox row7 = getHBox(indexForRowG);
				ToggleGroup toggleGroupG = getToggleGroup(indexForRowG);
				ToggleGroup toggleGroup7 = toggleGroupG;
	
				//HBox and ToggleGroup H
				LinkedHashMap<HBox, ToggleGroup> indexForRowH = createButtonBox('h',8,595);
				HBox row8 = getHBox(indexForRowH);
				ToggleGroup toggleGroupH = getToggleGroup(indexForRowH);
				ToggleGroup toggleGroup8 = toggleGroupH;
				
				//HBox and ToggleGroup I
				LinkedHashMap<HBox, ToggleGroup> indexForRowI = createButtonBox('i',9,645);
				HBox row9 = getHBox(indexForRowI);
				ToggleGroup toggleGroupI = getToggleGroup(indexForRowI);
				ToggleGroup toggleGroup9 = toggleGroupI;
			
				//HBox and ToggleGroup J
				LinkedHashMap<HBox, ToggleGroup> indexForRowJ = createButtonBox('j',10,695);
				HBox row10 = getHBox(indexForRowJ);
				ToggleGroup toggleGroupJ = getToggleGroup(indexForRowJ);
				ToggleGroup toggleGroup10 = toggleGroupJ;
				
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
				personalities.setLayoutX(48);
				personalities.setLayoutY(245);
				
				
				//Create continue button with functionality and styling
				Button results = new Button("Save and Continue to Results");
				results.setWrapText(true);
				results.setMinWidth(200);
				HBox resultsButton = new HBox();
				resultsButton.getChildren().add(results);
				resultsButton.setLayoutX(420);
				resultsButton.setLayoutY(750);
				
				//Set button action
				results.setOnAction(e -> {
					
					try {
						//Loops through each personality trait and captures scores from user
						LinkedHashMap<String,ToggleGroup> inputs = new LinkedHashMap<String, ToggleGroup>();
						inputs.put("Extroverted", toggleGroup1);
						inputs.put("Critical", toggleGroup2);
						inputs.put("Dependable", toggleGroup3);
						inputs.put("Anxious", toggleGroup4);
						inputs.put("Open", toggleGroup5);
						inputs.put("Reserved", toggleGroup6);
						inputs.put("Sympathetic", toggleGroup7);
						inputs.put("Disorganized", toggleGroup8);
						inputs.put("Calm", toggleGroup9);
						inputs.put("Conventional", toggleGroup10);
						LinkedHashMap<String,Integer> initialScores = new LinkedHashMap<String, Integer>();
						
						initialScores = getInputLinkedHashMap(inputs);
						TipiLogic tipiLog = new TipiLogic(user, initialScores);
						
						user.setUserScoresAndMetrics(tipiLog.runLogic());
						ResultsViewer resultsPage = new ResultsViewer(user);
						primaryStage.setScene(resultsPage.createStage(primaryStage));


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
			
				//Create blue rectangle objects
				Group textRectangle = createRectangle(850,80,70,80,true,true);
				Group rectangle1 = createRectangle(915,50,40,235,false,true);
				Group rectangle2 = createRectangle(915,50,40,330,false,true);
				Group rectangle3 = createRectangle(915,50,40,430,false,true);
				Group rectangle4 = createRectangle(915,50,40,530,false,true);
				Group rectangle5 = createRectangle(915,50,40,630,false,true);
				Group outerBlueRim = createRectangle(915,500,40,233,true,false);
				
				//Add all boxes to page
				surveyBorderPane.getChildren().addAll(title,instructions,personalities,
						optionBox,resultsButton,row1,row2,row3,row4,row5, row6,row7,row8,row9, row10,
						textRectangle,rectangle1,rectangle2,rectangle3,
						rectangle4,rectangle5,outerBlueRim,headerGroup);
				
			    surveyBorderPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

				return(surveyScene);
	}
	/**
	 * Creates a linked hashmap with initial scores inputted by user.
	 * @param inputs A linked hashmap with the name of each trait and the 
	 * toggle group it gets input from.
	 * @return Returns a 10-item linked hashmap with the traints as keys and 
	 * scores as values.
	 */
	public LinkedHashMap<String,Integer> getInputLinkedHashMap(LinkedHashMap<String,ToggleGroup> inputs){
		LinkedHashMap<String,Integer> finalScores = new LinkedHashMap<String,Integer>();
		int counter = 0;
		for(String key : inputs.keySet()) {
			RadioButton item = (RadioButton) inputs.get(key).getSelectedToggle();
			double index = item.getBoundsInParent().getMinX();
			int score;
			if(index < 108) {
				score = 1;
			}
			else if(index < 216) {
				score = 2;
			}
			else if(index < 324) {
				score = 3;
			}
			else if(index < 432) {
				score = 4;
			}
			else if(index < 540) {
				score = 5;
			}
			else if(index < 648) {
				score = 6;
			}
			else {
				score = 7;
			}
			finalScores.put(key,score);
			System.out.println(key + ": " + finalScores.get(key));
			counter++;
		}
		return finalScores;	
	}
	

	/**
	 * Creates HBox elements and toggle groups for rows of radio buttons.
	 * @param letter The row letter we want to assign (a-j)
	 * @param rowIndex The row index (1-10)
	 * @param yVal The y-coordinate layout starting point
	 * @return Returns a linked HashMap with the necessary HBox and ToggleGroup items
	 */
	public LinkedHashMap<HBox,ToggleGroup> createButtonBox(char letter, int rowIndex,int yVal) {
		
		LinkedHashMap<HBox,ToggleGroup> box = new LinkedHashMap<HBox,ToggleGroup>();
		
		//Create buttons for row a
		RadioButton letter1 = new RadioButton();
		RadioButton letter2 = new RadioButton();
		RadioButton letter3 = new RadioButton();
		RadioButton letter4 = new RadioButton();
		RadioButton letter5 = new RadioButton();
		RadioButton letter6 = new RadioButton();
		RadioButton letter7 = new RadioButton();
		
		ToggleGroup toggleGroup_rowIndex = new ToggleGroup();
		letter1.setToggleGroup(toggleGroup_rowIndex);
		letter2.setToggleGroup(toggleGroup_rowIndex);
		letter3.setToggleGroup(toggleGroup_rowIndex);
		letter4.setToggleGroup(toggleGroup_rowIndex);
		letter5.setToggleGroup(toggleGroup_rowIndex);
		letter6.setToggleGroup(toggleGroup_rowIndex);
		letter7.setToggleGroup(toggleGroup_rowIndex);
		
		HBox row_rowIndex = new HBox(90);
		row_rowIndex.getChildren().addAll(letter1,letter2,letter3,
				letter4,letter5,letter6,letter7);
		row_rowIndex.setLayoutX(250);
		row_rowIndex.setLayoutY(yVal);
		
		box.put(row_rowIndex, toggleGroup_rowIndex);
		
		return box;
	}
	
	/**
	 * Returns a formatted HBox from the linked HashMap 
	 * @param boxAndToggle A Linked HashMap with an HBox and Toggle
	 * @return Returns an HBox element.
	 */
	public HBox getHBox(LinkedHashMap<HBox,ToggleGroup> boxAndToggle) {
		HBox row = new HBox();
		for(Object key : boxAndToggle.keySet()) {
			row = (HBox) key;
		}
		
		return row;
	}
	
	/**
	 * Returns toggleGroup from the linked HashMap 
	 * @param boxAndToggle A Linked HashMap with an HBox and Toggle
	 * @return Returns an toggleGroup element.
	 */
	public ToggleGroup getToggleGroup(LinkedHashMap<HBox,ToggleGroup> boxAndToggle) {
		
		ToggleGroup toggleGroup = new ToggleGroup();
		for(Object key : boxAndToggle.keySet()) {
			toggleGroup = (ToggleGroup) boxAndToggle.get(key);
		}
		
		return toggleGroup;	
	}
	
	/**
	 * Creates rectangle boxes with blue fill.
	 * @param dimY Int The width in pixels
	 * @param dimX Int The height in pixels
	 * @param layoutX Int The starting x-coordinate (pixel value)
	 * @param layoutY Int The starting y-coordiante (pixel value)
	 * @param border Boolean value for whether or not to apply a border.
	 * @param fill Boolean indicating if rectangle should have a blue fill color
	 * @return Returns a Group object that holds a rectangle.
	 */
	public Group createRectangle(int dimY, int dimX, int layoutX, int layoutY, boolean border, boolean fill) {
		
		Rectangle rect = new Rectangle(dimY,dimX);
		if(fill == true) {
			rect.setFill(Color.rgb(221,255,255));
			}
		else {
			rect.setFill(Color.TRANSPARENT);
		}
		if(border == true) {
			rect.setStroke(Color.BLUE);
			rect.setStrokeWidth(1);	
		}	
		rect.setArcHeight(30.0);
		rect.setArcWidth(20.0);   
		Group rectangle = new Group();
		rectangle.getChildren().add(rect);
		rectangle.setLayoutX(layoutX);
		rectangle.setLayoutY(layoutY);
		rectangle.setViewOrder(5.0);
		
		return rectangle;
	}
	
	
}
