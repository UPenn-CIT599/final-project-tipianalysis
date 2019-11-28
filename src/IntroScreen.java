import javafx.application.Platform;
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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
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

	//Stage width
	private int stageX = 800;
	//Stage height
	private int stageY = 800;
	//Instantiate Intro Stage
	private Stage introStage = new Stage();
	//Instantiate User Class
	private User user = new User(null, 0, null);

	/**
	 * Presents the Introduction page to the user when called by the TipiProgram
	 * class. It provides a brief introduction to the user on what he/she can
	 * expect, and then it allows them to continue on to the survey page with 
	 * a quick button click.
	 */
	public Scene start() {
		
	    /**
	     * Create Scene and Border
	     */
		//Create Stage and border
		BorderPane introBorderPane = new BorderPane();
	    Scene scene = new Scene(introBorderPane, stageX, stageY);
		introStage.setScene(scene);
		//set title of stage
		introStage.setTitle("TIPI Analysis Survey");
		introStage.setMaxWidth(800);
		introStage.setMinWidth(800);
		
		/**
		 * Page Title Text
		 */
		// Header UserProfile
		GridPane introGrid = new GridPane();
	    Text title = new Text("TIPI Analyzer");
	    // Change Font of title
	    title.setFont(Font.font("Arial Rounded MT", FontWeight.BOLD, 30));
	    title.setFill(Color.WHITE);
	    introGrid.add(title,0,0);
	    HBox titleBox = new HBox(title);
	    titleBox.setLayoutX(315);
	    titleBox.setLayoutY(20);
	    
	    
	    Text bodyText1 = new Text(
	    		"Welcome to the TIPI Analyzer! TIPI stands for Ten Item "
	    		+ "Personality Inventory. It's a tool used by psychologists "
	    		+ "to define our personalities on a few different scales. "
	    		+ "How we score on these scales can tell us more about our own "
	    		+ "personality traits, and how these traits might be affecting our "
	    		+ "behavior without us even knowing it! "
	    		+ "\n"
	    		+ "\n"
	    		+ "\n"
	    		+ "By learning how your personality might be affecting your behavior, you can "
	    		+ "start to behave more consciously when it comes to certain decision-making "
	    		+ "points in your life. You then may not fall victim to subconscious "
	    		+ "tendencies that you didn't know you had. For example, maybe you'll "
	    		+ "think twice about a particular financial decision if you find out that "
	    		+ "people like you tend to take risky chances when it comes to investing."
	    		+ "\n"
	    		+ "\n"
	    		+ "\n"
	    		+ "On the next page, we'll ask you to answer ten questions where "
		        + "you will need to describe different aspects of your personality "
		        + "on a 7-point scale. Please answer honestly. When you are ready, "
		        + "please fill out the fields below and click \"Continue to Survey\" \n"
		        + " \n"
	    		);
	    
	    
	    bodyText1.setWrappingWidth(550);
	    bodyText1.setFont(Font.font("Veranda",15));
	    bodyText1.setTextAlignment(TextAlignment.CENTER);
	    
	    HBox bodyBox1 = new HBox();
	    bodyBox1.getChildren().add(bodyText1);
	    bodyBox1.setAlignment(Pos.CENTER);
	    bodyBox1.setLayoutX(400);
	    bodyBox1.setLayoutY(320);
	    bodyBox1.setBackground(new Background(new BackgroundFill(Color.DEEPPINK,null,null)));
	    
	    
	    introBorderPane.getChildren().add(bodyBox1);
	    
	    TextField nameField = new TextField();
	    nameField.setMinWidth(150);
	    
	    HBox textBox = new HBox();
	    textBox.getChildren().addAll(nameField);
	    textBox.setLayoutX(320);
	    textBox.setLayoutY(520);
	    textBox.setMinWidth(800);
	    
	    RadioButton male = new RadioButton("Male ");
	    RadioButton female = new RadioButton("Female ");
	    male.setMinWidth(80);
	    female.setMinWidth(80);
	    
	    ToggleGroup tg1 = new ToggleGroup();
	    male.setToggleGroup(tg1);
	    female.setToggleGroup(tg1);
	    
	    HBox genderBox = new HBox(10);
	    genderBox.setLayoutX(320);
	    genderBox.setLayoutY(580);
	    genderBox.getChildren().addAll(male,female);
	    
	    TextField ageField = new TextField();
	    ageField.setMinWidth(150);
	    
	    HBox ageBox = new HBox(10);
	    ageBox.getChildren().addAll(ageField);
	    ageBox.setLayoutX(320);
	    ageBox.setLayoutY(640);
	    ageBox.setMinWidth(800);
	    
	    Text nameLabel = new Text("First Name");
	    Text age = new Text("Age");
	    Text gender = new Text("Sex");
	    gender.setFont(Font.font("Veranda",14));
	    age.setFont(Font.font("Veranda",14));
	    nameLabel.setFont(Font.font("Veranda",14));

	    VBox labels = new VBox(42);
	    labels.getChildren().addAll(nameLabel,gender,age);
	    labels.setLayoutX(390);
	    labels.setLayoutY(565);
	    labels.setAlignment(Pos.CENTER);
	    
		/**
		 * Button functionality and placement
		 */
		//Add a "Continue to Survey" button
		Button btn = new Button("Continue to Survey");
		btn.setPrefWidth(150);
		//Make button actionable - send user to survey upon clicking and save their data
		btn.setOnAction(e -> {
		
			try {
				String nameInput = nameField.getText();
			    int ageInput = Integer.parseInt(ageField.getText());
			    RadioButton genderSelection = (RadioButton) tg1.getSelectedToggle();
			    String genderInput = genderSelection.getText();
			    user.setName(nameInput);
			    user.setAge(ageInput);
			    if(user.getAge() <= 0) {
			    	throw new RuntimeException("Negative Age");
			    }
			    user.setSex(genderInput);
				SurveyPage surveyPage = new SurveyPage();
				introStage.setScene(surveyPage.showSurveyPage(user,introStage));
				
			}
			catch(RuntimeException e1) {
				Text error = new Text("Please fill all fields to continue.");
				error.setFont(Font.font("Veranda",15));
				error.setFill(Color.web("#FF1000"));
				HBox errorBox = new HBox();
				errorBox.setMinWidth(300);
				errorBox.setLayoutX(290);
				errorBox.setLayoutY(650);
				errorBox.getChildren().add(error);
				introBorderPane.getChildren().add(errorBox);
			}
		    	
		}
			
		); 
		btn.setMinWidth(160);
		HBox buttonHolder = new HBox();
		buttonHolder.setLayoutX(315);
		buttonHolder.setLayoutY(700);
		//Sets padding from bottom
		buttonHolder.getChildren().add(btn);
		
		//Text Rectangle
		Rectangle rect = new Rectangle(640,650);
		rect.setFill(Color.rgb(221,255,255));
		rect.setStroke(Color.rgb(151,255,255));;
		rect.setStrokeWidth(1);
		rect.setArcHeight(35.0);
		rect.setArcWidth(25.0);
		    
		Group rectangle = new Group();
		rectangle.getChildren().add(rect);
		rectangle.setLayoutX(80);
		rectangle.setLayoutY(110);
		rectangle.setViewOrder(5.0);
		
		//Input Rectangle
		Rectangle inputRect = new Rectangle(490,190);
		inputRect.setFill(Color.rgb(255,255,255));
		inputRect.setStroke(Color.rgb(151,255,255));;
		inputRect.setStrokeWidth(1);
		inputRect.setArcHeight(35.0);
		inputRect.setArcWidth(25.0);
		    
		Group inputRectangle = new Group();
		inputRectangle.getChildren().add(inputRect);
		inputRectangle.setLayoutX(150);
		inputRectangle.setLayoutY(490);
		inputRectangle.setViewOrder(5.0);
		
		
		//Header Gray Box
		Rectangle header = new Rectangle(900,75);
		header.setFill(Color.rgb(59,58,58));
		    
		Group headerGroup = new Group();
		headerGroup.getChildren().add(header);
		headerGroup.setLayoutX(0);
		headerGroup.setLayoutY(0);
		headerGroup.setViewOrder(5.0);
		
		//Gender Image
		Image image = null;
		try {
			image = new Image(new FileInputStream("src/gender.png"), 60, 68.55, true, true);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        ImageView imageView = new ImageView(image);
        
        imageView.setLayoutX(265);
        imageView.setLayoutY(570);
        imageView.setFitHeight(45);
        imageView.setFitWidth(45);
        imageView.setPreserveRatio(true);
        
        Group img = new Group(imageView);
        
        //Name Image
      	Image image2 = null;
      	try {
      		image2 = new Image(new FileInputStream("src/name.png"), 60, 68.55, true, true);
      	} catch (FileNotFoundException e2) {
      		// TODO Auto-generated catch block
      		e2.printStackTrace();
      	}
              
        ImageView imageView2 = new ImageView(image2);
              
        imageView2.setLayoutX(265);
        imageView2.setLayoutY(515);
        imageView2.setFitHeight(40);
        imageView2.setFitWidth(40);
        imageView2.setPreserveRatio(true);
              
        Group img2 = new Group(imageView2);
        
        //Age Image
      	Image image3 = null;
      	try {
      		image3 = new Image(new FileInputStream("src/age.png"), 50, 50, true, true);
      	} catch (FileNotFoundException e3) {
      		// TODO Auto-generated catch block
      		e3.printStackTrace();
      	}
              
        ImageView imageView3 = new ImageView(image3);
              
        imageView3.setLayoutX(263);
        imageView3.setLayoutY(630);
        imageView3.setFitHeight(40);
        imageView3.setFitWidth(40);
        imageView3.setPreserveRatio(true);
              
        Group img3 = new Group(imageView3);
        
        
	    introBorderPane.getChildren().addAll(titleBox,textBox,genderBox,ageBox,
	    		labels,buttonHolder,rectangle,img,img2,img3,headerGroup,inputRectangle);
		
	  
	    introBorderPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
	    
		introStage.setScene(scene);
		
		//Show the window
		introStage.show();
		
		return(scene);
	}

	/**
	 * Returns the intro stage for use in the survey page.
	 * @return
	 */
	public Stage getStage() {
		return introStage;
	}

	/**
	 * Used for getting the user variable that is created in the IntroScreen
	 * @return
	 */
	public User getUser() {
		return user;
	}
	
	
	
}
