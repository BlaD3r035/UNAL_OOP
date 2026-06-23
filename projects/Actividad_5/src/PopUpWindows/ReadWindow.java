package PopUpWindows;

import Dir.Directory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ReadWindow extends JFrame implements ActionListener {
    private JPanel container;
    private JTextField searchField;
    private JButton searchBtn, cancelBtn;
    private JRadioButton byNameBtn, byPhoneBtn;
    private ButtonGroup searchGroup;
    private Directory directory;

    public ReadWindow(Directory directory) {
        this.directory = directory;
        setTitle("Search Contact");
        setSize(350, 210);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        start();
    }

    private void start() {
        container = (JPanel) getContentPane();
        container.setLayout(null);

        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setBounds(30, 25, 80, 25);
        container.add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(110, 25, 200, 25);
        container.add(searchField);

        byNameBtn = new JRadioButton("By Name");
        byNameBtn.setBounds(30, 65, 100, 25);
        byNameBtn.setSelected(true);
        container.add(byNameBtn);

        byPhoneBtn = new JRadioButton("By Phone");
        byPhoneBtn.setBounds(140, 65, 110, 25);
        container.add(byPhoneBtn);

        searchGroup = new ButtonGroup();
        searchGroup.add(byNameBtn);
        searchGroup.add(byPhoneBtn);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(30, 130, 130, 35);
        searchBtn.addActionListener(this);
        container.add(searchBtn);

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

        if (e.getSource() == searchBtn) {
            String query = searchField.getText().trim();

            if (query.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a search value.",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            try {
                Directory.Contact contact;

                if (byNameBtn.isSelected()) {
                    contact = directory.readContactName(query);
                } else {
                    if (!Directory.isValidInteger(query)) {
                        JOptionPane.showMessageDialog(
                                this,
                                "Phone number must be a valid integer.",
                                "Invalid Number",
                                JOptionPane.ERROR_MESSAGE
                        );
                        return;
                    }
                    contact = directory.readContactPhone(query);
                }

                JOptionPane.showMessageDialog(
                        this,
                        "Name:  " + contact.name() + "\nPhone: " + contact.phone(),
                        "Contact Found",
                        JOptionPane.INFORMATION_MESSAGE
                );
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage(),
                        "Not Found",
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