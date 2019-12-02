import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.print.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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

        introPrimaryStage.setMinHeight(500);
        introPrimaryStage.setMaxHeight(800);
        introPrimaryStage.setWidth(1000);

        // Create Root Pane / BorderPane
        VBox rootNode = new VBox();

        // Add CSS Style Class for borderpane
        rootNode.getStyleClass().add("vbox");

        // Add Title to PrimaryStage
        introPrimaryStage.setTitle("TIPI Analysis Results");

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
        ExportBtn.setOnAction(e -> print(introPrimaryStage, rootNode));
        // Create Exit Application button
        Button ExitBtn = new Button();
        ExitBtn.setText("Exit Application");
        ExitBtn.setOnAction(e -> Platform.exit());

        // Centrally align buttons
        bottomHBox.setAlignment(Pos.CENTER);
        // Add Spacing between Buttons
        bottomHBox.setSpacing(10);

        // Set Preferred Width for Buttons and Min. Width
        ExportBtn.setPrefWidth(150);
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
        //introPrimaryStage.setScene(scene);
        // primaryStage.show();
        return scene;
    }

    /**
     * Helper Method, Allows user to export/print current view of stage
     *
     * @param primaryStage from which stage printerdialog shall be triggered
     * @param node         node which shall be printed
     */
    private void print(Stage primaryStage, Node node) {

        //    System.out.println("I am exporting");
        PrinterJob printNode = PrinterJob.createPrinterJob();
        if (printNode != null) {
           // printNode.showPrintDialog(primaryStage);

            //If user hits ok for printing
            if (printNode.showPrintDialog(primaryStage) == true) {

                // get picked printer
                Printer printer = printNode.getPrinter();

                // Customize print settings
                JobSettings jobSettings = printNode.getJobSettings();
                PageLayout pageLayout =
                        printer.createPageLayout(
                                Paper.A4, PageOrientation.REVERSE_LANDSCAPE, Printer.MarginType.EQUAL);
                jobSettings.setPageLayout(pageLayout);

                // store primary stage width values to restore them
                double width = primaryStage.getWidth();
                double height = primaryStage.getHeight();

                // resize stage to printing size
                double pw = pageLayout.getPrintableWidth();
                double ph = pageLayout.getPrintableHeight();
                primaryStage.setWidth(pw);
                primaryStage.setHeight(ph);

                // check if printing was successful
                boolean success = printNode.printPage(node);

                // If printing was successful inform user accordingly
                if (success) {
                    // set primaryStage to previous size
                    primaryStage.setWidth(width);
                    primaryStage.setHeight(height);

                    // Create Info Box: confirming printing
                    Alert printAlert = new Alert(Alert.AlertType.INFORMATION);
                    printAlert.setTitle("Print Status");
                    // now header inside infobox
                    printAlert.setHeaderText(null);
                    printAlert.setContentText("Your Results have been exported successfully.");
                    printAlert.showAndWait();

                    printNode.endJob();
                }
            } else {
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

        stage.setMinWidth(500);
      stage.setMaxWidth(850);
        stage.setMinHeight(300);

        // Trait Extraversion
        Label lblExtraVersion = new Label("Extraversion");
        Label txtExtraVersion =
                new Label(
                        "The tendency to be outgoing and high in social energy. Characterized by breadth of activities (as opposed to depth), "
                                + "surgency from external activity/situations, and energy creation from external means. "
                                + "The trait is marked by pronounced engagement with the external world. "
                                + "Extroverts enjoy interacting with people, and are often perceived as full of energy. "
                                + "They tend to be enthusiastic, action-oriented individuals. They possess high group visibility, "
                                + "like to talk, and assert themselves. Extroverted people may appear more dominant in social settings, "
                                + "as opposed to introverted people in this setting.\n"
                                + "\n"
                                + "Introverts have lower social engagement and energy levels than extroverts. "
                                + "They tend to seem quiet, low-key, deliberate, and less involved in the social world. "
                                + "Their lack of social involvement should not be interpreted as shyness or depression; "
                                + "instead they are more independent of their social world than extroverts. "
                                + "Introverts need less stimulation, and more time alone than extroverts. "
                                + "This does not mean that they are unfriendly or antisocial; rather, they are reserved in social "
                                + "situations.");


        // Trait Emotion
        Label lblEmotion = new Label("Emotional stability");
        Label txtEmotion =
                new Label(
                        "The tendency to be even in terms of emotions and to not experience much. Those low in emotional "
                                + "stability are generally prone to anxiety, sadness, worry, and low self-esteem. "
                                + "They may be temperamental or easily angered, and they tend to be self-conscious and unsure of themselves.\n"
                                + "\n"
                                + "Individuals who score on the high end are more likely to feel confident, sure of "
                                + "themselves, and adventurous. They may also be brave and unencumbered by worry or self-doubt, "
                                + "anxiety or sadness.");


        // Trait Openness
        Label lblOpenness = new Label("Openness");
        Label txtOpenness =
                new Label(
                        "The tendency to be interested in new ideas, people, art, and pretty much anything. "
                                + "People who are open to experience are intellectually curious, open to emotion, "
                                + "sensitive to beauty and willing to try new things. They tend to be, when compared to closed people, "
                                + "more creative and more aware of their feelings. They are also more likely to hold unconventional beliefs. "
                                + "High openness can be perceived as unpredictability or lack of focus, "
                                + "and more likely to engage in risky behaviour or drug taking. Moreover, "
                                + "individuals with high openness are said to pursue self-actualization specifically by seeking out intense, "
                                + "euphoric experiences. Conversely, those with low openness seek to gain fulfillment through perseverance and "
                                + "are characterized as pragmatic and data-driven - sometimes even perceived to be dogmatic and closed-minded");


        // Trait Agreeableness
        Label lblAgree = new Label("Agreeableness");
        Label txtAgree =
                new Label(
                        "The tendency to agree with people and to be generally kind in dealing with others. "
                                + "Agreeable individuals value getting along with others. "
                                + "They are generally considerate, kind, generous, trusting and trustworthy, helpful, "
                                + "and willing to compromise their interests with others."
                                + " Agreeable people also have an optimistic view of human nature.\n"
                                + "\n"
                                + "Disagreeable individuals place self-interest above getting along with others. "
                                + "They are generally unconcerned with others' well-being, "
                                + "and are less likely to extend themselves for other people. "
                                + "Sometimes their skepticism about others' motives causes them to be suspicious, "
                                + "unfriendly, and uncooperative. "
                                + "Low agreeableness often makes for competitive or challenging people, "
                                + "which can be seen as argumentative or untrustworthy");

        // Trait Conscientiousness
        Label lblConscious = new Label("Conscientiousness");
        Label txtConscious =
                new Label(
                        "The tendency to be meticulous and organized in all aspects of one’s life, display self-discipline, "
                                + "act dutifully, and strive for achievement against measures or outside expectations. It is related to the way in which people control, "
                                + "regulate, and direct their impulses. High conscientiousness is often perceived as being stubborn and focused. "
                                + "Low conscientiousness is associated with flexibility and spontaneity, but can also appear as sloppiness and lack of reliability."
                                + " High scores on conscientiousness indicate a preference for planned rather than spontaneous behavior.");


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
        // Add styleclass for gridpane
        gp.getStyleClass().add("gridpane2");

        txtConscious.setId("text");
        txtAgree.setId("text");
        txtOpenness.setId("text");
        txtExtraVersion.setId("text");
        txtEmotion.setId("text");

//                txtConscious.setWrapText(true);
//        txtAgree.setWrapText(true);
//        txtOpenness.setWrapText(true);
//        txtExtraVersion.setWrapText(true);
//        txtEmotion.setWrapText(true);


        ColumnConstraints col1 = new ColumnConstraints();
        col1.setMinWidth(120);
        gp.getColumnConstraints().addAll(col1);

        // Add Padding to box - distance to Window Edge
        gp.setPadding(new Insets(50));

        ScrollPane scroll = new ScrollPane(gp);

        Scene scene = new Scene(scroll);
        scroll.setFitToWidth(true);
        //scroll.setFitToHeight(true);
        scroll.setPrefSize(820, 850);


        stage.setTitle("TIPI Traits Definition and Implications - Source: Wikipedia");
        stage.setScene(scene);
        // set window icon for stage
        Image brain = new Image(getClass().getResourceAsStream("brain.png"));
        stage.getIcons().add(brain);

        stage.show();
    }

    /**
     * Helper Method. Generates GridPane Module that holds User Information
     *
     * @return GridPane
     */
    private GridPane getUserInfo() {

        // Part On of User Summary - Static Info
        GridPane gpUser = new GridPane();

        // Add styleclass for gridpane
        gpUser.getStyleClass().add("gridpane");

        // Header UserProfile
        Text userHeader = new Text("User Profile");

        // Add styleclass for header
        userHeader.getStyleClass().add("sectionHeader");

        // Header spans over two columns
        GridPane.setColumnSpan(userHeader, 2);

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

        return gpUser;
    }

    /**
     * Helper Method. Produces GridPane that holds Tipi Profile vs. Peers of user
     *
     * @return GridPane
     */
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


        // Add User Profile HeaderBox to row 0
        gpUserTipi.addRow(0, headerBox);

        //Header Spans over 2 rows
        GridPane.setColumnSpan(headerBox, 2);

        // Align Header
        headerBox.setAlignment(Pos.CENTER_LEFT);

        // counter to position labels, start at one as first row (index 0) is the header
        int i = 1;

        // Create Labels and Text for Pane and add them the gridpane
        for (Trait trait : user.getUserScoresAndMetrics()) {
            // Label for Trait
            Label lblTrait = new Label(trait.getName() + ":");
            // lblTrait.setTooltip(new Tooltip("Hello World"));
            // Text - Performance relative to peers
            Text txtTrait = new Text(trait.getComparisonToPeers());
            gpUserTipi.addRow(i, lblTrait, txtTrait);
            i++;
        }


        return gpUserTipi;
    }

    /**
     * Helper Method. Returns HBox that holds Chart visualizing users TIPI Results vs. Peers
     *
     * @return HBox with barChart
     */
    private HBox createChartModule() {

        // Create TipiChart object
        TipiChart chart = new TipiChart();

        // Create BarChart
        BarChart barChart = chart.createBarChart(user.getUserScoresAndMetrics());

        // Instruct to Chart to grow with window
        HBox.setHgrow(barChart, Priority.ALWAYS);

        // Create add chart to HBox and return it
        return new HBox(barChart);
    }
}
