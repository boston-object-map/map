package GeoObjects;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class Tree extends AGeoObject {

  private int objectID;
  private String type;

  public Tree(double X, double Y, int objectID, String type) {
    super(X, Y);
    this.objectID = objectID;
    this.type = type;
  }

  @Override
  public String getObjectType() {
    return "Tree";
  }

  public static List<IGeoObject> buildTrees(ResultSet rs) {
    //TODO
    return null;
  }
}
