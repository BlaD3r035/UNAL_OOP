package PopUpWindows;

import Dir.Directory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateWindow extends JFrame implements ActionListener {
    private JPanel container;


    private JPanel searchPanel;
    private JTextField searchField;
    private JButton searchBtn, cancelBtn;

    private JPanel updatePanel;
    private JTextField nameField, phoneField;
    private JButton updateBtn, backBtn;

    private Directory directory;
    private Directory.Contact foundContact;

    public UpdateWindow(Directory directory) {
        this.directory = directory;
        setTitle("Update Contact");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        start();
    }

    private void start() {
        container = (JPanel) getContentPane();
        container.setLayout(new CardLayout());

        buildSearchPanel();
        buildUpdatePanel();

        container.add(searchPanel, "SEARCH");
        container.add(updatePanel, "UPDATE");

        showPanel("SEARCH");
    }

    private void buildSearchPanel() {
        searchPanel = new JPanel(null);

        JLabel title = new JLabel("Find contact to update:");
        title.setFont(new Font("Arial", Font.BOLD, 13));
        title.setBounds(30, 20, 250, 20);
        searchPanel.add(title);

        JLabel searchLabel = new JLabel("Name:");
        searchLabel.setBounds(30, 60, 80, 25);
        searchPanel.add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(110, 60, 200, 25);
        searchPanel.add(searchField);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(30, 110, 130, 35);
        searchBtn.addActionListener(this);
        searchPanel.add(searchBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(185, 110, 125, 35);
        cancelBtn.addActionListener(this);
        searchPanel.add(cancelBtn);
    }

    private void buildUpdatePanel() {
        updatePanel = new JPanel(null);

        JLabel title = new JLabel("Edit contact info:");
        title.setFont(new Font("Arial", Font.BOLD, 13));
        title.setBounds(30, 20, 250, 20);
        updatePanel.add(title);

        JLabel nameLabel = new JLabel("New Name:");
        nameLabel.setBounds(30, 60, 80, 25);
        updatePanel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(110, 60, 200, 25);
        updatePanel.add(nameField);

        JLabel phoneLabel = new JLabel("New Phone:");
        phoneLabel.setBounds(30, 100, 80, 25);
        updatePanel.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(110, 100, 200, 25);
        updatePanel.add(phoneField);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(30, 150, 130, 35);
        updateBtn.addActionListener(this);
        updatePanel.add(updateBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(185, 150, 125, 35);
        backBtn.addActionListener(this);
        updatePanel.add(backBtn);
    }

    private void showPanel(String name) {
        CardLayout cl = (CardLayout) container.getLayout();
        cl.show(container, name);
        setSize(350, name.equals("UPDATE") ? 240 : 200);
    }

    private void populateUpdateFields() {
        nameField.setText(foundContact.name());
        phoneField.setText(foundContact.phone());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == cancelBtn) { dispose(); return; }

        if (src == searchBtn) {
            String query = searchField.getText().trim();

            if (query.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a name to search.",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                foundContact = directory.readContactName(query);
                populateUpdateFields();
                showPanel("UPDATE");

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this,
                        ex.getMessage(),
                        "Not Found",
                        JOptionPane.WARNING_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "File error: " + ex.getMessage(),
                        "I/O Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        if (src == backBtn) {
            foundContact = null;
            searchField.setText("");
            showPanel("SEARCH");
        }

        if (src == updateBtn) {
            String newName  = nameField.getText().trim();
            String newPhone = phoneField.getText().trim();

            if (newName.isEmpty() || newPhone.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Both fields are required.",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!Directory.isValidInteger(newPhone)) {
                JOptionPane.showMessageDialog(this,
                        "Phone number must be a valid integer.",
                        "Invalid Number",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                if (!newName.equalsIgnoreCase(foundContact.name())
                        && directory.contactExistsByName(newName)) {
                    JOptionPane.showMessageDialog(this,
                            "The name '" + newName + "' is already taken.",
                            "Duplicate Name",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!newPhone.equals(foundContact.phone())
                        && directory.contactExistsByPhone(newPhone)) {
                    JOptionPane.showMessageDialog(this,
                            "The phone '" + newPhone + "' is already taken.",
                            "Duplicate Phone",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!newName.equalsIgnoreCase(foundContact.name())) {
                    directory.deleteContact(foundContact.name());
                    directory.createContact(newName, newPhone);
                } else {
                    directory.updateContact(foundContact.name(), newPhone);
                }

                JOptionPane.showMessageDialog(this,
                        "Contact updated successfully.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.WARNING_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "File error: " + ex.getMessage(),
                        "I/O Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}