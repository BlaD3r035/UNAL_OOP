package e4_427;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ReadFileWindow extends JFrame implements ActionListener {
    private JPanel container;
    private JTextField filePathField;
    private JButton selectFileBtn, readFileBtn;
    private JTextArea resultArea;

    public ReadFileWindow() {
        start();
        setTitle("Read File");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void start() {
        container = (JPanel) getContentPane();
        container.setBorder(new EmptyBorder(15, 15, 15, 15));

        JPanel filePanel = new JPanel(new GridLayout(1, 3, 10, 0));
        filePanel.setBorder(BorderFactory.createTitledBorder("File"));

        filePathField = new JTextField();
        filePathField.setEditable(false);

        selectFileBtn = new JButton("Browse...");
        selectFileBtn.addActionListener(this);

        readFileBtn = new JButton("Read");
        readFileBtn.addActionListener(this);

        filePanel.add(filePathField);
        filePanel.add(selectFileBtn);
        filePanel.add(readFileBtn);

        container.add(filePanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        resultArea.setMargin(new Insets(8, 8, 8, 8));

        container.add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectFileBtn) {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new FileNameExtensionFilter("Text files (*.txt)", "txt"));
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                filePathField.setText(chooser.getSelectedFile().getAbsolutePath());
                resultArea.setText("");
            }
        }

        if (e.getSource() == readFileBtn) {
            String path = filePathField.getText().trim();

            if (path.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please select a file first.",
                        "No file selected",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                ReadFile reader = new ReadFile(path);
                resultArea.setText(reader.read());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "Could not read the file.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}