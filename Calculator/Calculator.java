import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Calculator extends WindowAdapter implements ActionListener {

    private JFrame f;
    private JPanel p;
    private JTextField tf;
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8;
    private String text = "";
    private float result = 0;
    private Object operator = null;

    //Constructor
    private Calculator() {
        f = new JFrame("Calculator");

        tf = new JTextField();
        tf.setFont(new Font("Ariel", Font.PLAIN, 20));
        tf.setBounds(15,20,257,50);
        tf.setHorizontalAlignment(JTextField.RIGHT);

        p = new JPanel();

        b0 = new JButton("0");
        b0.setFont(new Font("Ariel", Font.BOLD, 18));
        b0.setBackground(Color.WHITE);
        b0.addActionListener(this);

        b1 = new JButton("1");
        b1.setFont(new Font("Ariel", Font.BOLD, 18));
        b1.setBackground(Color.WHITE);
        b1.addActionListener(this);
        
        b2 = new JButton("2");
        b2.setFont(new Font("Ariel", Font.BOLD, 18));
        b2.setBackground(Color.WHITE);
        b2.addActionListener(this);
        
        b3 = new JButton("3");
        b3.setFont(new Font("Ariel", Font.BOLD, 18));
        b3.setBackground(Color.WHITE);
        b3.addActionListener(this);

        b4 = new JButton("4");
        b4.setFont(new Font("Ariel", Font.BOLD, 18));
        b4.setBackground(Color.WHITE);
        b4.addActionListener(this);

        b5 = new JButton("5");
        b5.setFont(new Font("Ariel", Font.BOLD, 18));
        b5.setBackground(Color.WHITE);
        b5.addActionListener(this);

        b6 = new JButton("6");
        b6.setFont(new Font("Ariel", Font.BOLD, 18));
        b6.setBackground(Color.WHITE);
        b6.addActionListener(this);

        b7 = new JButton("7");
        b7.setFont(new Font("Ariel", Font.BOLD, 18));
        b7.setBackground(Color.WHITE);
        b7.addActionListener(this);

        b8 = new JButton("8");
        b8.setFont(new Font("Ariel", Font.BOLD, 18));
        b8.setBackground(Color.WHITE);
        b8.addActionListener(this);

        b9 = new JButton("9");
        b9.setFont(new Font("Ariel", Font.BOLD, 18));
        b9.setBackground(Color.WHITE);
        b9.addActionListener(this);

        bt1 = new JButton("Del");
        bt1.setFont(new Font("Ariel", Font.BOLD, 17));
        bt1.setBackground(Color.WHITE);
        bt1.setForeground(Color.BLUE);
        bt1.addActionListener(this);

        bt2 = new JButton(".");
        bt2.setFont(new Font("Ariel", Font.BOLD, 20));
        bt2.setBackground(Color.WHITE);
        bt2.addActionListener(this);

        bt3 = new JButton("AC");
        bt3.setFont(new Font("Ariel", Font.BOLD, 16));
        bt3.setBackground(Color.WHITE);
        bt3.setForeground(Color.RED);
        bt3.addActionListener(this);

        bt4 = new JButton("/");
        bt4.setFont(new Font("Ariel", Font.PLAIN, 20));
        bt4.setBackground(Color.WHITE);
        bt4.addActionListener(this);

        bt5 = new JButton("*");
        bt5.setFont(new Font("Ariel", Font.PLAIN, 20));
        bt5.setBackground(Color.WHITE);
        bt5.addActionListener(this);

        bt6 = new JButton("-");
        bt6.setFont(new Font("Ariel", Font.PLAIN, 25));
        bt6.setBackground(Color.WHITE);
        bt6.setBounds(210,90,62,62);
        bt6.addActionListener(this);

        bt7 = new JButton("+");
        bt7.setFont(new Font("Ariel", Font.PLAIN, 20));
        bt7.setBackground(Color.WHITE);
        bt7.setBounds(210,157,62,129);
        bt7.addActionListener(this);

        bt8 = new JButton("=");
        bt8.setFont(new Font("Ariel", Font.PLAIN, 20));
        bt8.setBackground(Color.WHITE);
        bt8.setBounds(210,291,62,129);
        bt8.addActionListener(this);

        p.add(bt3);
        p.add(bt4);
        p.add(bt5);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(bt1);
        p.add(b0);
        p.add(bt2);

        p.setLayout(new GridLayout(5,3,5,5));
        p.setBounds(15,90,190,330);

        f.add(tf);
        f.add(p);
        f.add(bt6);
        f.add(bt7);
        f.add(bt8);

        f.addWindowListener(this);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.setSize(303,473);
        f.setLayout(null);
        f.setVisible(true);
    }

    //Define the actions to be performed on button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        
        try {
            if(button == b0) {
                text += "0";
                tf.setText(text);
            }
            else if(button == b1) {
                text += "1";
                tf.setText(text);
            }
            else if(button == b2) {
                text += "2";
                tf.setText(text);
            }
            else if(button == b3) {
                text += "3";
                tf.setText(text);
            }
            else if(button == b4) {
                text += "4";
                tf.setText(text);
            }
            else if(button == b5) {
                text += "5";
                tf.setText(text);
            }
            else if(button == b6) {
                text += "6";
                tf.setText(text);
            }
            else if(button == b7) {
                text += "7";
                tf.setText(text);
            }
            else if(button == b8) {
                text += "8";
                tf.setText(text);
            }
            else if(button == b9) {
                text += "9";
                tf.setText(text);
            }
            else if(button == bt1) {
                text = text.substring(0,text.length()-1);
                tf.setText(text);
            }
            else if(button == bt2) {
                text += ".";
                tf.setText(text);
            }
            else if(button == bt3) {
                result = 0;
                text = "";
                operator = null;
                tf.setText(text);
            }
            else if(button == bt8){
                if(operator == bt4) result /= Float.parseFloat(tf.getText());
                else if(operator == bt5) result *= Float.parseFloat(tf.getText());
                else if(operator == bt6) result -= Float.parseFloat(tf.getText());
                else if(operator == bt7) result += Float.parseFloat(tf.getText());
                else if(operator == null) result += Float.parseFloat(tf.getText());
                int i;
                text = String.valueOf(result);
                for(i=text.length()-1;i>text.indexOf('.');i--) {
                    if(text.charAt(i) == '0') continue;
                }
                if(i == text.indexOf(".")) {
                    tf.setText(String.valueOf((int)result));
                    text = String.valueOf((int)result);
                }
                else tf.setText(String.valueOf(result));
                operator = null;
            }
            else {
                result = Float.parseFloat(tf.getText());
                operator = button;
                text = "";
                tf.setText(text);
            }
        }
        catch(Exception exc) {
            System.out.println(exc.getClass().getCanonicalName());
        }
    }

    //Define the action when window is closed
    @Override
    public void windowClosing(WindowEvent e) {  
        int a = JOptionPane.showConfirmDialog(f, "Are you sure to quit?");  
        if(a == JOptionPane.YES_OPTION){  
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        }  
    }  

    //Main method
    public static void main(String args[]) {
        new Calculator();
    }
}