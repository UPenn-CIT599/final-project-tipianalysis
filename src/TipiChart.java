import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.HashMap;

/**
 * Class to produce a Chart visualizing the Results from the Tipi Questionaire
 */
public class TipiChart {

    /**
     * Creates a BarChart based for HashMaps provided
     * @param UserTipiMap TipiResults from User
     * @param BMTipiMap Tipi BM values for respective user
     * @return BarChart
     */
    public BarChart createBarChart(HashMap<String, Integer> UserTipiMap,HashMap<String, Integer> BMTipiMap){

        //Define axis types of chart
        CategoryAxis traitsAxis = new CategoryAxis();
        NumberAxis traitsValues = new NumberAxis();

        //Add labels to Axis
        traitsAxis.setLabel("Traits");
        traitsValues.setLabel("TIPI Score");

        //Construct Chart Object
        BarChart<String, Number> barChart = new BarChart<>(traitsAxis, traitsValues);

        return barChart;

    }


    /**
     * Helper method converts HashMap into a DataSeries for a Chart and labels series with seriesName provided
     * @param tipiMap - String Integer HashMap
     * @param seriesName Label for Series
     * @return Series for XY Chart
     */
    private XYChart.Series mapToDataSeries(HashMap<String, Integer> tipiMap, String seriesName){

        //Create Series object
        XYChart.Series series = new XYChart.Series();
        series.setName(seriesName);
    for (String key : tipiMap.keySet()) {
        series.getData().add(new XYChart.Data(key,tipiMap.get(key)));

    }

    return series;
      //

    }

}


