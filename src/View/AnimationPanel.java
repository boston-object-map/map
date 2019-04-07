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

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;

    for (IGeoObject i : Objects) {
      int x = 0;
      int y = 0;

      g2d.setColor(i.getColor());
      g2d.fillOval(x, y, 1, 1);
    }
  }
}
