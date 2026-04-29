import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {
    private Container container;
    private JLabel mark1,mark2,mark3,mark4,mark5,average,deviation,higher,lower;
    private JTextField mark1Field,mark2Field,mark3Field,mark4Field,mark5Field;
    private JButton calculateBtn, clearBtn;
    public MainWindow(){
        startWindow();
        setTitle("Marks");
        setSize(280,410);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    private void startWindow(){
        container = getContentPane();
        container.setLayout(null);

        JLabel title = new JLabel("Final Score");
        title.setBounds(84,5,135,23);
        title.setFont(new Font("Serif", Font.BOLD,20));
        container.add(title);

        mark1 = new JLabel();
        mark1.setText("Mark 1");
        mark1.setBounds(20,40,135,23);
        mark1Field = new JTextField();
        mark1Field.setBounds(105,40,135,23);
        container.add(mark1);
        container.add(mark1Field);

        mark2 = new JLabel();
        mark2.setText("Mark 2");
        mark2.setBounds(20,70,135,23);
        mark2Field = new JTextField();
        mark2Field.setBounds(105,70,135,23);
        container.add(mark2);
        container.add(mark2Field);

        mark3 = new JLabel();
        mark3.setText("Mark 3");
        mark3.setBounds(20,100,135,23);
        mark3Field = new JTextField();
        mark3Field.setBounds(105,100,135,23);
        container.add(mark3);
        container.add(mark3Field);

        mark4 = new JLabel();
        mark4.setText("Mark 4");
        mark4.setBounds(20,130,135,23);
        mark4Field = new JTextField();
        mark4Field.setBounds(105,130,135,23);
        container.add(mark4);
        container.add(mark4Field);

        mark5 = new JLabel();
        mark5.setText("Mark 5");
        mark5.setBounds(20,160,135,23);
        mark5Field = new JTextField();
        mark5Field.setBounds(105,160,135,23);
        container.add(mark5);
        container.add(mark5Field);

        calculateBtn = new JButton();
        calculateBtn.setText("Calculate");
        calculateBtn.setBounds(20,210,100,23);
        container.add(calculateBtn);
        calculateBtn.addActionListener(this);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(140,210,80,23);
        container.add(clearBtn);
        clearBtn.addActionListener(this);

        JLabel sub = new JLabel("Result:");
        sub.setFont(new Font("Serif", Font.BOLD, 16));
        sub.setBounds(20, 240 ,135,23);
        container.add((sub));

        average = new JLabel("Average = ");
        average.setBounds(20,260,135,23);
        container.add(average);
        deviation = new JLabel("Deviation = ");
        deviation.setBounds(20,280,135,23);
        container.add(deviation);
        higher = new JLabel("Higher = ");
        higher.setBounds(20,300,135,23);
        container.add(higher);
        lower = new JLabel("Lower = ");
        lower.setBounds(20,320,135,23);
        container.add(lower);

    }
    @Override
    public void actionPerformed(ActionEvent event){
       if(event.getSource() == clearBtn){
           mark1Field.setText("");
           mark2Field.setText("");
           mark3Field.setText("");
           mark4Field.setText("");
           mark5Field.setText("");
       }

       if(event.getSource() == calculateBtn){
           Marks marks = new Marks();
           marks.markList[0] = Double.parseDouble(mark1Field.getText());
           marks.markList[1] = Double.parseDouble(mark2Field.getText());
           marks.markList[2] = Double.parseDouble(mark3Field.getText());
           marks.markList[3] = Double.parseDouble(mark4Field.getText());
           marks.markList[4] = Double.parseDouble(mark5Field.getText());

           average.setText("Average = " + String.valueOf(String.format("%.2f", marks.calculateAverage())));
           deviation.setText("Deviation = " + String.valueOf(String.format("%.2f", marks.standardDeviation())));
           higher.setText("Higher = " + String.valueOf(String.format("%.2f", marks.higher())));
           lower.setText("Lower = " + String.valueOf(String.format("%.2f", marks.lower())));
       }
    }

    private boolean isAllFieldsCorrect(){
        // <--Todo-->
        //  field types and empty fields alerts
        return true;
    }
}
