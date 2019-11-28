import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.print.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.LinkedHashMap;

/**
 * Class responsible to visualize and export results of TIPI questionnaire, includes UserProfile,
 * User Tipi Scores relative to Peer Group as well as a visualization of his results in the form of
 * a Bar Chart
 */
public class ResultsViewer {

    // Instance Variables
    private User user;

    // Constructor
    public ResultsViewer(User user) {
        this.user = user;
    }

    /**
     * Method, creates window/stage to show Users TIPI Profile
     */
    public Scene createResultsScene(Stage introPrimaryStage) {

        // Create Stage
        Stage primaryStage = introPrimaryStage;

        primaryStage.setMinHeight(550);
        primaryStage.setMaxHeight(550);
        primaryStage.setWidth(1000);

        // Create Root Pane / BorderPane
        VBox rootNode = new VBox();

        // Add CSS Style Class for borderpane
        rootNode.getStyleClass().add("vbox");

        // Add Padding to BorderPane - distance to Window Edge
        //  pane.setPadding(new Insets(15, 20, 10, 20));

        // Add Title to PrimaryStage
        primaryStage.setTitle("TIPI Analysis Results");

        // HEADER
        Text header = new Text("TIPI Results");

        // Change Font of title
        header.setFont(new Font(20));

        // Add title to HBox to change padding
        HBox topHBox = new HBox(header);

        // Centrally align header
        topHBox.setAlignment(Pos.CENTER_LEFT);

        // MIDDLE SECTION
        GridPane gpUserStatic = getUserInfo();
        GridPane gpUserTipi = getUserTipiProfile();

        // Module Holding User Info
        VBox userDataWrapper = new VBox(gpUserStatic, gpUserTipi);

        userDataWrapper.setSpacing(10);

        // Module Holding Chart
        HBox chartHBox = createChartModule();

        // Main Container to hold User Profile and chart
        BorderPane pane = new BorderPane();

        pane.setLeft(userDataWrapper);
        pane.setCenter(chartHBox);

        HBox.setHgrow(chartHBox, Priority.ALWAYS);

        // BOTTOMMODULE

        // hbox to hold buttons in bottomPart of Pane in horizontal order
        HBox bottomHBox = new HBox();

        // Create Export button
        Button ExportBtn = new Button();
        ExportBtn.setText("Export Results");
        ExportBtn.setOnAction(e -> print(primaryStage, rootNode));
        // Create Exit Application button
        Button ExitBtn = new Button();
        ExitBtn.setText("Exit Application");
        ExitBtn.setOnAction(e -> Platform.exit());

//        // Create Return Questionnaire button
//        Button ReturnBtn = new Button();
//        ReturnBtn.setText("Return to Questionnaire");
//        ReturnBtn.setOnAction(e -> primaryStage.close());

        // Centrally align buttons
        bottomHBox.setAlignment(Pos.CENTER);
        // Add Spacing between Buttons
        bottomHBox.setSpacing(10);

        // Set Preferred Width for Buttons and Min. Width
        ExportBtn.setPrefWidth(150);
//        ReturnBtn.setPrefWidth(150);
        ExitBtn.setPrefWidth(150);

        // Add Buttons to hbox node
        bottomHBox.getChildren().addAll(ExportBtn, ExitBtn);

        // Visual Separator
        Separator linetop = new Separator();
        Separator linebottom = new Separator();

        // Add all children to root note
        rootNode.getChildren().addAll(topHBox, linetop, pane, linebottom, bottomHBox);

        // Create Scene and link it with Root scene can have only one root node
        // If you omit the width and height, the scene will be sized automatically based on the size of
        // the elements contained
        Scene scene = new Scene(rootNode);

        // Add StyleSheet. Get current styles and overwrite/ with ones specified
        scene.getStylesheets().add(getClass().getResource("styling.css").toExternalForm());

        // Make Scene visible
        primaryStage.setScene(scene);
        //primaryStage.show();
		return scene;
    }

