package GeoObjects;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class ChargingStation extends AGeoObject {

  public static Color COLOR = Color.ORANGE;
  public static int SIZE = 2;
  private int objectID;
  private String stationName;
  private String streetAddress;
  private String stationOperator;
  private String connectorType;

  /**
   * Constructor for object which has an X and Y coordinate
   *
   * @param X X Coordinate
   * @param Y Y Coordinate
   */
  public ChargingStation(double X, double Y, int objectID, String stationName, String streetAddress,
                  String stationOperator, String connectorType) {
    super(X, Y);
    this.objectID = objectID;
    this.stationName = stationName;
    this.streetAddress = streetAddress;
    this.stationOperator = stationOperator;
    this.connectorType = connectorType;
  }

  @Override
  public String getObjectType() {
    return "ChargingStation";
  }

  @Override
  public String getInformation() {
    StringBuilder ret = new StringBuilder();
    ret.append(String.format("Charging station.\nAddress: %s", this.streetAddress));
    ret.append("\nOwner: " + this.stationOperator + " site: ");
    ret.append("\nConnector Type: " + this.connectorType);
    return ret.toString();
  }

  public static List<IGeoObject> buildChargingStations(ResultSet rs) {
    List<IGeoObject> chargers = new ArrayList<>();
    try {
      while (rs.next()) {
        chargers.add(new ChargingStation(
                rs.getDouble("X"),
                rs.getDouble("Y"),
                rs.getInt("OBJECTID"),
                rs.getString("Station_Name"),
                rs.getString("Street_Address"),
                rs.getString("Station_Operator"),
                rs.getString("EV_Connector_Types")));
      }
      return chargers;
    } catch (SQLException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Color getColor() {
    return ChargingStation.COLOR;
  }

  public int getSize() {
    return ChargingStation.SIZE;
  }
}
