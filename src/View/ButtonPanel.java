package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Michael Goodnow on 2019-04-19.
 */

public class ButtonPanel extends JPanel {

  public ButtonPanel() {
    super();
    JCheckBox box = null;
    box = new JCheckBox("EV Charging Stations");
    box.setSelected(true);
    this.add(box);
    box = new JCheckBox("EV Charging Stations");
    box.setSelected(true);
    this.add(box);
    box = new JCheckBox("Colleges");
    box.setSelected(true);
    this.add(box);
    box = new JCheckBox("Fire Hydrants");
    box.setSelected(true);
    this.add(box);
    box = new JCheckBox("Parking Meters");
    box.setSelected(true);
    this.add(box);
    box = new JCheckBox("Public Libraries");
    box.setSelected(true);
    this.add(box);
    box = new JCheckBox("Streetlights");
    box.setSelected(true);
    this.add(box);
    box = new JCheckBox("Tot Sprays");
    box.setSelected(true);
    this.add(box);
    box = new JCheckBox("Traffic Signals");
    box.setSelected(true);
    this.add(box);
    box = new JCheckBox("Trees");
    box.setSelected(true);
    this.add(box);
    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
  }
}
