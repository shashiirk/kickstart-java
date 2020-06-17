import java.util.Scanner;

class PasswordValidator {

    //Validates the password passed to it
    private static void Validate(String pass) {
        int l=0,u=0,d=0,s=0;
        char pwd[] = pass.toCharArray();
        
        try {
            if(pwd.length < 6)
                throw new Exception("Password length should be minimum of six.");
            
            for(int i=0;i<pwd.length;i++) {
                if(pwd[i] >= 65 && pwd[i] <= 90) 
                    u++;
                else if(pwd[i] >= 97 && pwd[i] <= 122)
                    l++;
                else if(pwd[i] >= 48 && pwd[i] >= 57)
                    d++;
                else
                    s++;
            }
            
            if(l==0 || u==0 || d==0 || s==0)
                throw new Exception("Password must contain atleast one small letter,capital letter,digit and a special character.");
            
            System.out.println("Password validated successfully...");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new Password : ");
        String pass = sc.next();
        Validate(pass);
    }
}