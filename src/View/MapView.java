package View;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import GeoObjects.IGeoObject;
import Model.IDataTranslator;

public class MapView extends JFrame {

  private List<IGeoObject> objects;
  private AnimationPanel animationPanel;
  private IDataTranslator dt;


  //These keep track of what objects we are rendering. Direct mutation from
  boolean college = true, chargingStation = true, fireHydrant = true, parkingMeter = true,
          publicLibrary = true, streetLight = true, totspray = true, trafficSignal = true, tree = true;

  public MapView(IDataTranslator dt) {
    super();
    this.dt = dt;
    this.setTitle("Map of Boston");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.refresh();
    this.setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2,
            (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2);

  }


  public void setRenderList(List<IGeoObject> list) {
    this.objects = list;
  }

  public void refresh() {
    this.objects.clear();
    if(college) {
      dt.getObjectsOfType("college");
    }
    if(chargingStation) {

    }
    if(fireHydrant) {

    }
    if(parkingMeter) {

    }
    if(publicLibrary) {

    }
    if(streetLight) {

    }
    if(totspray) {

    }
    if(trafficSignal) {

    }
    if(tree) {

    }
  }

  private void render() {
    this.setLayout(new BorderLayout());

    animationPanel = new AnimationPanel();
    animationPanel.setObjects(objects);
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
