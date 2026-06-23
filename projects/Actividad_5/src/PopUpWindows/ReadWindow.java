package PopUpWindows;

import javax.swing.*;
import java.awt.*;

public class ReadWindow extends JFrame {
    private JPanel container;
    private JTextField searchField;
    private JButton searchBtn, cancelBtn;

    public ReadWindow() {
        setTitle("Search Contact");
        setSize(350, 160);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        start();
    }

    private void start() {
        container = (JPanel) getContentPane();
        container.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 80, 25);
        container.add(nameLabel);

        searchField = new JTextField();
        searchField.setBounds(110, 30, 200, 25);
        container.add(searchField);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(30, 80, 130, 35);
        container.add(searchBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(185, 80, 125, 35);
        container.add(cancelBtn);
    }
}