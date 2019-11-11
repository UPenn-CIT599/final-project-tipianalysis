import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
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

import java.util.HashMap;

/** Class responsible to visualize results of TIPI questionnaire */
public class ResultsViewer {

  /** Method, creates window/stage with showing user outcome of TIPI Questionnaire */
  public void createStage(User user) {

    // Create Stage
    Stage primaryStage = new Stage();

    // Create Root Pane / BorderPane
    BorderPane pane = new BorderPane();

    //Add Padding to BorderPane - distance to Window Edge
      pane.setPadding(new Insets(15, 20, 10, 20));

    // Add Title to PrimaryStage
    primaryStage.setTitle("TIPI Analysis Results");

    // Create Scene and link it with Root
    // scene can have only one root node
    // If you omit the width and height, the scene will be sized automatically based on the size of
    // the elements contained
    Scene scene = new Scene(pane);

      //Set Background of scene
      BackgroundFill myBF = new BackgroundFill(Color.WHITE, new CornerRadii(1),
              new Insets(0.0,0.0,0.0,0.0));


      pane.setBackground(new Background(myBF));

    // Create Export button
    Button ExportBtn = new Button();
    ExportBtn.setText("Export Results");
    ExportBtn.setOnAction(e -> print(primaryStage, pane));

    // Create Exit Application button
    Button ExitBtn = new Button();
    ExitBtn.setText("Exit Application");
    ExitBtn.setOnAction(e -> Platform.exit());

    // Create Return Questionnaire button
    Button ReturnBtn = new Button();
    ReturnBtn.setText("Return to Questionnaire");
    ReturnBtn.setOnAction(e -> primaryStage.close());

    // TOPBORDER: Header
    Text header = new Text("TIPI Results");
    //    //Title centrally aligned
    //    pane.setAlignment(header,Pos.CENTER);
    // Change Font of title
    header.setFont(new Font(20));
    // Add title to HBox to change padding
    HBox topHBox = new HBox(header);
    // Add padding to header
    topHBox.setPadding(new Insets(10));
    // Centrally align header
    topHBox.setAlignment(Pos.CENTER);
    // Add hBox with header
    pane.setTop(topHBox);

    // LEFTBORDER: User Profile

    // Part On of User Profile - Static Info
    GridPane gpUser = new GridPane();

    // Header UserProfile
    Text userHeader = new Text("User Profile");
    // Change Font of title
    userHeader.setFont(Font.font(null, FontWeight.BOLD, 15));
    gpUser.setColumnSpan(userHeader, 2);

    // Add Padding
    gpUser.setPadding(new Insets(10));

    // Add Padding between Rows and Columns
    gpUser.setHgap(10);
    gpUser.setVgap(10);

    // Create Labels for Pane
    Label lblName = new Label("Name:");
    Label lblAge = new Label("Age:");
    Label lblSex = new Label("Gender:");

    // Create Text for Labels
    Text txtName = new Text(user.getName());
    Text txtAge = new Text(String.valueOf(user.getAge()));
    Text txtSex = new Text(user.getSex());

    // Add User Profile Header to row 0
    gpUser.addRow(0, userHeader);

    // Add Labels to first column
    gpUser.addColumn(0, lblName, lblSex, lblAge);

    // Add Text to second column
    gpUser.addColumn(1, txtName, txtAge, txtSex);

    // Add UserProfile GridPane to Borderpane on left side
    pane.setLeft(gpUser);

    // Part On of User Profile - Static Info
    GridPane gpUserTipi = new GridPane();

    // Header UserProfile
    Text tipiHeader = new Text("User TIPI Profile");
    // Change Font of title
    tipiHeader.setFont(Font.font(null, FontWeight.BOLD, 15));
    gpUserTipi.setColumnSpan(tipiHeader, 2);

    // Add Padding
    gpUserTipi.setPadding(new Insets(10));

    // Add Padding between Rows and Columns
    gpUserTipi.setHgap(10);
    gpUserTipi.setVgap(10);

    // TO BE REPLACED WITH ACTUAL HASHMAP - PLACEHOLDER

    HashMap<String, String> userTraitsRelative =
        new HashMap<String, String>() {
          {
            put("Extraversion", "Average");
            put("Agreeableness", "Below Average");
            put("Conscientiousness", "Above Average");
            put("Emotional Stability", "Above Average");
            put("Openness", "Average");
          }
        };

    //counter to position labels, start at one as first row header
    int i=1;

    // Create Labels and Text for Pane and add them the gridpane
    for (String trait : userTraitsRelative.keySet()) {

      Label lblTrait = new Label(trait+":");
      lblTrait.setTooltip(new Tooltip("Hello World"));
      Text txtTrait = new Text(userTraitsRelative.get(trait));
      gpUserTipi.addRow(i,lblTrait,txtTrait);
      i++;
    }

    // Add User Profile Header to row 0
    gpUserTipi.addRow(0, tipiHeader);


    // Add Part I and II/GridPanes to VBox
    VBox userDataWrapper = new VBox(gpUser, gpUserTipi);

    // Add UserProfile vBox to Borderpane on left side
    pane.setLeft(userDataWrapper);


    // RightBORDER: Create Personality traits Tiles
    VBox traitsBox = new VBox();

    // Add Spacing
    traitsBox.setSpacing(10);

    // preferd width of vBox
    traitsBox.setPrefWidth(100);

    // Personality Buttons
    Label l = new Label("test balblasdjf sfjs f");
    l.setWrapText(true);
    Rectangle r = new Rectangle(100, 50);
    r.setFill(Color.LIGHTGRAY);
    Tooltip.install(r, new Tooltip("This is a test"));
    StackPane s = new StackPane(r, l);

    Button extraVersion = new Button("Extraversion");
    Button agree = new Button("Agreeableness");
    Button conscience = new Button("Conscientiousness");
    Button stability = new Button("Emotional Stability");
    Button experience = new Button("Openness to Experiences");

    traitsBox.getChildren().addAll(s, extraVersion, agree, conscience, stability, experience);

    pane.setRight(traitsBox);


    // CentralBorder: To Hold BarChart
    TipiChart chart = new TipiChart();

    //HashMaps for testing:
    HashMap<String, Integer> userScore =
            new HashMap<String, Integer>() {
              {
                put("Extraversion", 1);
                put("Agreeableness", 2);
                put("Conscientiousness", 3);
                put("Emotional Stability", 4);
                put("Openness", 5);
              }
            };

    HashMap<String, Integer> bmScore =
            new HashMap<String, Integer>() {
              {
                put("Extraversion", 1);
                put("Agreeableness", 2);
                put("Conscientiousness", 3);
                put("Emotional Stability", 4);
                put("Openness", 5);
              }
            };

    BarChart barChart = chart.createBarChart(userScore, bmScore);

    //Add Chart to center pane
    pane.setCenter(barChart);

    // BOTTOMBORDER: Buttons to exit application and print screen
    // hbox to hold buttons in bottomPart of Pane in horizontal order
    HBox bottomHBox = new HBox();
    // Centrally align buttons
    bottomHBox.setAlignment(Pos.CENTER);
    // Add Spacing around Buttons vs. paneBorder
    bottomHBox.setPadding(new Insets(10));
    // Add Spacing between Buttons
    bottomHBox.setSpacing(10);
    // Add Buttons to hbox node
    bottomHBox.getChildren().addAll(ExportBtn, ReturnBtn, ExitBtn);

    // Add hbox to bottom section of root
    pane.setBottom(bottomHBox);

    // Make Scene visible
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Helper Method, Allows user to export/print current view of stage
   *
   * @param primarystage from which stage printerdialog shall be triggered
   * @param node node which shall be printed
   */
  private void print(Stage primarystage, Node node) {

    //    System.out.println("I am exporting");
    PrinterJob printNode = PrinterJob.createPrinterJob();
    if (printNode != null) {
      printNode.showPrintDialog(primarystage);
      boolean success = printNode.printPage(node);
      if (success) {

        // Create Info Box: confirming printing
        Alert printAlert = new Alert(Alert.AlertType.INFORMATION);
        printAlert.setTitle("Print Status");
        // now header inside infobox
        printAlert.setHeaderText(null);
        printAlert.setContentText("Your Results have been exported successfully.");
        printAlert.showAndWait();
        printNode.endJob();
      }
    }
  }
}