    /**
     * Helper Method, Allows user to export/print current view of stage
     *
     * @param primarystage from which stage printerdialog shall be triggered
     * @param node         node which shall be printed
     */
    private void print(Stage primarystage, Node node) {

        //    System.out.println("I am exporting");
        PrinterJob printNode = PrinterJob.createPrinterJob();
        if (printNode != null) {
            printNode.showPrintDialog(primarystage);

            // get picked printer
            Printer printer = printNode.getPrinter();

            // Customize print settings
            JobSettings jobSettings = printNode.getJobSettings();
            PageLayout pageLayout =
                    printer.createPageLayout(
                            Paper.A4, PageOrientation.REVERSE_LANDSCAPE, Printer.MarginType.EQUAL);
            jobSettings.setPageLayout(pageLayout);


            //store primary stage width values to restore them
            double width = primarystage.getWidth();
            double height = primarystage.getHeight();

            // resize stage to printing size
            double pw = pageLayout.getPrintableWidth();
            double ph = pageLayout.getPrintableHeight();
            primarystage.setWidth(pw);
            primarystage.setHeight(ph);


            // check if printing was successful
            boolean success = printNode.printPage(node);


            // If printing was successful inform user accordingly
            if (success) {
                //set primarystage to previous size
                primarystage.setWidth(width);
                primarystage.setHeight(height);

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

    /**
     * Private method: Creates additional stage for pop up window to contain definitions of TipiTraits
     */
    private void tipiDefinitions() {
        // Stage
        Stage stage = new Stage();

        stage.setMinWidth(700);
        stage.setMinHeight(200);

        // Trait One
        Label lblExtraVersion = new Label("Extraversion");
        Text txtExtraVersion =
                new Text(
                        "The tendency to be outgoing and high in social energy. Characterized by breadth of activities (as opposed to depth), " +
                                "surgency from external activity/situations, and energy creation from external means. " +
                                "The trait is marked by pronounced engagement with the external world. " +
                                "Extraverts enjoy interacting with people, and are often perceived as full of energy. " +
                                "They tend to be enthusiastic, action-oriented individuals. They possess high group visibility, " +
                                "like to talk, and assert themselves. Extraverted people may appear more dominant in social settings, " +
                                "as opposed to introverted people in this setting.\n"
                                + "\n"
                                + "Introverts have lower social engagement and energy levels than extraverts. " +
                                "They tend to seem quiet, low-key, deliberate, and less involved in the social world. " +
                                "Their lack of social involvement should not be interpreted as shyness or depression; " +
                                "instead they are more independent of their social world than extraverts. " +
                                "Introverts need less stimulation, and more time alone than extraverts. " +
                                "This does not mean that they are unfriendly or antisocial; rather, they are reserved in social " +
                                "situations.");
        txtExtraVersion.setWrappingWidth(600);

        // Trait One
        Label lblEmotion = new Label("Emotional stability");
        Text txtEmotion =
                new Text(
                        "The tendency to be even in terms of emotions and to not experience much. Those low in emotional " +
                                "stability are generally prone to anxiety, sadness, worry, and low self-esteem. " +
                                "They may be temperamental or easily angered, and they tend to be self-conscious and unsure of themselves.\n"
                                + "\n"
                                + "Individuals who score on the high end are more likely to feel confident, sure of " +
                                "themselves, and adventurous. They may also be brave and unencumbered by worry or self-doubt. "
                                + "dispositional anxiety or sadness.");
        txtEmotion.setWrappingWidth(600);

        // Trait One
        Label lblOpenness = new Label("Openness");
        Text txtOpenness =
                new Text(
                        "The tendency to be interested in new ideas, people, art, and pretty much anything. " +
                                "People who are open to experience are intellectually curious, open to emotion, " +
                                "sensitive to beauty and willing to try new things. They tend to be, when compared to closed people, " +
                                "more creative and more aware of their feelings. They are also more likely to hold unconventional beliefs. " +
                                "High openness can be perceived as unpredictability or lack of focus, " +
                                "and more likely to engage in risky behaviour or drug taking. Moreover, " +
                                "individuals with high openness are said to pursue self-actualization specifically by seeking out intense, " +
                                "euphoric experiences. Conversely, those with low openness seek to gain fulfillment through perseverance and " +
                                "are characterized as pragmatic and data-driven—sometimes even perceived to be dogmatic and closed-minded");

        txtOpenness.setWrappingWidth(600);

        // Trait One
        Label lblAgree = new Label("Agreeableness");
        Text txtAgree =
                new Text(
                        "The tendency to agree with people and to be generally kind in dealing with others. " +
                                "Agreeable individuals value getting along with others. " +
                                "They are generally considerate, kind, generous, trusting and trustworthy, helpful, " +
                                "and willing to compromise their interests with others." +
                                " Agreeable people also have an optimistic view of human nature.\n"
                                + "\n"
                                + "Disagreeable individuals place self-interest above getting along with others. " +
                                "They are generally unconcerned with others' well-being, " +
                                "and are less likely to extend themselves for other people. " +
                                "Sometimes their skepticism about others' motives causes them to be suspicious, " +
                                "unfriendly, and uncooperative. " +
                                "Low agreeableness personalities are often competitive or challenging people, " +
                                "which can be seen as argumentative or untrustworthy");
        txtAgree.setWrappingWidth(600);

        // Trait One
        Label lblConscious = new Label("Conscientiousness");
        Text txtConscious =
                new Text("The tendency to be meticulous and organized in all aspects of one’s life, display self-discipline, " +
                        "act dutifully, and strive for achievement against measures or outside expectations. It is related to the way in which people control, " +
                        "regulate, and direct their impulses. High conscientiousness is often perceived as being stubborn and focused. " +
                        "Low conscientiousness is associated with flexibility and spontaneity, but can also appear as sloppiness and lack of reliability." +
                        " High scores on conscientiousness indicate a preference for planned rather than spontaneous behavior.");
        txtConscious.setWrappingWidth(600);

        GridPane gp = new GridPane();
        gp.addRow(0, lblExtraVersion, txtExtraVersion);
        gp.addRow(1, lblAgree, txtAgree);
        gp.addRow(2, lblConscious, txtConscious);
        gp.addRow(3, lblEmotion, txtEmotion);
        gp.addRow(4, lblOpenness, txtOpenness);


        // Add space between gp nodes
        gp.setHgap(20);
        gp.setVgap(10);

        // Align Text on Top in Grid Panes
        for (int i = 0; i < 5; i++) {

            RowConstraints rConstraint = new RowConstraints();
            rConstraint.setValignment(VPos.TOP);

            gp.getRowConstraints().add(rConstraint);
        }

        // Add StyleSheet. Get current styles and overwrite/ with ones specified
        // toExternalForm() call. Scene expects stylesheet contents as a string, not the file, so we
        // need to provide the contents of our stylesheet instead.
        gp.getStylesheets().add(getClass().getResource("styling.css").toExternalForm());

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setMinWidth(100);
        //    ColumnConstraints col2 = new ColumnConstraints();
        //    col2.setMinWidth(400);
        gp.getColumnConstraints().addAll(col1);

        // Add Padding to box - distance to Window Edge
        gp.setPadding(new Insets(20, 20, 20, 20));

        //    // Set Background of scene
        //    BackgroundFill myBF =
        //        new BackgroundFill(Color.WHITE, new CornerRadii(1), new Insets(0.0));
        //
        //    box.setBackground(new Background(myBF));

        Scene scene = new Scene(gp);
        stage.setTitle("TIPI Traits Definition and Implications - Source: Wikipedia");
        stage.setScene(scene);
        //set window icon for stage
        Image brain = new Image(getClass().getResourceAsStream("brain.png"));
        stage.getIcons().add(brain);

        stage.show();
    }

    private GridPane getUserInfo() {

        // Part On of User Summary - Static Info
        GridPane gpUser = new GridPane();

        // Add styleclass for gridpane
        gpUser.getStyleClass().add("gridpane");

        // Header UserProfile
        Text userHeader = new Text("User Profile");

        // Add styleclass for header
        userHeader.getStyleClass().add("sectionHeader");

        // Change Font of title
        //    userHeader.setFont(Font.font(null, FontWeight.BOLD, 15));

        // Header spans over two columns
        gpUser.setColumnSpan(userHeader, 2);

        // Add Padding
        // gpUser.setPadding(new Insets(10));

        // Add Padding between Rows and Columns
        //    gpUser.setHgap(10);
        //    gpUser.setVgap(10);

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
        gpUser.addColumn(1, txtName, txtSex, txtAge);

        //    // Add additional margin
        //
        //    gpUser.setPadding(new Insets(10, 0, 0, 0));

        return gpUser;
    }

    private GridPane getUserTipiProfile() {

        // Part On of User Profile - Static Info
        GridPane gpUserTipi = new GridPane();

        // Add styleclass for gridpane
        gpUserTipi.getStyleClass().add("gridpane");

        // Header UserProfile
        Text tipiHeader = new Text("User TIPI Profile");

        // Add styleclass for header
        tipiHeader.getStyleClass().add("sectionHeader");

        //    // Change Font of title
        //    tipiHeader.setFont(Font.font(null, FontWeight.BOLD, 15));

        // Info Icon - Image has to be in src folder
        Image infoImg = new Image(getClass().getResourceAsStream("info.png"), 20, 20, true, true);

        // Make infoIcon a Button
        Button info = new Button("", new ImageView(infoImg));
        info.setOnAction(e -> tipiDefinitions());

        // make background of button transparent
        info.setStyle("-fx-background-color: transparent");

        // Add Shadow to Info Button on mouse over
        DropShadow shadow = new DropShadow();
        info.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> info.setEffect(shadow));
        info.addEventHandler(MouseEvent.MOUSE_EXITED, e -> info.setEffect(null));

        // Hbox to hold Header and Info Icon
        HBox headerBox = new HBox(tipiHeader, info);

        // Align Header
        headerBox.setAlignment(Pos.CENTER_LEFT);

        // headerBox to span over two columns
        gpUserTipi.setColumnSpan(headerBox, 2);

        //    // Add Padding
        //    gpUserTipi.setPadding(new Insets(10));

        //    // Add Padding between Rows and Columns
        //    gpUserTipi.setHgap(10);
        //    gpUserTipi.setVgap(10);


        // counter to position labels, start at one as first row (index 0) is the header
        int i = 1;

        // Create Labels and Text for Pane and add them the gridpane
        for (Trait trait : user.getUserScoresAndMetrics()) {
            //Label for Trait
            Label lblTrait = new Label(trait.getName() + ":");
            // lblTrait.setTooltip(new Tooltip("Hello World"));
            //Text - Performance relative to peers
            Text txtTrait = new Text(trait.getComparisonToPeers());
            gpUserTipi.addRow(i, lblTrait, txtTrait);
            i++;
        }

        // Add User Profile HeaderBox to row 0
        gpUserTipi.addRow(0, headerBox);

        return gpUserTipi;
    }

    private HBox createChartModule() {

        // Create TipiChart object
        TipiChart chart = new TipiChart();

        // Create BarChart
        BarChart barChart = chart.createBarChart(user.getUserScoresAndMetrics());

        // Instruct to Chart to grow with window
        HBox.setHgrow(barChart, Priority.ALWAYS);

        // Create and add chart to HBox
        HBox box = new HBox(barChart);

        return box;
    }
}
