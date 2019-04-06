package GeoObjects;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class ParkingMeter extends AGeoObject {

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
  public ParkingMeter(int X, int Y, int objectID, String payPolicy,
                      String freeParkingTime, String street, double baseRate) {
    super(X, Y);
    this.objectID = objectID;
    this.payPolicy = payPolicy;
    this.freeParkingTime = freeParkingTime;
    this.street = street;
    this.baseRate = baseRate;
  }

  @Override
  public String getObjectType() {
    return "ParkingMeter";
  }
}
