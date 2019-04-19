package View;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import GeoObjects.IGeoObject;
import Model.IDataTranslator;

public class MapView extends JFrame {

  private List<IGeoObject> objects = new ArrayList<>();
  private AnimationPanel animationPanel;
  private IDataTranslator dt;

  //These keep track of what objects we are rendering.
  boolean college = true, chargingStation = true, fireHydrant = true, parkingMeter = true,
          publicLibrary = true, streetLight = true, totspray = true, trafficSignal = true, tree = true;

  public MapView(IDataTranslator dt) {
    super();
    this.dt = dt;
    this.setTitle("Map of Boston");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.refresh();
    this.setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
            (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
  }

  public void refresh() {
    this.objects.clear();
    if(college) {
      this.objects.addAll(dt.getObjectsOfType("college"));
    }
    if(chargingStation) {
      this.objects.addAll(dt.getObjectsOfType("chargingstation"));
    }
    if(fireHydrant) {
      this.objects.addAll(dt.getObjectsOfType("firehydrant"));
    }
    if(parkingMeter) {
      this.objects.addAll(dt.getObjectsOfType("parkingmeter"));
    }
    if(publicLibrary) {
      this.objects.addAll(dt.getObjectsOfType("publiclibrary"));
    }
    if(streetLight) {
      this.objects.addAll(dt.getObjectsOfType("streetlight"));
    }
    if(totspray) {
      this.objects.addAll(dt.getObjectsOfType("totspray"));
    }
    if(trafficSignal) {
      this.objects.addAll(dt.getObjectsOfType("trafficsignal"));
    }
    if(tree) {
      this.objects.addAll(dt.getObjectsOfType("tree"));
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
    this.setVisible(true);
  }

  public void run() {
    render();
  }
}
