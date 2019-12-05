
import javafx.scene.chart.XYChart;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TipiChartTest {

  @Test
  /**
   * Tests if Traits Array is correctly converted into DataSeries as Required for BarChart
   */
  public void testMaptoDataSeries()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    // Traits Data for Testing
    String[] traitNames =
        new String[] {
          "Extroversion", "Agreeableness", "Conscientiousness", "Emotional Stability", "Openness"
        };
    String[] peerComparison = new String[] {"Low", "High", "Average", "Low", "Average"};
    Trait[] traitArray = new Trait[5];

    // Create Series objects to check against
    XYChart.Series<String, Number> seriesUserToCheck = new XYChart.Series();
    XYChart.Series<String, Number> seriesPeerToCheck = new XYChart.Series();

    //fill in traits array for method being tested and benchmark values to check against
    for (int i = 0; i < 5; i++) {
      Trait trait = new Trait(traitNames[i], i, (i + 1), 0, 0, peerComparison[i]);
      traitArray[i] = trait;

      // fill user data Series to check against
      seriesUserToCheck.getData().add(new XYChart.Data(traitNames[i], i + 1));
      // fill peer data Series to check against
      seriesPeerToCheck.getData().add(new XYChart.Data(traitNames[i], i));
    }

    //Required i.o. to be able to test private method
    TipiChart chart = new TipiChart();
    Class tipiClass = chart.getClass();
    Method privateMapToDataSeriesMethod = tipiClass.getDeclaredMethod("mapToDataSeries", Trait[].class);
    privateMapToDataSeriesMethod.setAccessible(true);
    //Cast traitArray to Object so that is seen as one argument instead of an array with all arguments
    XYChart.Series[] series = (XYChart.Series[]) privateMapToDataSeriesMethod.invoke(chart,(Object)traitArray);
   // XYChart.Series[] series = chart.mapToDataSeries(traitArray);

    //extract two series
    XYChart.Series<String, Number> userData = series[0];
    XYChart.Series<String, Number> peerData = series[1];

    String[] labelUserArray = new String[5];
    String[] labelPeerArray = new String[5];

    double[] valueUserArray = new double[5];
    double[] valuePeerArray = new double[5];

    double[] valueUserResult = {0,1,2,3,4};
    double[] valuePeerResult = {1,2,3,4,5};

    for (int i = 0; i < 5; i++) {
      labelUserArray[i] = userData.getData().get(i).getXValue();
      labelPeerArray[i] = peerData.getData().get(i).getXValue();

      valueUserArray[i] = (double) userData.getData().get(i).getYValue();
      valuePeerArray[i] = (double) peerData.getData().get(i).getYValue();
    }

    //CheckLabels
    assertArrayEquals(traitNames,labelPeerArray);
    assertArrayEquals(traitNames,labelUserArray);

    //CheckValues
    assertArrayEquals(valueUserResult,valueUserArray);
    assertArrayEquals(valuePeerResult,valuePeerArray);
  }
}
