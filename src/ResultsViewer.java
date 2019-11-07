import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ResultsViewer {


  public void resultsStage() {

    //Create Stage
    Stage primaryStage = new Stage();

    // Great Root Pane
    BorderPane pane = new BorderPane();

    // Add Title to PrimaryStage
    primaryStage.setTitle("TIPI Analysis Results");

    // Create Scene and link it with Root
    // scene can have only one root node
    // If you omit the width and height, the scene will be sized automatically based on the size of
    // the elements contained
    Scene scene = new Scene(pane, 550, 250);

    // Create Export button
    Button ExportBtn = new Button();
    ExportBtn.setText("Export Results");
    ExportBtn.setOnAction(e -> print(primaryStage, pane));

    // Create Exit button
    Button ExitBtn = new Button();
    ExitBtn.setText("Exit");
    ExitBtn.setOnAction(e -> primaryStage.close()); // Platform.exit()

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
    //Construct GridPane Node
      GridPane gpUser = new GridPane();

      //Create Labels for Pane
      Label lblName = new Label("Name");
      Label lblAge = new Label("Age");
      Label lblSex= new Label("Gender");

      //Add Labels to first column
      gpUser.addColumn(0, lblName, lblSex, lblAge);

      //Add UserProfile GridPane to Borderpane on left side
      pane.setLeft(gpUser);



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
    bottomHBox.getChildren().addAll(ExportBtn, ExitBtn);

    // Add hbox to bottom section of root
    pane.setBottom(bottomHBox);

    // Make Scene visible
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  private void print(Stage primarystage, Node node) {

    //    System.out.println("I am exporting");
    PrinterJob printNode = PrinterJob.createPrinterJob();
    if (printNode != null) {
      printNode.showPrintDialog(primarystage);
      printNode.printPage(node);
      printNode.endJob();
    }
  }
}
