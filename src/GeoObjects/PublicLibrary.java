package GeoObjects;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class PublicLibrary extends AGeoObject {


  public static Color COLOR = Color.MAGENTA;
  public static int SIZE = 20;
  private int objectID;
  private String streetAddress;
  private String branch;

  /**
   * Constructor for object which has an X and Y coordinate
   *
   * @param X X Coordinate
   * @param Y Y Coordinate
   */
  PublicLibrary(double X, double Y, int objectID, String streetAddress, String branch) {
    super(X, Y);
    this.objectID = objectID;
    this.streetAddress = streetAddress;
    this.branch = branch;
  }

  @Override
  public Color getColor() {
    return PublicLibrary.COLOR;
  }

  @Override
  public String getObjectType() {
    return null;
  }

  @Override
  public String getInformation() {
    return "Some info about this public library";
  }

  public static List<IGeoObject> buildPublicLibraries(ResultSet rs) {
    List<IGeoObject> libraries = new ArrayList<>();
    try {
      while (rs.next()) {
        libraries.add(new PublicLibrary(
                rs.getDouble("X"),
                rs.getDouble("Y"),
                rs.getInt("OBJECTID"),
                rs.getString("ST_ADDRESS"),
                rs.getString("BRANCH")));
      }
      return libraries;
    } catch (SQLException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
      return null;
    }
  }

  public int getSize() {
    return PublicLibrary.SIZE;
  }
}
