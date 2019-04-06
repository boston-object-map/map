package GeoObjects;

import java.awt.Color;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

/**
 * This interface represents each object to be repesented in our map and allows functionality to
 * return necessary information
 */
public interface IObject {

  /**
   * Return the objects X-Coordinate
   * @return X-Coordinate
   */
  double getX();

  /**
   * Return the objects Y-Coordinate
   * @return Y-Coordinate
   */
  double getY();

  /**
   * Return the objects Map Color
   * @return The objects color on the map
   */
  Color getColor();

  /**
   * Return the objects type as a string
   * @return The name of the object type
   */
  String getObjectType();

  /**
   * Returns information about the object if possible, returns NULL if no information about this
   * object is avaliable
   * @return
   */
  String getInformation();
}
