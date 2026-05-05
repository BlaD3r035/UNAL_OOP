package Windows;

import Shapes.Cylinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CylinderWindow  extends JFrame implements ActionListener {
    private Container container;
    private JLabel radius, height, volume, surface;
    private JTextField radiusField, heightField;
    private JButton calculateBtn;

    public CylinderWindow(){
        start();
        setTitle("Cylinder");
        setSize(280,210);
        setLocationRelativeTo(null);
        setResizable(false);

    }
    private void start(){
        container = getContentPane();
        container.setLayout(null);

        radius = new JLabel("Radius (cms)");
        radius.setBounds(20, 20, 135, 23);
        container.add(radius);

        radiusField = new JTextField();
        radiusField.setBounds(100, 20, 135, 23);
        container.add(radiusField);

        height = new JLabel("Height (cms)");
        height.setBounds(20, 50, 135, 23);
        container.add(height);

        heightField = new JTextField();
        heightField.setBounds(100, 50, 135, 23);
        container.add(heightField);

        calculateBtn = new JButton("Calculate");
        calculateBtn.setBounds(100, 80, 135, 23);
        calculateBtn.addActionListener(this);
        container.add(calculateBtn);

        volume = new JLabel("Volume (cm3):");
        volume.setBounds(20, 110, 200, 23);
        container.add(volume);

        surface = new JLabel("Surface (cm2):");
        surface.setBounds(20, 140, 200, 23);
        container.add(surface);
    }
    @Override
    public void actionPerformed(ActionEvent event){
        double radius = 0;
        double height = 0;

        try {
            radius = Double.parseDouble(radiusField.getText());
            height = Double.parseDouble(heightField.getText());

            Cylinder cylinder = new Cylinder(radius,height);
            volume.setText("Volume (cm3): " + String.format("%.2f",cylinder.calculateVolume()));
            surface.setText("Surface (cm3): " + String.format("%.2f",cylinder.calculateSurface()));
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"given numbers are not correct");
        }
    }
}
