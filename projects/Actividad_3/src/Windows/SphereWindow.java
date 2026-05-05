package Windows;

import Shapes.Sphere;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SphereWindow extends JFrame implements ActionListener {
    private Container container;

    private JLabel radius, volume,surface;
    private JTextField radiusField;
    private JButton calculateBtn;

    public SphereWindow(){
        start();
        setTitle("Sphere");
        setSize(280,200);
        setLocationRelativeTo(null);
        setResizable(false);

    }
    private void start(){
        container = getContentPane();
        container.setLayout(null);

        radius = new JLabel("Radius (cms)");
        radius.setBounds(20,20,135,23);
        container.add(radius);

        radiusField = new JTextField();
        radiusField.setBounds(100,20,135,23);
        container.add(radiusField);

        calculateBtn = new JButton("Calculate");
        calculateBtn.setBounds(100,50,135,23);
        container.add(calculateBtn);
        calculateBtn.addActionListener(this);

        volume = new JLabel("Volume (cm3):");
        volume.setBounds(20, 90, 200, 23);
        container.add(volume);

        surface = new JLabel("Surface (cm2):");
        surface.setBounds(20, 120, 200, 23);
        container.add(surface);

    }
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == calculateBtn){
            try{
                double radius = Double.parseDouble(radiusField.getText());
                Sphere sphere = new Sphere(radius);

                volume.setText("Volume (cm3): " + String.format("%.2f",sphere.calculateVolume()));
                surface.setText("Surface (cm3): " + String.format("%.2f",sphere.calculateSurface()));

            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"given number is not correct");
            }
        }
    }
}
