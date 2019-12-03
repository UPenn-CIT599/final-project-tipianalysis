import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Font;

import java.util.HashMap;
import java.util.LinkedHashMap;

/** Class to produce a Chart visualizing the Results from the Tipi Questionaire */
public class TipiChart {

  /**
   * Creates a BarChart of User Tipi Resutls vs. Peer values
   *
   * @param traits Array of Traits containing user score and respective peer score
   * @return BarChart
   */
  public BarChart createBarChart(Trait[] traits) {

    // Define axis types of chart
    CategoryAxis traitsAxis = new CategoryAxis();
    NumberAxis traitsValues = new NumberAxis();

    // Add labels to Axis
    traitsAxis.setLabel("Traits");
    traitsValues.setLabel("TIPI Score");

    // Construct Chart Object
    BarChart<String, Number> barChart = new BarChart<>(traitsAxis, traitsValues);

    // Generate Data Series
    XYChart.Series[] seriesArray = mapToDataSeries(traits);

    // Get individual data series and name them
    XYChart.Series<String, Number> userData = seriesArray[0];
    userData.setName("User");
    XYChart.Series<String, Number> peerData = seriesArray[1];
    peerData.setName("Peer");

    // add series to chart
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
    // Specifies whether the shape, if defined, is scaled to match the size of the Region. true
    // means the shape is scaled to fit the size of the Region, false means the shape is at its
    // source size
    traitsAxis.setScaleShape(true);

    //return barChart
    return barChart;
  }

  /**
   * Helper method converts HashMap into a DataSeries for a Chart and labels series with seriesName
   * provided
   *
   * @param traits Array of Traits containing user score and respective peer score
   * @return Series for XY Chart
   */
  private XYChart.Series[] mapToDataSeries(Trait[] traits) {

    // Create Series objects
    XYChart.Series<String, Number> seriesUser = new XYChart.Series();
    XYChart.Series<String, Number> seriesPeer = new XYChart.Series();

    //loop through traits array and get user and peer data
    for (Trait trait : traits) {
      // trait Name
      String traitName = trait.getName();
      // get User Score
      seriesUser.getData().add(new XYChart.Data(traitName, trait.getUserScore()));
      // get Peer Score
      seriesPeer.getData().add(new XYChart.Data(traitName, trait.getMean()));
    }

    //return data series Array
    return new XYChart.Series[] {seriesUser, seriesPeer};
  }
}
