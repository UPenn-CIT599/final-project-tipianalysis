import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Temporary Runner Class to test ResultsViewer
 */
public class ResultsViewerRunner extends Application {

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


        User user = new User("Tester", 30, "male");

        // Traits Data for Testing
        String[] traitNames = new String[]{"Extraversion", "Agreeableness", "Conscientiousness", "Emotional Stability", "Openness to Experiences"};
        String[] peerComparison = new String[]{"Low", "High", "Average", "Low", "Average"};
        Trait[] traitArray = new Trait[5];

        for(int i = 0;i<5;i++) {
            Trait trait = new Trait(traitNames[i], i, Math.random() * (i + 1), 0, 0, peerComparison[i]);
            traitArray[i]=trait;
        }

        user.setUserScoresAndMetrics(traitArray);

        ResultsViewer resultsViewer = new ResultsViewer(user);
        click.setOnAction(e -> resultsViewer.createStage());
        hbox.getChildren().addAll(click);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
