import PopUpWindows.CreateWindow;
import PopUpWindows.DeleteWindow;
import PopUpWindows.ReadWindow;
import PopUpWindows.UpdateWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {
    private JPanel container;
    private JButton createBtn, readBtn, updateBtn, deleteBtn;

    public MainWindow() {
        setTitle("");
        setSize(450, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        start();
    }

    private void start() {
        container = (JPanel) getContentPane();
        container.setLayout(null);

        JLabel title = new JLabel("Your Directory! \uD83D\uDCDA", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(100, 10, 250, 40);
        container.add(title);

        createBtn = new JButton("Create");
        createBtn.setBounds(30, 70, 170, 40);
        container.add(createBtn);
        createBtn.addActionListener(this);

        readBtn = new JButton("Read");
        readBtn.setBounds(240, 70, 170, 40);
        container.add(readBtn);
        readBtn.addActionListener(this);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(30, 130, 170, 40);
        container.add(updateBtn);
        updateBtn.addActionListener(this);

        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(240, 130, 170, 40);
        container.add(deleteBtn);
        deleteBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == createBtn){
            CreateWindow cWindow = new CreateWindow();
            cWindow.setVisible(true);

        }
        if(e.getSource() == readBtn){
            ReadWindow rWindow = new ReadWindow();
            rWindow.setVisible(true);
        }
        if(e.getSource() == updateBtn){
            UpdateWindow uWindow = new UpdateWindow();
            uWindow.setVisible(true);

        }
        if(e.getSource() == deleteBtn){
            DeleteWindow dWindow = new DeleteWindow();
            dWindow.setVisible(true);
        }

    }


}