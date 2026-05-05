import Windows.CylinderWindow;
import Windows.PyramidWindow;
import Windows.SphereWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow2 extends JFrame implements ActionListener {
    private Container container;
    private JButton cylinder, sphere,pyramid;
    public MainWindow2(){
        start();
        setTitle("Shapes");
        setSize(350,160);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    private void start(){
        container = getContentPane();
        container.setLayout(null);

        JLabel title = new JLabel("Select a Shape");
        title.setBounds(100,10,135,23);
        title.setFont(new Font("Serif", Font.BOLD,20));
        container.add(title);

        cylinder = new JButton("Cylinder");
        cylinder.setBounds(20,50,80,25);
        container.add(cylinder);
        cylinder.addActionListener(this);

        sphere = new JButton("sphere");
        sphere.setBounds(125,50,80,25);
        container.add(sphere);
        sphere.addActionListener(this);

        pyramid = new JButton("pyramid");
        pyramid.setBounds(225,50,80,25);
        container.add(pyramid);
        pyramid.addActionListener(this);


    }
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == sphere ){

            SphereWindow sphereWindow = new SphereWindow();
            sphereWindow.setVisible(true);

        }
        if(event.getSource() == cylinder){
            CylinderWindow cylinderWindow = new CylinderWindow();
            cylinderWindow.setVisible(true);
        }
        if(event.getSource() == pyramid){
            PyramidWindow pyramidWindow = new PyramidWindow();
            pyramidWindow.setVisible(true);
        }
    }
}
