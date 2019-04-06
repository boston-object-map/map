package GeoObjects;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class College extends AObject {

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
  College(int X, int Y, int objectID, String name,
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
    return "TBD";
  }
}
