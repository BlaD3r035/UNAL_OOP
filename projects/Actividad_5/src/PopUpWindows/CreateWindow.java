package PopUpWindows;

import Dir.Directory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CreateWindow extends JFrame implements ActionListener {
    private JPanel container;
    private JTextField nameField, phoneField;
    private JButton createBtn, cancelBtn;
    private Directory directory;

    public CreateWindow(Directory directory) {
        this.directory = directory;
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
        createBtn.addActionListener(this);
        container.add(createBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(185, 130, 125, 35);
        cancelBtn.addActionListener(this);
        container.add(cancelBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelBtn) {
            dispose();
            return;
        }

        if (e.getSource() == createBtn) {
            String name  = nameField.getText().trim();
            String phone = phoneField.getText().trim();

            if (name.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Both fields are required.",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if(!Directory.isValidInteger(phone)){
                JOptionPane.showMessageDialog(this,
                        "Phone number must be a valid integer",
                        "Invalid number",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                directory.createContact(name, phone);
                JOptionPane.showMessageDialog(
                        this,
                        "Contact '" + name + "' created successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage(),
                        "Duplicate Contact",
                        JOptionPane.WARNING_MESSAGE
                );
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "File error: " + ex.getMessage(),
                        "I/O Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}