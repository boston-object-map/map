package GeoObjects;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class Tree extends AObject {

  private int objectID;
  private String type;

  public Tree(int X, int Y, int objectID, String type) {
    super(X, Y);
    this.objectID = objectID;
    this.type = type;
  }

  @Override
  public String getObjectType() {
    return "Tree";
  }
}
