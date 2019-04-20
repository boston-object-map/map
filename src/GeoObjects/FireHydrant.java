package GeoObjects;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class FireHydrant extends AGeoObject {

  public static Color COLOR = Color.red;
  public static int SIZE = 2;

  private final int objectID;
  private int ObjectID;
  private String placementDT;
  private final String manufacturer;
  private final String model;

  /**
   * Constructor for object which has an X and Y coordinate
   *
   * @param X X Coordinate
   * @param Y Y Coordinate
   */
  public FireHydrant(double X, double Y, int objectID, String placementDT, String manufacturer, String model) {
    super(X, Y);
    this.objectID = objectID;
    this.placementDT = placementDT;
    this.manufacturer = manufacturer;
    this.model = model;
  }

  @Override
  public String getObjectType() {
    return "FireHydrant";
  }

  public static List<IGeoObject> buildFireHydrants(ResultSet rs) {
    List<IGeoObject> hydrants = new ArrayList<>();
    try {
      while (rs.next()) {
        hydrants.add(new FireHydrant(
                rs.getDouble("X"),
                rs.getDouble("Y"),
                rs.getInt("OBJECTID"),
                rs.getString("PLACEMENT_DATE_TIME"),
                rs.getString("HYDRANT_MANUF_CODE"),
                rs.getString("HYDRANT_MODEL_CODE")));
      }
      return hydrants;
    } catch (SQLException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Color getColor() {
    return FireHydrant.COLOR;
  }

  public int getSize() {
    return FireHydrant.SIZE;
  }
}
