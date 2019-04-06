/**
 * Abstract class for objects
 */
public abstract class AObject implements IObject {

  protected double X;
  protected double Y;
  protected Color C;

  /**
   * Constructor for object which has an X and Y coordinate
   * @param X X Coordinate
   * @param Y Y Coordinate
   */
  AObject(int X, int Y){
    this.X = X;
    this.Y = Y;
  }

  @Override
  public Color getX() {
    return X;
  }

  @Override
  public Color getY() {
    return Y;
  }

  @Override
  public Color getC() {
    return C;
  }

  abstract public String getObjectType();

  abstract public String getInformation();
}