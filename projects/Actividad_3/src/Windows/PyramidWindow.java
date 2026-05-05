package Windows;

import Shapes.Pyramid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PyramidWindow extends JFrame implements ActionListener {
    private Container container;
    private JLabel base, height, slantHeight, volume, surface;
    private JTextField baseField, heightField, slantHeightField;
    private JButton calculateBtn;

    public PyramidWindow() {
        start();
        setTitle("Pyramid");
        setSize(300, 240);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void start() {
        container = getContentPane();
        container.setLayout(null);

        base = new JLabel("Base (cms)");
        base.setBounds(20, 20, 135, 23);
        container.add(base);

        baseField = new JTextField();
        baseField.setBounds(140, 20, 135, 23);
        container.add(baseField);

        height = new JLabel("Height (cms)");
        height.setBounds(20, 50, 135, 23);
        container.add(height);

        heightField = new JTextField();
        heightField.setBounds(140, 50, 135, 23);
        container.add(heightField);

        slantHeight = new JLabel("SlantHeight (cms)");
        slantHeight.setBounds(20, 80, 135, 23);
        container.add(slantHeight);

        slantHeightField = new JTextField();
        slantHeightField.setBounds(140, 80, 135, 23);
        container.add(slantHeightField);

        calculateBtn = new JButton("Calculate");
        calculateBtn.setBounds(120, 110, 135, 23);
        calculateBtn.addActionListener(this);
        container.add(calculateBtn);

        volume = new JLabel("Volume (cm3):");
        volume.setBounds(20, 140, 200, 23);
        container.add(volume);

        surface = new JLabel("Surface (cm2):");
        surface.setBounds(20, 170, 200, 23);
        container.add(surface);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        double baseVal = 0;
        double heightVal = 0;
        double slantHeightVal = 0;

        try {
            baseVal = Double.parseDouble(baseField.getText());
            heightVal = Double.parseDouble(heightField.getText());
            slantHeightVal = Double.parseDouble(slantHeightField.getText());

            Pyramid pyramid = new Pyramid(baseVal, heightVal, slantHeightVal);
            volume.setText("Volume (cm3): " + String.format("%.2f", pyramid.calculateVolume()));
            surface.setText("Surface (cm2): " + String.format("%.2f", pyramid.calculateSurface()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Given numbers are not correct");
        }
    }
}