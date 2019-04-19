package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

import GeoObjects.IGeoObject;

public class AnimationPanel extends JPanel {

  private List<IGeoObject> Objects;

  private int scaleFactor = 3;
  private boolean isBW = false;

  public AnimationPanel() {
    super();
    this.setBackground(Color.lightGray);
  }

  public void setScaleFactor(int newSF){
    this.scaleFactor = newSF;
  }

  public void setObjects(List<IGeoObject> list) {
    this.Objects = list;
  }

  private int longToX(double x) {
    double temp1 = x + 71.12411;
    int temp2 = (int) (temp1 * 100000);
    return (temp2 / this.scaleFactor) + 900;
  }

  /**
   * Magic math. Not the best way to do this but it gets the job done.
   * @param y
   * @return
   */
  private int latToY(double y) {
    double temp1 = y - 42.32881;
    int temp2 = 4088 - ((int) (temp1 * 100000));
    return temp2 / this.scaleFactor + 300;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;

    for (IGeoObject i : Objects) {
      int x = longToX(i.getX());
      int y = latToY(i.getY());

      if(this.isBW) {
        g2d.setColor(Color.black);
      }
      else {
        g2d.setColor(i.getColor());
      }
      g2d.fillOval(x, y, 3, 3);
    }

    System.out.println("Finished drawing");
  }
}
