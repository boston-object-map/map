package GeoObjects;

import GeoObjects.AObject;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class PublicLibrary extends AObject {

  /**
   * Constructor for object which has an X and Y coordinate
   *
   * @param X X Coordinate
   * @param Y Y Coordinate
   */
  PublicLibrary(int X, int Y) {
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
