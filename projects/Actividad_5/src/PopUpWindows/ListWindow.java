package PopUpWindows;

import Dir.Directory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ListWindow extends JFrame implements ActionListener {
    private JPanel container;
    private JTable contactTable;
    private JScrollPane scrollPane;
    private JButton closeBtn, refreshBtn;
    private Directory directory;

    public ListWindow(Directory directory) {
        this.directory = directory;
        setTitle("Contact List");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        start();
        loadContacts();
    }

    private void start() {
        container = (JPanel) getContentPane();
        container.setLayout(null);

        JLabel title = new JLabel("All Contacts", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 14));
        title.setBounds(0, 10, 400, 25);
        container.add(title);

        String[] columns = { "Name", "Phone" };
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };

        contactTable = new JTable(model);
        contactTable.setRowHeight(25);
        contactTable.getTableHeader().setReorderingAllowed(false);

        scrollPane = new JScrollPane(contactTable);
        scrollPane.setBounds(30, 50, 330, 210);
        container.add(scrollPane);

        refreshBtn = new JButton("Refresh");
        refreshBtn.setBounds(30, 275, 150, 35);
        refreshBtn.addActionListener(this);
        container.add(refreshBtn);

        closeBtn = new JButton("Close");
        closeBtn.setBounds(210, 275, 150, 35);
        closeBtn.addActionListener(this);
        container.add(closeBtn);
    }

    private void loadContacts() {
        DefaultTableModel model = (DefaultTableModel) contactTable.getModel();
        model.setRowCount(0);

        try {
            List<Directory.Contact> contacts = directory.getAllContacts();

            if (contacts.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No contacts found.",
                        "Empty Directory",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            for (Directory.Contact c : contacts) {
                model.addRow(new Object[]{ c.name(), c.phone() });
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "File error: " + ex.getMessage(),
                    "I/O Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closeBtn)   { dispose(); }
        if (e.getSource() == refreshBtn) { loadContacts(); }
    }
}