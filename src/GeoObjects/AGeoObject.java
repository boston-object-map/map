package GeoObjects;

import java.awt.*;

/**
 * Abstract class for objects
 */
public abstract class AGeoObject implements IGeoObject {

  protected double X;
  protected double Y;

  /**
   * Constructor for object which has an X and Y coordinate
   * @param X X Coordinate
   * @param Y Y Coordinate
   */
  AGeoObject(double X, double Y){
    this.X = X;
    this.Y = Y;
  }

  @Override
  public double getX() {
    return X;
  }

  @Override
  public double getY() {
    return Y;
  }

  /**
   * Returns a string describing object type, such as "college", "chargingstation"
   */
  abstract public String getObjectType();

  @Override
  public String getInformation(){
    return "future feature";
  }

  /**
   * Returns the color associated with instances of this class.
   */
  public abstract Color getColor();

  /**
   * Returns the size associated with instances of this class.
   */
  public abstract int getSize();
}
