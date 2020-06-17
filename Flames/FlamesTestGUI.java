import java.awt.*;
import java.awt.event.*;

public class FlamesTestGUI extends WindowAdapter implements ActionListener {
    
    private TextField tf1, tf2;
    private TextArea ta;
    private Button b1, b2;
    private Label l1, l2, msg1, msg2;
    private Frame f;

    //Constructor
    private FlamesTestGUI() {
        
        f = new Frame("Flames Calculator");

        l1 = new Label("Enter your name: ");
        l1.setBounds(50,50,120,25);
        l1.setFont(new Font("Ariel",Font.BOLD,14));

        tf1 = new TextField();
        tf1.setBounds(175,50,130,25);

        l2 = new Label("Enter your partner's name: ");
        l2.setBounds(50,120,190,25);
        l2.setFont(new Font("Ariel",Font.BOLD,14));

        tf2 = new TextField();
        tf2.setBounds(245,120,130,25);

        msg1 = new Label("*Please provide a valid name!(Don't include spaces)");
        msg1.setFont(new Font("Dailog",Font.PLAIN,14));
        msg1.setForeground(Color.RED);
        msg1.setBounds(50,75,330,25);
        msg1.setVisible(false);

        msg2 = new Label("*Please provide a valid name!(Don't include spaces)");
        msg2.setFont(new Font("Dailog",Font.PLAIN,14));
        msg2.setForeground(Color.RED);
        msg2.setBounds(50,145,330,25);
        msg2.setVisible(false);

        b1 = new Button("Reset");
        b1.setBounds(120,200,80,25);
        b1.setFont(new Font("Ariel",Font.BOLD,15));
        b1.addActionListener(this);

        b2 = new Button("Submit");
        b2.setBounds(220,200,80,25);
        b2.setFont(new Font("Ariel",Font.BOLD,15));
        b2.addActionListener(this);

        ta = new TextArea("",3,100,TextArea.SCROLLBARS_NONE);
        ta.setBounds(40,240,415,80);
        ta.setForeground(Color.RED);
        ta.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 20));
        ta.setVisible(false);

        f.add(ta);
        f.add(l1);
        f.add(tf1);
        f.add(l2);
        f.add(tf2);
        f.add(b1);
        f.add(b2);
        f.add(msg1);
        f.add(msg2);
        f.addWindowListener(this);

        f.setSize(500,350);
        f.setLayout(null);
        f.setBackground(Color.GREEN);
        f.setForeground(Color.BLUE);
        f.setVisible(true);
    }

    //Define action te be performed on clicking buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1) {
            tf1.setText("");
            tf2.setText("");
            ta.setVisible(false);
            msg1.setVisible(false);
            msg2.setVisible(false);
        }
        else {
            String name1 = tf1.getText();
            String name2 = tf2.getText();
            
            boolean checktf1 = validateName(name1);
            boolean checktf2 = validateName(name2);
           
            if(checktf1) msg1.setVisible(false);
            else {
                msg1.setVisible(true);
                ta.setVisible(false);
            }
            
            if(checktf2) msg2.setVisible(false);
            else {
                msg2.setVisible(true);
                ta.setVisible(false);
            }
            
            if(checktf1 && checktf2) {
                String relation = test(name1, name2);
                String result;
                if(relation.equals("None"))
                    result = String.format("The relationship between %s and %s cannot be found!", name1, name2);
                else
                    result = String.format("The relationship between %s and %s will end in %s!", name1, name2, relation);
                ta.setVisible(true);
                ta.setText(result);
            }
        }
    }

    //Define the action to be performed on closing the window
    @Override
    public void windowClosing(WindowEvent e) {
        f.dispose();
    }

    //Validate the name entered by the user
    private boolean validateName(String name) {
        int i;
        
        if(name.isEmpty())
            return false;
        else {
            for(i=0;i<name.length();i++) {
                if((name.charAt(i)>='A' && name.charAt(i)<='Z') || (name.charAt(i)>='a' && name.charAt(i)<='z')) {
                    continue;
                }
                else break;
            }
            if(i == name.length()) {
                return true;
            }
            else return false;
        }
    }

    //Process the names and return the Relationship
    private static String test(String name1, String name2) {
        char x[] = name1.toLowerCase().toCharArray();
        char y[] = name2.toLowerCase().toCharArray();
        
        for(int i=0;i<x.length;i++) {
            for(int j=0;j<y.length;j++) {
                if(x[i] == y[j]) {
                    x[i] = y[j] = '$';
                    break;
                }
            }
        }

        int count = 0;
        for(char a : x) {
            if(a != '$') count++;
        }
        for(char b : y) {
            if(b != '$') count++;
        }
        
        Flames f = new Flames();
        char c = f.getResultChar(count);
        
        if(c == 'F') return "Friendship";
        else if(c == 'L') return "Love";
        else if(c == 'A') return "Affection";
        else if (c == 'M') return "Marriage";
        else if(c == 'E') return "Enemy";
        else if(c == 'S') return "Sibling";
        else return "None";
    }

    //Main method
    public static void main(String args[]) {
        new FlamesTestGUI();
    }
}

//This is a circular linked list class
class Flames {

    //Constructor
    Flames() {
        char arr[] = {'F','L','A','M','E','S'};
        for(char c:arr) {
            this.insert(c);
        }
    }

    //Objects in the linked list are created by this class
    private class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    //Linked list references
    private Node head = null;
    private Node tail = null;
    private Node mark = null;

    //Insert a new node into the linkd list
    private void insert(char c) {
        Node temp = new Node(c);
        if(head == null) {
            head = temp;
            tail = temp;
            tail.next = head;
        }
        else {
            tail.next = temp;
            tail = temp;
            tail.next = head;
        }
    }

    //Eliminate a node
    private Node remove(Node mark) {
        if(mark == head) {
            if(head == tail) {
                head = null;
                tail = null;
                return null;
            }
            else {
                head = head.next;
                tail.next = head;
                return head;
            }
        }
        else if(mark == tail) {
            Node temp;
            for(temp=head;temp.next!=tail;temp=temp.next) {}
            tail = temp;
            tail.next = head;
            return head;
        }
        else {
            Node u = null;
            Node v = null;
            for(u=head;u.next!=mark;u=u.next) {}
            v = u.next;
            v = v.next;
            u.next = v;
            return v;
        }
    }

    /*
      Remove one node in each round until one node is left
      in the linked list. This last left node is retuned.
    */
    char getResultChar(int n) {
        if(n!=0) {
            mark = head;
            while(head!=tail) {
                for(int i=0;i<n-1;i++) {
                    mark = mark.next;
                }
                mark = this.remove(mark);
            }
            return mark.data;
        }
        else {
            return 'X';
        }
    }
}
