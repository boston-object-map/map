package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;

/**
 * Created by Michael Goodnow on 2019-04-19.
 */

public class ButtonPanel extends JPanel {

  static String[] objectTypes = {
          "EV Charging Stations",
          "Colleges",
          "Fire Hydrants",
          "Parking Meters",
          "Public Libraries",
          "Streetlights",
          "Tot Sprays",
          "Traffic Signals",
          "Trees"
  };

  public ButtonPanel(ItemListener listener) {
    super();

    for (String type : objectTypes) {
      JCheckBox box = new JCheckBox(type);
      box.setSelected(true);
      box.addItemListener(listener);
      this.add(box);
    }
    this.add(Box.createRigidArea(new Dimension(5, 10)));
    JCheckBox box = new JCheckBox("Grayscale");
    box.addItemListener(listener);
    this.add(box);

    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
  }
}
