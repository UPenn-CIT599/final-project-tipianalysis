import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Mock-up: How to transition to results page
        HBox hbox = new HBox();
        Scene scene = new Scene(hbox);
        //button to open results
        Button click = new Button("Open Results");

        //create user and resutlsviewer object
        User user = new User("Tester", 30, "male");
        ResultsViewer resultsViewer = new ResultsViewer();
        click.setOnAction(e -> resultsViewer.resultsStage());
        hbox.getChildren().addAll(click);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
