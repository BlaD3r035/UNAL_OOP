package e4_406;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

public class SellerWindow extends JFrame implements ActionListener {
    private JPanel container;
    private JLabel firstName, lastName, age;
    private JTextField firstNameField, lastNameField, ageField;
    private JButton calculateBtn;
    private JTextArea resultArea;

    public SellerWindow() {
        start();
        setTitle("Seller Registration");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void start() {
        container = (JPanel) getContentPane();
        container.setBorder(new EmptyBorder(15, 15, 15, 15));

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        firstName = new JLabel("First Name:");
        firstNameField = new JTextField();
        inputPanel.add(firstName);
        inputPanel.add(firstNameField);

        lastName = new JLabel("Last Name:");
        lastNameField = new JTextField();
        inputPanel.add(lastName);
        inputPanel.add(lastNameField);

        age = new JLabel("Age:");
        ageField = new JTextField();
        inputPanel.add(age);
        inputPanel.add(ageField);

        container.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 5));
        calculateBtn = new JButton("Submit");
        buttonPanel.add(calculateBtn);
        calculateBtn.addActionListener(this);

        container.add(buttonPanel, BorderLayout.CENTER);

        resultArea = new JTextArea(6, 20);
        resultArea.setEditable(false);
        resultArea.setMargin(new Insets(8, 8, 8, 8));

        container.add(new JScrollPane(resultArea), BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == calculateBtn) {

            try {
                String fName = firstNameField.getText();
                String lName = lastNameField.getText();

                if (fName.isEmpty() || lName.isEmpty() || ageField.getText().trim().isEmpty()) {
                    throw new IllegalArgumentException("All fields must be filled out.");
                }

                Seller seller = new Seller(fName, lName);
                seller.checkAge(Integer.parseInt(ageField.getText().trim()));

                resultArea.setText(seller.sellerString());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(SellerWindow.this,
                        "Age must be a valid number.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                resultArea.setText("");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(SellerWindow.this,
                        ex.getMessage(),
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE);
                resultArea.setText("");
            }
        }
    }
}
