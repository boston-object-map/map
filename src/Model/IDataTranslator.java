package Model;

import java.util.List;

import GeoObjects.IGeoObject;

/**
 * Enables users to interact with a Database in terms of GeoObjects.
 */
public interface IDataTranslator {

  /**
   * Returns all GeoObjects in a rectangular View.
   */
  public List<IGeoObject> getObjectsInView(double lowerX, double upperX, double lowerY, double upperY);

  /**
   * Returns all objects of a given type, such as "firehydrant" or "tree".
   */
  public List<IGeoObject> getObjectsOfType(String type);
}


