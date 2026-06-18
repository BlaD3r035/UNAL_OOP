package e4_418;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamSetupWindow extends JFrame implements ActionListener {
    private JPanel container;
    private JTextField teamNameField, universityField, languageField;
    private JTextField dev1FirstField, dev1LastField;
    private JTextField dev2FirstField, dev2LastField;
    private JButton launchBtn;

    public TeamSetupWindow() {
        start();
        setTitle("Team Setup");
        setSize(440, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void start() {
        container = (JPanel) getContentPane();
        container.setLayout(new BorderLayout());
        container.setBorder(new EmptyBorder(15, 15, 15, 15));

        JPanel formWrapper = new JPanel();
        formWrapper.setLayout(new BoxLayout(formWrapper, BoxLayout.Y_AXIS));

        JPanel teamPanel = new JPanel(new GridLayout(3, 2, 10, 8));
        teamPanel.setBorder(BorderFactory.createTitledBorder("Team Info"));
        teamPanel.add(new JLabel("Team Name:"));
        teamNameField = new JTextField();
        teamPanel.add(teamNameField);
        teamPanel.add(new JLabel("University:"));
        universityField = new JTextField();
        teamPanel.add(universityField);
        teamPanel.add(new JLabel("Language:"));
        languageField = new JTextField();
        teamPanel.add(languageField);
        formWrapper.add(teamPanel);
        formWrapper.add(Box.createVerticalStrut(10));

        JPanel dev1Panel = new JPanel(new GridLayout(2, 2, 10, 6));
        dev1Panel.setBorder(BorderFactory.createTitledBorder("Developer 1 (required)"));
        dev1Panel.add(new JLabel("First Name:"));
        dev1FirstField = new JTextField();
        dev1Panel.add(dev1FirstField);
        dev1Panel.add(new JLabel("Last Name:"));
        dev1LastField = new JTextField();
        dev1Panel.add(dev1LastField);
        formWrapper.add(dev1Panel);
        formWrapper.add(Box.createVerticalStrut(10));

        JPanel dev2Panel = new JPanel(new GridLayout(2, 2, 10, 6));
        dev2Panel.setBorder(BorderFactory.createTitledBorder("Developer 2 (required)"));
        dev2Panel.add(new JLabel("First Name:"));
        dev2FirstField = new JTextField();
        dev2Panel.add(dev2FirstField);
        dev2Panel.add(new JLabel("Last Name:"));
        dev2LastField = new JTextField();
        dev2Panel.add(dev2LastField);
        formWrapper.add(dev2Panel);
        formWrapper.add(Box.createVerticalStrut(6));

        container.add(new JScrollPane(formWrapper), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout(0, 5));
        bottomPanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        launchBtn = new JButton("Create Team ");
        launchBtn.addActionListener(this);
        btnPanel.add(launchBtn);
        bottomPanel.add(btnPanel, BorderLayout.NORTH);


        container.add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == launchBtn) {
            try {
                String teamName = teamNameField.getText().trim();
                String university = universityField.getText().trim();
                String language = languageField.getText().trim();

                if (teamName.isEmpty() || university.isEmpty() || language.isEmpty()) {
                    throw new IllegalArgumentException("All team fields must be filled out.");
                }

                String d1First = dev1FirstField.getText().trim();
                String d1Last  = dev1LastField.getText().trim();
                String d2First = dev2FirstField.getText().trim();
                String d2Last  = dev2LastField.getText().trim();

                if (d1First.isEmpty() || d1Last.isEmpty() || d2First.isEmpty() || d2Last.isEmpty()) {
                    throw new IllegalArgumentException("Both required developers must be filled out.");
                }

                Team.validateField(d1First);
                Team.validateField(d1Last);
                Team.validateField(d2First);
                Team.validateField(d2Last);

                Team team = new Team(teamName, university, language);
                team.addDeveloper(new Developer(d1First, d1Last));
                team.addDeveloper(new Developer(d2First, d2Last));

                setVisible(false);
                TeamManagementWindow manager = new TeamManagementWindow(team, this);
                manager.setVisible(true);

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void resetSetup() {
        teamNameField.setText("");
        universityField.setText("");
        languageField.setText("");
        dev1FirstField.setText("");
        dev1LastField.setText("");
        dev2FirstField.setText("");
        dev2LastField.setText("");
        setVisible(true);
    }
}