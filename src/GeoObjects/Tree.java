package GeoObjects;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael Goodnow on 2019-04-06.
 */

public class Tree extends AGeoObject {

  public static Color COLOR = new Color(30, 170, 70);
  public static int SIZE = 2;
  private int objectID;
  private String type;

  public Tree(double X, double Y, int objectID, String type) {
    super(X, Y);
    this.objectID = objectID;
    this.type = type;
  }

  @Override
  public Color getColor() {
    return Tree.COLOR;
  }

  @Override
  public String getObjectType() {
    return "Tree";
  }

  public static List<IGeoObject> buildTrees(ResultSet rs) {
    List<IGeoObject> trees = new ArrayList<>();
    try {
      while (rs.next()) {
        trees.add(new Tree(
                rs.getDouble("X"),
                rs.getDouble("Y"),
                rs.getInt("OBJECTID"),
                rs.getString("TYPE")));
      }
      return trees;
    } catch (SQLException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
      return null;
    }
  }

  public int getSize() {
    return Tree.SIZE;
  }
}
