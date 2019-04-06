package GeoObjects;

import com.sun.deploy.panel.SpecialTreeListener;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class Streetlight extends AObject {

  private int objectID;
  private String type;

  /**
   * Constructs a new Streetlight object.
   */
  public Streetlight(int X, int Y, int objectID, String type) {
    super(X, Y);
    this.objectID = objectID;
    this.type = type;
  }

  @Override
  public String getObjectType() {
    return "Streetlight";
  }
}
