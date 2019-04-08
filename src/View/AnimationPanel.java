package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

import GeoObjects.IGeoObject;

public class AnimationPanel extends JPanel {

  private List<IGeoObject> Objects;

  public AnimationPanel() {
    super();
    this.setBackground(Color.WHITE);
  }

  public void setObjects(List<IGeoObject> list) {
    this.Objects = list;
  }

  private int longToX(double x) {
    double temp1 = x + 71.12411;
    int temp2 = (int) (temp1 * 100000);
    return temp2;
  }

  private int latToY(double y) {
    double temp1 = y - 42.32881;
    int temp2 = 4088 - ((int) (temp1 * 100000));
    return temp2;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;

    /*
    g2d.setColor(Color.RED);
    g2d.fillOval(300, 400, 5, 5);
    */

    for (IGeoObject i : Objects) {

      int x = longToX(i.getX());
      int y = latToY(i.getY());
      System.out.println(x + " - " + y);


      g2d.setColor(i.getColor());
      g2d.fillOval(x, y, 5, 5);
    }

    System.out.println("Finished drawing");

  }
}
