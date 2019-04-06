package GeoObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class Streetlight extends AGeoObject {

  private int objectID;
  private String type;

  /**
   * Constructs a new Streetlight object.
   */
  public Streetlight(double X, double Y, int objectID, String type) {
    super(X, Y);
    this.objectID = objectID;
    this.type = type;
  }

  @Override
  public String getObjectType() {
    return "Streetlight";
  }

  public static List<IGeoObject> buildStreetlights(ResultSet rs) {
    List<IGeoObject> streetlights = new ArrayList<>();
    try {
      while (rs.next()) {
        streetlights.add(new Streetlight(
                rs.getDouble("X"),
                rs.getDouble("Y"),
                rs.getInt("ObjectID"),
                rs.getString("Type")));
      }
      return streetlights;
    } catch (SQLException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
      return null;
    }
  }
}
