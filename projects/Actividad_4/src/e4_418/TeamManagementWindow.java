package e4_418;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamManagementWindow extends JFrame implements ActionListener {
    private JPanel container;
    private JTextField devFirstNameField, devLastNameField;
    private JButton addMemberBtn, deleteTeamBtn;
    private JList<String> memberList;
    private DefaultListModel<String> listModel;
    private JLabel teamSizeLabel;

    private Team team;
    private TeamSetupWindow parentWindow;

    public TeamManagementWindow(Team team, TeamSetupWindow parentWindow) {
        this.team = team;
        this.parentWindow = parentWindow;
        start();
        setTitle("Manage Team — " + team.teamName);
        setSize(430, 540);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }

    private void start() {
        container = (JPanel) getContentPane();
        container.setLayout(new BorderLayout(0, 10));
        container.setBorder(new EmptyBorder(15, 15, 15, 15));

        JPanel teamInfoPanel = new JPanel(new GridLayout(3, 2, 8, 6));
        teamInfoPanel.setBorder(BorderFactory.createTitledBorder("Team Info"));
        teamInfoPanel.add(new JLabel("Team:"));
        teamInfoPanel.add(new JLabel(team.teamName));
        teamInfoPanel.add(new JLabel("University:"));
        teamInfoPanel.add(new JLabel(team.university));
        teamInfoPanel.add(new JLabel("Language:"));
        teamInfoPanel.add(new JLabel(team.programmingLanguage));

        JPanel membersPanel = new JPanel(new BorderLayout(5, 5));
        membersPanel.setBorder(BorderFactory.createTitledBorder("Current Members"));
        teamSizeLabel = new JLabel("Members: " + team.teamSize + " / 3");
        membersPanel.add(teamSizeLabel, BorderLayout.NORTH);
        listModel = new DefaultListModel<>();
        refreshMemberList();
        memberList = new JList<>(listModel);
        memberList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        memberList.setFont(new Font("Monospaced", Font.PLAIN, 12));
        membersPanel.add(new JScrollPane(memberList), BorderLayout.CENTER);

        JPanel northWrapper = new JPanel(new BorderLayout(0, 8));
        northWrapper.add(teamInfoPanel, BorderLayout.NORTH);
        northWrapper.add(membersPanel, BorderLayout.CENTER);
        container.add(northWrapper, BorderLayout.NORTH);

        JPanel addPanel = new JPanel(new GridLayout(2, 2, 10, 8));
        addPanel.setBorder(BorderFactory.createTitledBorder("Add Member"));
        addPanel.add(new JLabel("First Name:"));
        devFirstNameField = new JTextField();
        addPanel.add(devFirstNameField);
        addPanel.add(new JLabel("Last Name:"));
        devLastNameField = new JTextField();
        addPanel.add(devLastNameField);
        container.add(addPanel, BorderLayout.CENTER);

        JPanel southWrapper = new JPanel(new BorderLayout(0, 6));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 4));
        addMemberBtn = new JButton("Add Member");
        deleteTeamBtn = new JButton("Delete Team");
        deleteTeamBtn.setForeground(Color.RED);
        addMemberBtn.addActionListener(this);
        deleteTeamBtn.addActionListener(this);
        buttonPanel.add(addMemberBtn);
        buttonPanel.add(deleteTeamBtn);
        southWrapper.add(buttonPanel, BorderLayout.NORTH);

        container.add(southWrapper, BorderLayout.SOUTH);
    }

    private void refreshMemberList() {
        listModel.clear();
        for (int i = 0; i < team.teamSize; i++) {
            Developer d = team.developers[i];
            listModel.addElement((i + 1) + ".  " + d.firstName + " " + d.lastName);
        }

        teamSizeLabel.setText("Members: " + team.teamSize + " / 3");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addMemberBtn) {
            try {
                String firstName = devFirstNameField.getText().trim();
                String lastName  = devLastNameField.getText().trim();

                if (firstName.isEmpty() || lastName.isEmpty()) {
                    throw new IllegalArgumentException("Both first name and last name are required.");
                }

                Team.validateField(firstName);
                Team.validateField(lastName);

                Developer dev = new Developer(firstName, lastName);
                team.addDeveloper(dev);

                devFirstNameField.setText("");
                devLastNameField.setText("");
                refreshMemberList();


            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            }
        }

        if (e.getSource() == deleteTeamBtn) {

                parentWindow.resetSetup();
                dispose();

        }
    }


}