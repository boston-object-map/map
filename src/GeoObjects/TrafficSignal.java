package GeoObjects;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class TrafficSignal extends AGeoObject {

  public static Color COLOR = Color.black;
  public static int SIZE = 2;
  private int objectID;
  private String intersection;

  /**
   * Constructs a new Traffic Signal object.
   * @param X
   * @param Y
   * @param objectID
   * @param intersection
   */
  public TrafficSignal(double X, double Y, int objectID, String intersection) {
    super(X, Y);
    this.objectID = objectID;
    this.intersection = intersection;
  }

  @Override
  public Color getColor() {
    return TrafficSignal.COLOR;
  }

  @Override
  public String getObjectType() {
    return "TrafficSignal";
  }

  public static List<IGeoObject> buildTrafficSignals(ResultSet rs) {
    List<IGeoObject> signals = new ArrayList<>();
    try {
      while (rs.next()) {
        signals.add(new TrafficSignal(
                rs.getDouble("X"),
                rs.getDouble("Y"),
                rs.getInt("OBJECTID"),
                rs.getString("Location")));
      }
      return signals;
    } catch (SQLException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
      return null;
    }
  }

  public int getSize() {
    return TrafficSignal.SIZE;
  }
}
