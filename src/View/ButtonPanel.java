package View;

import GeoObjects.AGeoObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Map;

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

  public ButtonPanel(ItemListener itemListener,
                     ActionListener actionListener,
                     Map<String, Class<? extends AGeoObject>> typeMap) {
    super();

    // filtering boxes
    for (String type : objectTypes) {
      JCheckBox box = new JCheckBox(type);
      box.setSelected(true);
      box.addItemListener(itemListener);
      this.add(box);
    }

    this.add(Box.createRigidArea(new Dimension(5, 10)));

    // grayscale box
    JCheckBox gsBox = new JCheckBox("Grayscale");
    gsBox.addItemListener(itemListener);
    this.add(gsBox);

    this.add(Box.createRigidArea(new Dimension(5, 10)));

    // COLOR boxes
    JPanel colorsPanel = new JPanel(new GridLayout(0, 2));
    colorsPanel.add(new JLabel("Colors"));
    colorsPanel.add(Box.createRigidArea(new Dimension(0, 0)));
    for (String type : objectTypes) {
      try {
        Class<? extends AGeoObject> cls = typeMap.get(type);
        Color c = ((Color) cls.getField("COLOR").get(null));
        JTextField field = new JTextField(String.format("#%02X%02X%02X", c.getRed(), c.getGreen(), c.getBlue()));
        field.putClientProperty("type", type);
        field.putClientProperty("property", "COLOR");
        JLabel fieldLabel = new JLabel(type);
        fieldLabel.setLabelFor(field);
        field.addActionListener(actionListener);
        colorsPanel.add(field);
        colorsPanel.add(fieldLabel);
      } catch (IllegalAccessException | NoSuchFieldException e1) {
        e1.printStackTrace();
      }
    }
    colorsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    this.add(colorsPanel);

    this.add(Box.createRigidArea(new Dimension(5, 10)));

    // size boxes
    JPanel sizesPanel = new JPanel(new GridLayout(0, 2));
    sizesPanel.add(new JLabel("Sizes"));
    sizesPanel.add(Box.createRigidArea(new Dimension(0, 0)));
    for (String type : objectTypes) {
      try {
        Class<? extends AGeoObject> cls = typeMap.get(type);
        Integer size = (Integer) cls.getField("SIZE").get(null);
        JTextField field = new JTextField(size.toString());
        field.putClientProperty("type", type);
        field.putClientProperty("property", "SIZE");
        JLabel fieldLabel = new JLabel(type);
        fieldLabel.setLabelFor(field);
        field.addActionListener(actionListener);
        sizesPanel.add(field);
        sizesPanel.add(fieldLabel);
      } catch (IllegalAccessException | NoSuchFieldException e) {
        e.printStackTrace();
      }
    }
    sizesPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    this.add(sizesPanel);

    JPanel zoomPanel = new JPanel();
    zoomPanel.add(new JLabel("Zoom"));
    sizesPanel.add(Box.createRigidArea(new Dimension(0, 0)));
    JButton zoomInButton = new JButton("+");
    JButton zoomOutButton = new JButton("-");
    zoomInButton.addActionListener(actionListener);
    zoomOutButton.addActionListener(actionListener);
    zoomPanel.add(zoomInButton);
    zoomPanel.add(zoomOutButton);
    this.add(zoomPanel);
    zoomPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    this.add(Box.createVerticalGlue());

    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }
}
