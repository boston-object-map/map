package GeoObjects;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class TrafficSignal extends AGeoObject {

  private int objectID;
  private String intersection;

  /**
   * Constructs a new Traffic Signal object.
   * @param X
   * @param Y
   * @param objectID
   * @param intersection
   */
  public TrafficSignal(int X, int Y, int objectID, String intersection) {
    super(X, Y);
    this.objectID = objectID;
    this.intersection = intersection;
  }

  @Override
  public String getObjectType() {
    return "TrafficSignal";
  }
}
