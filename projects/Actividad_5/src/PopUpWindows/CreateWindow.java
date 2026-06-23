package PopUpWindows;

import javax.swing.*;
import java.awt.*;

public class CreateWindow extends JFrame {
    private JPanel container;
    private JTextField nameField, phoneField;
    private JButton createBtn, cancelBtn;

    public CreateWindow() {
        setTitle("Create Contact");
        setSize(350, 230);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        start();
    }

    private void start() {
        container = (JPanel) getContentPane();
        container.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 25, 80, 25);
        container.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(110, 25, 200, 25);
        container.add(nameField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(30, 70, 80, 25);
        container.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(110, 70, 200, 25);
        container.add(phoneField);

        createBtn = new JButton("Create Contact");
        createBtn.setBounds(30, 130, 140, 35);
        container.add(createBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(185, 130, 125, 35);
        container.add(cancelBtn);
    }
}