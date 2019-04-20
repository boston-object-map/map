package GeoObjects;

        import java.awt.*;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class College extends AGeoObject {

  public static Color COLOR = Color.PINK;
  public static int SIZE = 30;

  private int objectID;
  private String name;
  private String address;
  private String phoneNumber;
  private int numStudents;

  /**
   * Constructor for object which has an X and Y coordinate
   *
   * @param X X Coordinate
   * @param Y Y Coordinate
   */
  public College(double X, double Y, int objectID, String name,
                 String address, String phoneNumber, int numStudents) {
    super(X, Y);
    this.objectID = objectID;
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.numStudents = numStudents;
  }

  @Override
  public String getObjectType() {
    return "College";
  }

  @Override
  public String getInformation() {
    return this.name + " " + this.address;
  }

  public static List<IGeoObject> buildColleges(ResultSet rs) {
    List<IGeoObject> colleges = new ArrayList<>();
    try {
      while (rs.next()) {
        colleges.add(new College(
                rs.getDouble("X"),
                rs.getDouble("Y"),
                rs.getInt("OBJECTID"),
                rs.getString("Name"),
                rs.getString("Address"),
                rs.getString("PhoneNumbe"),
                rs.getInt("NumStudents13")));
      }
      return colleges;
    } catch (SQLException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Color getColor() {
    return College.COLOR;
  }

  public int getSize() {
    return College.SIZE;
  }
}
