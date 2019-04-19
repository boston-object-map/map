package Model;

import java.util.List;

import GeoObjects.IGeoObject;

/**
 * Enables users to interact with a Database in terms of GeoObjects.
 */
public interface IDataTranslator {

  /**
   * Returns all GeoObjects in a rectangular View.
   * @param upperX
   * @param upperX
   * @param lowerX
   * @param lowerX
   * @return
   */
  public List<IGeoObject> getObjectsInView(double lowerX, double upperX, double lowerY, double upperY);


  public List<IGeoObject> getObjectsOfType(String type);
}


