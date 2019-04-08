package Model;

import java.util.List;

import GeoObjects.IGeoObject;

/**
 * Enables users to interact with a database in terms of GeoObjects.
 */
public interface IDataTranslator {

  /**
   * Returns all GeoObjects in a rectangular view.
   * @param upperX
   * @param upperX
   * @param lowerX
   * @param lowerX
   * @return
   */
  public List<IGeoObject> getObjectsInView(double lowerX, double upperX, double lowerY, double upperY);


  public List<IGeoObject> getObjectsOfType(String type);
}


