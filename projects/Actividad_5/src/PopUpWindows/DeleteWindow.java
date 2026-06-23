package PopUpWindows;

import javax.swing.*;
import java.awt.*;

public class DeleteWindow extends JFrame {
    private JPanel container;
    private JTextField nameField, phoneField;
    private JButton deleteBtn, cancelBtn;

    public DeleteWindow() {
        setTitle("Delete Contact");
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

        JLabel noteLabel = new JLabel("* Fill at least one field");
        noteLabel.setFont(new Font("Arial", Font.ITALIC, 11));
        noteLabel.setForeground(Color.GRAY);
        noteLabel.setBounds(30, 105, 200, 20);
        container.add(noteLabel);

        deleteBtn = new JButton("Delete Contact");
        deleteBtn.setBounds(30, 140, 140, 35);
        container.add(deleteBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(185, 140, 125, 35);
        container.add(cancelBtn);
    }
}