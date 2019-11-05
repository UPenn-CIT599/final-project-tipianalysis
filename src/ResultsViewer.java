import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ResultsViewer extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

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
    ExportBtn.setOnAction(e -> print());

    // Create Exit button
    Button ExitBtn = new Button();
    ExitBtn.setText("Exit");
    ExitBtn.setOnAction(e -> Platform.exit());

    // Add button to scene
    // pane.getChildren().add(ExportBtn);

    // hbox to hold buttons in bottomPart of Pane
    HBox hbox = new HBox();
    // Centrally align buttons
    hbox.setAlignment(Pos.CENTER);
    // Add Spacing around Buttons vs. paneBorder
    hbox.setPadding(new Insets(10));
    // Add Spacing between Buttons
    hbox.setSpacing(10);
    // Add Buttons to hbox node
    hbox.getChildren().addAll(ExportBtn, ExitBtn);

    // Add hbox
    pane.setBottom(hbox);

    // Make Scene visible
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void print() {

    System.out.println("I am exporting");
  }
}
