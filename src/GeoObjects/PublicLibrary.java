package GeoObjects;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class PublicLibrary extends AGeoObject {

  /**
   * Constructor for object which has an X and Y coordinate
   *
   * @param X X Coordinate
   * @param Y Y Coordinate
   */
  PublicLibrary(double X, double Y) {
    super(X, Y);
  }

  @Override
  public String getObjectType() {
    return null;
  }

  @Override
  public String getInformation() {
    return "Some info about this public library";
  }
}
