package GeoObjects;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class ChargingStation extends AGeoObject {

  private int objectID;
  private String stationName;
  private String streetAddress;
  private String streetName;
  private String city;
  private int zip;
  private String stationOperator;
  private String stationOperatorSite;
  private String connectorType;

  /**
   * Constructor for object which has an X and Y coordinate
   *
   * @param X X Coordinate
   * @param Y Y Coordinate
   */
  public ChargingStation(double X, double Y, int objectID, String stationName,
                  String streetName, String streetAddress,String city, int zip,
                  String stationOperator, String stationOperatorSite, String connectorType) {
    super(X, Y);
    this.objectID = objectID;
    this.stationName = stationName;
    this.streetName = streetName;
    this.streetAddress = streetAddress;
    this.city = city;
    this.zip = zip;
    this.stationOperator = stationOperator;
    this.stationOperatorSite = stationOperatorSite;
    this.connectorType = connectorType;
  }

  @Override
  public String getObjectType() {
    return "ChargingStation";
  }

  @Override
  public String getInformation() {
    StringBuilder ret = new StringBuilder();
    ret.append(String.format("Charging station.\nAddress: %s, %s, %d", this.streetAddress,
            this.city, this.zip));
    ret.append("\nOwner: " + this.stationOperator + " site: " + this.stationOperatorSite);
    ret.append("\nConnector Type: " + this.connectorType);
    return ret.toString();
  }
}
