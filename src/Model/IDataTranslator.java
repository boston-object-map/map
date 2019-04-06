package Model;

import java.util.List;

import GeoObjects.IGeoObject;

/**
 * Enables users to interact with a database in terms of GeoObjects.
 */
public interface IDataTranslator {

  /**
   * Returns all GeoObjects in a rectangular view.
   * @param upperLeft
   * @param upperRight
   * @param lowerLeft
   * @param lowerRight
   * @return
   */
  public List<IGeoObject> getObjectsInView(double upperLeft, double upperRight, double lowerLeft, double lowerRight);


  public List<IGeoObject> getObjectsOfType(String type);
}


