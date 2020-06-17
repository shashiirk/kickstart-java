import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp extends WindowAdapter implements ActionListener {

    private JFrame f;
    private JTextField tf1, tf2;
    private JPasswordField pf;
    private JLabel l1, l2, l3;
    private JLabel msg1, msg2, msg3, msg4;
    private JButton b1, b2, b3, b4;
    private JDialog d;

    //Constructor that initializes the GUI widget
    private SignUp() {
        f = new JFrame("SignUp Page");

        l1 = new JLabel("FULL NAME");
        l1.setFont(new Font("Ariel",Font.PLAIN,16));
        l1.setBounds(50,100,90,20);
        
        tf1 = new JTextField();
        tf1.setFont(new Font("Dialog",Font.PLAIN,15));
        tf1.setBounds(150,100,250,25);
        
        l2 = new JLabel("EMAIL");
        l2.setFont(new Font("Ariel",Font.PLAIN,16));
        l2.setBounds(50,180,50,20);
        
        tf2 = new JTextField();
        tf2.setFont(new Font("Dialog",Font.PLAIN,15));
        tf2.setBounds(150,180,250,25);
        
        l3 = new JLabel("PASSWORD");
        l3.setFont(new Font("Ariel",Font.PLAIN,16));
        l3.setBounds(50,260,95,20);
        
        pf = new JPasswordField();
        pf.setBounds(150,260,250,25);
        
        b1 = new JButton("Reset");
        b1.setFont(new Font("Ariel",Font.PLAIN,16));
        b1.setBounds(120,360,90,30);
        b1.addActionListener(this);
        
        b2 = new JButton("Signup");
        b2.setFont(new Font("Ariel",Font.PLAIN,16));
        b2.setBounds(260,360,90,30);
        b2.addActionListener(this);
        
        msg1 = new JLabel("*Please provide a valid name!");
        msg1.setBounds(50,125,250,20);
        msg1.setFont(new Font("Dialog",Font.PLAIN,15));
        msg1.setForeground(Color.RED);
        msg1.setVisible(false);
        
        msg2 = new JLabel("*Please provide a valid e-mail address!");
        msg2.setBounds(50,205,260,20);
        msg2.setFont(new Font("Dialog",Font.PLAIN,15));
        msg2.setForeground(Color.RED);
        msg2.setVisible(false);
        
        msg3 = new JLabel("*Please provide a strong password!");
        msg3.setBounds(50,285,400,20);
        msg3.setFont(new Font("Dialog",Font.PLAIN,15));
        msg3.setForeground(Color.RED);
        msg3.setVisible(false);
        
        msg4 = new JLabel("Account created Successfully...");
        msg4.setBounds(100,450,300,20);
        msg4.setFont(new Font("Dialog",Font.PLAIN,20));
        msg4.setForeground(Color.BLUE);
        msg4.setVisible(false);
        
        f.add(msg4);
        f.add(msg3);
        f.add(msg2);
        f.add(msg1);
        
        f.add(l1);
        f.add(l2);
        f.add(l3);
        
        f.add(tf1);
        f.add(tf2);
        
        f.add(pf);
        
        f.add(b1);
        f.add(b2);
        
        f.addWindowListener(this);
        
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.setSize(485,600);
        f.setLayout(null);
        f.setVisible(true);
    }

    //Define the action to be performed when window is closed
    @Override
    public void windowClosing(WindowEvent e) {
        String s = "Do you want to quit?";
        d = new JDialog(f,"",true);
        
        JLabel l4 = new JLabel(s);
        
        b3 = new JButton("Yes");
        b3.addActionListener(this);
        
        b4 = new JButton("No");
        b4.addActionListener(this);
        
        d.add(l4);
        d.add(b3);
        d.add(b4);
        d.setLayout(new FlowLayout());
        d.setBounds(150,10,180,95);
        d.setVisible(true);
    }

    //Define the actions to be performed when buttons are clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == b2) {
            boolean checktf1=true;
            boolean checktf2=true;
            boolean checktf3=true;
            String str1 = tf1.getText();
            char[] str1Arr = str1.toCharArray();
            
            if(str1.isEmpty()) {
                checktf1 = false;
            }
            else {
                int i;
                for(i=0;i<str1.length();i++) {
                    if(str1.charAt(i) == ' ') {
                        continue;
                    }
                    else break;
                }
                if(i == str1.length()) checktf1 = false;
                for(char c : str1Arr) {
                    if(!((c>='A' && c<='Z') || (c>='a' && c<='z') || c==' ')) {
                        checktf1 = false;
                        break;
                    }
                }
            }
            
            if(!checktf1) msg1.setVisible(true);
            else msg1.setVisible(false);

            String str2 = tf2.getText();
            if(!(str2.matches("^([a-z0-9]{1}[a-z0-9-_.]+)@(?:[a-zA-Z0-9-]+\\.)+([a-zA-Z]{2,6})$"))) {
                checktf2 = false;
            }
            
            if(!checktf2) msg2.setVisible(true);
            else msg2.setVisible(false);

            char[] str3Arr = pf.getPassword();
            boolean lower=false,upper=false,digit=false,special=false,len=false;
            
            if(str3Arr.length>=6) {
                len = true;
            }
            for(char c : str3Arr) {
                if(c>='a' && c<='z') {
                    lower = true;
                }
                else if(c>='A' && c<='Z') {
                    upper = true;
                }
                else if(c>='0' && c<='9') {
                    digit = true;
                }
                else {
                    special = true;
                }
            }
            
            checktf3 = lower && upper && digit && special && len;

            if(!checktf3) msg3.setVisible(true);
            else msg3.setVisible(false);

            if(checktf1 && checktf2 && checktf3) {
                msg1.setVisible(false);
                msg2.setVisible(false);
                msg3.setVisible(false);
                msg4.setVisible(true);
            }
            else {
                msg4.setVisible(false);
            }
        }
        else if(e.getSource() == b1) {
            tf1.setText("");
            msg1.setVisible(false);
            tf2.setText("");
            msg2.setVisible(false);
            pf.setText("");
            msg3.setVisible(false);
            msg4.setVisible(false);
        }
        else if(e.getSource() == b3) {
            f.dispose();
        }
        else {
            d.setVisible(false);
        }
    }
    
    //Main method
    public static void main(String[] args) {
        new SignUp();
    }
}