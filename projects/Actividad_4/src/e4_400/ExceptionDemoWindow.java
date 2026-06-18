package e4_400;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExceptionDemoWindow extends JFrame implements ActionListener {
    private JButton rerunBtn;
    private JTextArea resultArea;

    public ExceptionDemoWindow() {
        start();
        setTitle("Exception Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void start() {
        JPanel container = (JPanel) getContentPane();
        container.setBorder(new EmptyBorder(15, 15, 15, 15));

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        resultArea.setMargin(new Insets(8, 8, 8, 8));
        container.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 8));
        rerunBtn = new JButton("Run Again");
        rerunBtn.addActionListener(this);
        buttonPanel.add(rerunBtn);
        container.add(buttonPanel, BorderLayout.SOUTH);

        runDemo();
    }

    private void runDemo() {
        resultArea.setText("");
        for (String line : ExceptionDemo.runFirstBlock()) resultArea.append(line + "\n");
        resultArea.append("\n");
        for (String line : ExceptionDemo.runSecondBlock()) resultArea.append(line + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rerunBtn) {
            runDemo();
        }
    }
}