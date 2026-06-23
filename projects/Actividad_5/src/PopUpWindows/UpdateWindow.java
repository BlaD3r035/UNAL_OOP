package PopUpWindows;

import javax.swing.*;
import java.awt.*;

public class UpdateWindow extends JFrame {
    private JPanel container;
    private JComboBox<String> contactList;
    private JTextField nameField, phoneField;
    private JButton updateBtn, cancelBtn;

    public UpdateWindow() {
        setTitle("Update Contact");
        setSize(350, 270);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        start();
    }

    private void start() {
        container = (JPanel) getContentPane();
        container.setLayout(null);

        JLabel selectLabel = new JLabel("Contact:");
        selectLabel.setBounds(30, 25, 80, 25);
        container.add(selectLabel);

        contactList = new JComboBox<>();
        contactList.setBounds(110, 25, 200, 25);
        container.add(contactList);

        JLabel nameLabel = new JLabel("New Name:");
        nameLabel.setBounds(30, 75, 80, 25);
        container.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(110, 75, 200, 25);
        container.add(nameField);

        JLabel phoneLabel = new JLabel("New Phone:");
        phoneLabel.setBounds(30, 120, 80, 25);
        container.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(110, 120, 200, 25);
        container.add(phoneField);

        updateBtn = new JButton("Update Contact");
        updateBtn.setBounds(30, 180, 140, 35);
        container.add(updateBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(185, 180, 125, 35);
        container.add(cancelBtn);
    }
}