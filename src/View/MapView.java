package View;

import java.awt.*;
import java.util.List;

import javax.swing.JFrame;

import GeoObjects.IGeoObject;

public class MapView extends JFrame {

  private List<IGeoObject> Objects;
  private AnimationPanel animationPanel;

  public MapView(List<IGeoObject> list){
    super();
    this.setTitle("Map of Boston");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.Objects = list;
  }

  private void render() {
    this.setSize(1920, 1080);
    this.setPreferredSize(this.getSize());
    this.setLayout(new BorderLayout());

    animationPanel = new AnimationPanel();
    animationPanel.setObjects(Objects);
    animationPanel.setPreferredSize(new Dimension(1920, 1080));
    this.add(animationPanel, BorderLayout.CENTER);
  }

  public void run() {
    render();
  }
}
