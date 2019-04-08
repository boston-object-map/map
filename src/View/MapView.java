package view;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

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
    this.setSize(7693, 4087);
    this.setPreferredSize(this.getSize());
    this.setLayout(new BorderLayout());

    animationPanel = new AnimationPanel();
    animationPanel.setObjects(Objects);
    animationPanel.setPreferredSize(new Dimension(7693, 4087));
    JScrollPane visualScrollPane = new JScrollPane(animationPanel,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    this.add(visualScrollPane, BorderLayout.CENTER);

    /*
    try {
      TimeUnit.SECONDS.sleep(30);
    } catch(Exception e) {

    }
    */
    this.setVisible(true);
  }

  public void run() {
    render();
  }
}
