package GeoObjects;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class ParkingMeter extends AGeoObject {

  public static Color COLOR = Color.GRAY;
  public static int SIZE = 2;
  private int objectID;
  private String payPolicy;
  private String freeParkingTime;
  private String street;
  private double baseRate;

  /**
   * Constructs a new parking meter object.
   * @param X
   * @param Y
   * @param objectID
   * @param payPolicy
   * @param freeParkingTime
   * @param street
   * @param baseRate
   */
  public ParkingMeter(double X, double Y, int objectID, String payPolicy,
                      String freeParkingTime, String street, double baseRate) {
    super(X, Y);
    this.objectID = objectID;
    this.payPolicy = payPolicy;
    this.freeParkingTime = freeParkingTime;
    this.street = street;
    this.baseRate = baseRate;
  }

  @Override
  public Color getColor() {
    return ParkingMeter.COLOR;
  }

  @Override
  public String getObjectType() {
    return "ParkingMeter";
  }

  public static List<IGeoObject> buildParkingMeters(ResultSet rs) {
    List<IGeoObject> meters = new ArrayList<>();
    try {
      while (rs.next()) {
        meters.add(new ParkingMeter(
                rs.getDouble("X"),
                rs.getDouble("Y"),
                rs.getInt("OBJECTID"),
                rs.getString("PAY_POLICY"),
                rs.getString("PARK_NO_PAY"),
                rs.getString("STREET"),
                rs.getDouble("BASE_RATE")));
      }
      return meters;
    } catch (SQLException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
      return null;
    }
  }

  public int getSize() {
    return ParkingMeter.SIZE;
  }
}
