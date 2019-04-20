package View;

import GeoObjects.IGeoObject;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.List;

public class AnimationPanel extends JPanel {

  float scaleFactor = 1;
  private List<IGeoObject> Objects;
  private boolean isBW = false;
  private AffineTransform transform;
  Dimension originalDimensions = new Dimension(1620, 1000);

  public AnimationPanel() {
    super();
    this.setPreferredSize(originalDimensions);
    this.setBackground(Color.lightGray);
  }

  /**
   * Allows transformation between geo coordinates and pixels.
   * @param xInTL
   * @param yInTL
   * @param xInBR
   * @param yInBR
   * @param xOutTL
   * @param yOutTL
   * @param xOutBR
   * @param yOutBR
   * @return
   */
  private static AffineTransform setTransform(
          double xInTL, double yInTL,
          double xInBR, double yInBR,
          double xOutTL, double yOutTL,
          double xOutBR, double yOutBR) {
    double mx = (xOutBR - xOutTL) / (xInBR - xInTL);
    double bx = xOutTL - mx * xInTL;
    double my = (yOutBR - yOutTL) / (yInBR - yInTL);
    double by = yOutTL - my * yInTL;
    return new AffineTransform(mx, 0, 0, my, bx, by);
  }

  private void setTransform() {
    this.transform = AnimationPanel.setTransform(
            -71.19068644599304, 42.23266795011358,
            -70.92452129861498, 42.39691380314959,
            0, 0,
            this.getWidth(), this.getHeight());
  }

  /**
   * Toggle black and white mode.
   * @param BW
   */
  public void setBW(boolean BW) {
    isBW = BW;
  }

  /**
   * Update the list of objects this AnimationPanel should draw.
   * @param list
   */
  public void setObjects(List<IGeoObject> list) {
    this.Objects = list;
  }

  /**
   * Resize the window based on current zoom level.
   */
  public void scaleDimensions() {
    Dimension dim = this.originalDimensions;
    this.setPreferredSize(new Dimension(
            (int) (dim.getWidth() * this.scaleFactor),
            (int) (dim.getHeight() * this.scaleFactor)));
    this.setTransform();
    this.revalidate();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.setTransform();

    Graphics2D g2d = (Graphics2D) g;

    for (IGeoObject i : Objects) {

      if(this.isBW) {
        g2d.setColor(Color.black);
      }
      else {
        g2d.setColor(i.getColor());
      }
      Point2D posn = this.transform.transform(new Point2D.Double(i.getX(), i.getY()), null);
      g2d.fillOval(
              (int)posn.getX(),
              this.getHeight() - (int)posn.getY(),
              (int) Math.max(2, Math.round(Math.sqrt(i.getSize() * this.scaleFactor))),
              (int) Math.max(2, Math.round(Math.sqrt(i.getSize() * this.scaleFactor))));
    }
  }
}
