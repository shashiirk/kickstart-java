import java.io.Console;

public class PasswordMask {
    public static void main(String args[]) {
        
        Console con = System.console();//Create a console object
        
        /*
          con is null when using an ide. So we can't acheive
          password mask in an ide.
        */
        if(con == null) {
            System.out.println("Console not found");
            return;
        }
        
        System.out.print("Enter password : ");//Prompt the user for password
        char pwd[]=con.readPassword();
        
        String pass=String.valueOf(pwd);//Convert character array into a string
        
        System.out.println("Password : " + pass);//Print the password
    }
}