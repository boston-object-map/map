package GeoObjects;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class FireHydrant extends AGeoObject {

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
  FireHydrant(int X, int Y, int objectID, String placementDT, String manufacturer, String model) {
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
}
