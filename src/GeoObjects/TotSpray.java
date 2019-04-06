package GeoObjects;

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
  public TotSpray(int X, int Y, int objectID, String neighborhood, String parkName, String address) {
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
}
