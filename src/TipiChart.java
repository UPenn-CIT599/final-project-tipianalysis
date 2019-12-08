import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;


/** Class to produce a BarChart visualizing the Results from the Tipi Questionaire */
public class TipiChart {

  /**
   * Creates a BarChart of User Tipi Results vs. Peer mean values
   *
   * @param traits Array of Traits containing amongst others user score and respective peer score
   * @return BarChart
   */
  public BarChart<String, Number> createBarChart(Trait[] traits) {

    // Define axis types of chart
    CategoryAxis traitsAxis = new CategoryAxis();
    NumberAxis valuesAxis = new NumberAxis();

    // Add labels to Axis
    traitsAxis.setLabel("Traits");
    valuesAxis.setLabel("TIPI Score");

    // Construct Chart Object
    BarChart<String, Number> barChart = new BarChart<>(traitsAxis, valuesAxis);

    // Generate Data Series Array
    XYChart.Series<String, Number>[] seriesArray = mapToDataSeries(traits);

    // Get individual data series and name them
    XYChart.Series<String, Number> userData = seriesArray[0];
    userData.setName("User");
    XYChart.Series<String, Number> peerData = seriesArray[1];
    peerData.setName("Peer");

    // add data series to chart
    barChart.getData().addAll(userData, peerData);

    // Chart Layouting
    // Gap between bars of different data series
    barChart.setBarGap(3);
    // Gap between different Categories
    barChart.setCategoryGap(30);
    // remove x-Axis ticks
    traitsAxis.setTickMarkVisible(false);
    // axis determines range from data automatically
    traitsAxis.setAutoRanging(true);
    valuesAxis.setAutoRanging(true);


    //return barChart
    return barChart;
  }

  /**
   * Helper method converts Array of Traits into Data series as required for a BarChart
   *
   * @param traits Array of Traits containing user score and respective peer score
   * @return Array with Series for XY Chart. First Position in Array User Scores second Peer Scores
   */
  private XYChart.Series<String, Number>[] mapToDataSeries(Trait[] traits) {

    // Create Series objects
    XYChart.Series<String, Number> seriesUser = new XYChart.Series<>();
    XYChart.Series<String, Number> seriesPeer = new XYChart.Series<>();

    //loop through traits array and get user and peer data
    for (Trait trait : traits) {
      // trait Name
      String traitName = trait.getName();
      // get User Score
      seriesUser.getData().add(new XYChart.Data<>(traitName, trait.getUserScore()));
      // get Peer Score
      seriesPeer.getData().add(new XYChart.Data<>(traitName, trait.getMean()));
    }

    //return data series Array
    return new XYChart.Series[] {seriesUser, seriesPeer};
  }
}
