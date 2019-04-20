package View;

import GeoObjects.*;
import Model.IDataTranslator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The user interface for our map.
 */
public class MapView extends JFrame implements ItemListener, ActionListener {

  private List<IGeoObject> objects = new ArrayList<>();
  private AnimationPanel animationPanel;
  private IDataTranslator dt;
  final Map<String, Class<? extends AGeoObject>> typeMap = new HashMap<>();


  //These keep track of what objects we are rendering.
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
    this.typeMap.put("EV Charging Stations", ChargingStation.class);
    this.typeMap.put("Colleges", College.class);
    this.typeMap.put("Fire Hydrants", FireHydrant.class);
    this.typeMap.put("Parking Meters", ParkingMeter.class);
    this.typeMap.put("Public Libraries", PublicLibrary.class);
    this.typeMap.put("Streetlights", Streetlight.class);
    this.typeMap.put("Tot Sprays", TotSpray.class);
    this.typeMap.put("Traffic Signals", TrafficSignal.class);
    this.typeMap.put("Trees", Tree.class);
  }

  /**
   * Gathers data from DB dependent upon what needs to be rendered.
   */
  public void refresh() {
    this.objects.clear();
    if (college) {
      this.objects.addAll(dt.getObjectsOfType("college"));
    }
    if (chargingStation) {
      this.objects.addAll(dt.getObjectsOfType("chargingstation"));
    }
    if (fireHydrant) {
      this.objects.addAll(dt.getObjectsOfType("firehydrant"));
    }
    if (parkingMeter) {
      this.objects.addAll(dt.getObjectsOfType("parkingmeter"));
    }
    if (publicLibrary) {
      this.objects.addAll(dt.getObjectsOfType("publiclibrary"));
    }
    if (streetLight) {
      this.objects.addAll(dt.getObjectsOfType("streetlight"));
    }
    if (totspray) {
      this.objects.addAll(dt.getObjectsOfType("totspray"));
    }
    if (trafficSignal) {
      this.objects.addAll(dt.getObjectsOfType("trafficsignal"));
    }
    if (tree) {
      this.objects.addAll(dt.getObjectsOfType("tree"));
    }
    this.repaint();
  }

  /**
   * Draws the objects on the map.
   */
  public void render() {
    this.setLayout(new BorderLayout());

    animationPanel = new AnimationPanel();
    animationPanel.setObjects(objects);
    JScrollPane visualScrollPane = new JScrollPane(
            animationPanel,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    visualScrollPane.getHorizontalScrollBar().setUnitIncrement(32);
    visualScrollPane.getVerticalScrollBar().setUnitIncrement(32);

    this.add(visualScrollPane, BorderLayout.CENTER);
    ButtonPanel buttonPanel = new ButtonPanel(this, this, this.typeMap);
    JScrollPane buttonScroller = new JScrollPane(
            buttonPanel,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    buttonScroller.getVerticalScrollBar().setUnitIncrement(16);
    this.add(buttonScroller, BorderLayout.WEST);
    this.setPreferredSize(new Dimension(1500, 1000));
    this.pack();
    this.setVisible(true);
  }

  @Override
  public void itemStateChanged(ItemEvent e) {
    boolean newState = e.getStateChange() == ItemEvent.SELECTED;
    switch (((JCheckBox) e.getItem()).getText()) {
      case ("EV Charging Stations"):
        this.chargingStation = newState;
        break;
      case ("Colleges"):
        this.college = newState;
        break;
      case ("Fire Hydrants"):
        this.fireHydrant = newState;
        break;
      case ("Parking Meters"):
        this.parkingMeter = newState;
        break;
      case ("Public Libraries"):
        this.publicLibrary = newState;
        break;
      case ("Streetlights"):
        this.streetLight = newState;
        break;
      case ("Tot Sprays"):
        this.totspray = newState;
        break;
      case ("Traffic Signals"):
        this.trafficSignal = newState;
        break;
      case ("Trees"):
        this.tree = newState;
        break;
      case ("Grayscale"):
        this.animationPanel.setBW(newState);
        this.repaint();
        return;
    }
    this.refresh();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() instanceof JButton) {
      switch (e.getActionCommand()) {
        case ("+"):
          if(this.animationPanel.scaleFactor < 26) {
            this.animationPanel.scaleFactor *= 1.5;
            this.animationPanel.scaleDimensions();
          }
          break;
        case ("-"):
          if(animationPanel.scaleFactor > 0.5) {
            this.animationPanel.scaleFactor /= 1.5;
          }
          break;
      }
      this.animationPanel.scaleDimensions();
    } else {
      JTextField field = (JTextField) e.getSource();
      try {
        String prop = field.getClientProperty("property").toString();
        String type = field.getClientProperty("type").toString();
        Class<? extends AGeoObject> cls = this.typeMap.get(type);

        if (prop.equals("SIZE")) {
          cls.getField("SIZE")
                  .set(null, new Integer(e.getActionCommand()));
        } else {
          cls.getField("COLOR").set(null, Color.decode(e.getActionCommand()));
        }

      } catch (IllegalAccessException | NoSuchFieldException e1) {
        e1.printStackTrace();
      }
    }

    this.repaint();
  }
}
