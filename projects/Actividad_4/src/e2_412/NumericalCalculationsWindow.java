package e2_412;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumericalCalculationsWindow extends JFrame implements ActionListener {

    private JTextField valueField;
    private JButton calculateBtn;
    private JTextArea resultArea;

    public NumericalCalculationsWindow() {
        setTitle("Simple Calculator");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Enter Value:"));

        valueField = new JTextField(10);
        topPanel.add(valueField);

        calculateBtn = new JButton("Calculate");
        calculateBtn.addActionListener(this);
        topPanel.add(calculateBtn);

        add(topPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setMargin(new Insets(10, 10, 10, 10));

        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateBtn) {
            try {
                double value = Double.parseDouble(valueField.getText().trim());

                double lnResult = NumericalCalculations.calculateNapierianLogarithm(value);
                double sqrtResult = NumericalCalculations.calculateSquareRoot(value);

                resultArea.setText("ln(" + value + ") = " + lnResult + "\n");
                resultArea.append("√" + value + " = " + sqrtResult);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a valid number.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                resultArea.setText("");

            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(this,
                        ex.getMessage(),
                        "Math Error",
                        JOptionPane.ERROR_MESSAGE);
                resultArea.setText("");
            }
        }
    }
}