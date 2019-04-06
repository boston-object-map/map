package GeoObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class TotSpray extends AGeoObject {

  private int objectID;
  private String neighborhood;
  private String parkName;
  private String address;

  /**
   * Constructs a new totspray object.
   * @param X
   * @param Y
   * @param objectID
   * @param neighborhood
   * @param parkName
   * @param address
   */
  public TotSpray(double X, double Y, int objectID, String neighborhood, String parkName, String address) {
    super(X, Y);
    this.objectID = objectID;
    this.neighborhood = neighborhood;
    this.parkName = parkName;
    this.address = address;
  }

  @Override
  public String getObjectType() {
    return "TotSpray";
  }

  public static List<IGeoObject> buildTotSprays(ResultSet rs) {
    List<IGeoObject> sprays = new ArrayList<>();
    try {
      while (rs.next()) {
        sprays.add(new TotSpray(
                rs.getDouble("X"),
                rs.getDouble("Y"),
                rs.getInt("OBJECTID"),
                rs.getString("Neighborho"),
                rs.getString("Park_Name"),
                rs.getString("Address_Te")));
      }
      return sprays;
    } catch (SQLException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
      return null;
    }
  }
}
