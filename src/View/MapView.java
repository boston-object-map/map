package View;

import GeoObjects.ChargingStation;
import GeoObjects.IGeoObject;
import Model.IDataTranslator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class MapView extends JFrame implements ItemListener {

  private List<IGeoObject> objects = new ArrayList<>();
  private AnimationPanel animationPanel;
  private IDataTranslator dt;


  //These keep track of what objects we are rendering. Direct mutation from
  private boolean college = true,
          chargingStation = true,
          fireHydrant = true,
          parkingMeter = true,
          publicLibrary = true,
          streetLight = true,
          totspray = true,
          trafficSignal = true,
          tree = true;

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
    this.repaint();
  }

  public void render() {
    this.setLayout(new BorderLayout());

    animationPanel = new AnimationPanel();
    animationPanel.setObjects(objects);
    animationPanel.setPreferredSize(new Dimension(7693, 4087));
    JScrollPane visualScrollPane = new JScrollPane(animationPanel,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    this.add(visualScrollPane, BorderLayout.CENTER);
    ButtonPanel buttonPanel = new ButtonPanel(this);
    this.add(buttonPanel, BorderLayout.WEST);

    this.setVisible(true);
  }

  @Override
  public void itemStateChanged(ItemEvent e) {
    boolean newState = e.getStateChange() == ItemEvent.SELECTED;
    switch (((JCheckBox)e.getItem()).getText()) {
      case ("EV Charging Stations"):
        this.chargingStation = newState;
        break;
      case ("Colleges"):
        this.college = newState;
        break;
      case("Fire Hydrants"):
        this.fireHydrant = newState;
        break;
      case("Parking Meters"):
        this.parkingMeter = newState;
        break;
      case("Public Libraries"):
        this.publicLibrary = newState;
        break;
      case("Streetlights"):
        this.streetLight = newState;
        break;
      case("Tot Sprays"):
        this.totspray = newState;
        break;
      case("Traffic Signals"):
        this.trafficSignal = newState;
        break;
      case("Trees"):
        this.tree = newState;
        break;
      case("Grayscale"):
        this.animationPanel.setBW(newState);
        this.repaint();
        return;
    }
    this.refresh();
  }
}
