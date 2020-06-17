import java.awt.*;
import java.awt.event.*;

public class Countdown extends WindowAdapter implements ActionListener {
    
    private Frame f;
    private TextField tf;
    private TextArea ta;
    private Button b1, b2;
    private Label l1, l2, l3;

    //Constructor
    private Countdown() {

        f = new Frame("Countdown");

        l1 = new Label("Enter Time limit:");
        l1.setBounds(50,50,160,30);
        l1.setFont(new Font("Ariel",Font.BOLD,20));

        tf = new TextField();
        tf.setBounds(212,50,55,30);
        tf.setFont(new Font("Dialog",Font.PLAIN,20));

        l2 = new Label("secs");
        l2.setBounds(270,50,50,30);
        l2.setFont(new Font("Ariel",Font.BOLD,20));

        l3 = new Label("Time is up!");
        l3.setBounds(135,275,110,30);
        l3.setForeground(Color.RED);
        l3.setFont(new Font("Dialog",Font.BOLD,20));
        l3.setVisible(false);

        b1 = new Button("Reset");
        b1.setBounds(120,100,70,25);
        b1.setFont(new Font("Ariel",Font.BOLD,15));
        b1.addActionListener(this);

        b2 = new Button("Start");
        b2.setBounds(200,100,60,25);
        b2.setFont(new Font("Ariel",Font.BOLD,15));
        b2.addActionListener(this);

        ta = new TextArea();
        ta = new TextArea("",1,1,TextArea.SCROLLBARS_NONE);
        ta.setBounds(140,165,100,100);
        ta.setForeground(Color.BLUE);
        ta.setFont(new Font("Ariel",Font.BOLD,80));
        ta.setVisible(false);

        f.add(tf);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(b1);
        f.add(b2);
        f.add(ta);

        f.setSize(400,340);
        f.setLayout(null);
        f.setBackground(Color.YELLOW);
        f.setVisible(true);
        f.addWindowListener(this);
    }

    //Define the actions to be performed on clicking buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1) {
            tf.setText("");
            ta.setVisible(false);
            l3.setVisible(false);
        }
        else {
            ta.setVisible(true);
            l3.setVisible(false);
            try {
                String n = tf.getText();
                if(n.length() == 0) throw new InvalidLengthException();
                else {  
                    for(int i=Integer.parseInt(n);i>=0;--i) {
                        if(i >= 10) {
                            ta.setText(String.valueOf(i));
                        }
                        else if(i == 0) {
                            ta.setText(" "+String.valueOf(i));
                            l3.setVisible(true);
                        }
                        else {
                            ta.setText(" "+String.valueOf(i));
                        }
                        Thread.sleep(1000);
                    }
                }
            }
            catch(InvalidLengthException i) {
                System.out.println(i);
            }
            catch(InterruptedException j) {}
        }
    }

    //Define the action to be performed on closing the window
    @Override
    public void windowClosing(WindowEvent e) {
        f.dispose();
    }

    //Main method
    public static void main(String args[]) {
        new Countdown();
    }
}

class InvalidLengthException extends Exception {

    @Override
    public String toString() {
        return "Exception: You didn't select Time!";
    }
    
}