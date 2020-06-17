import java.awt.*;
import java.awt.event.*;

public class Counter extends WindowAdapter implements ActionListener {

    private Frame f;
    private TextField t;
    private Button b1, b2, b3;
    private int count = 0;

    //Constructor
    private Counter() {
        
        f = new Frame("Counter");

        t = new TextField();
        t.setBounds(118,60,60,30);
        t.setFont(new Font("Dialog",Font.PLAIN,22));

        b1 = new Button("+");
        b1.setFont(new Font("Ariel",Font.BOLD,30));
        b1.setBounds(95,130,35,35);
        b1.addActionListener(this);

        b2 = new Button("-");
        b2.setFont(new Font("Ariel",Font.BOLD,30));
        b2.setBounds(160,130,35,35);
        b2.addActionListener(this);

        b3 = new Button("Reset");
        b3.setFont(new Font("Ariel",Font.BOLD,20));
        b3.setBounds(95,200,100,30);
        b3.addActionListener(this);

        f.add(t);
        f.add(b1);
        f.add(b2);
        f.add(b3);

        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
        f.addWindowListener(this);
    }

    //Define actions to be performed on clicking buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1) {
            t.setText(String.valueOf(++count));
        }
        else if(e.getSource() == b2) {
            if(count != 0)
                t.setText(String.valueOf(--count));
        }
        else {
            t.setText("");
            count = 0;
        }
    }

    //Define action to be performed on closing the window
    @Override
    public void windowClosing(WindowEvent e) {
        f.dispose();
    }

    //Main method
    public static void main(String args[]) {
        new Counter();
    }
}