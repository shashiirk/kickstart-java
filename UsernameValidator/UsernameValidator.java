import java.util.Scanner;

public class UsernameValidator {
    
    //Validates the username passed to it   
    private static boolean Validate(String user) {
        
        try {
            
            for(int i=0;i<user.length();i++) {
                if((user.charAt(i)>='a' && user.charAt(i)<='z') || (user.charAt(i)>='0' && user.charAt(i)<='9') || user.charAt(i) == '_' || user.charAt(i) == '.')
                    continue;
                throw new InvalidCharacterException();
            }
            
            if(user.charAt(0) == '.' || user.charAt((user.length()) - 1) == '.')
                throw new IllegalPeriodException();
            
            else if(user.charAt(0) == '_' || user.charAt((user.length()) - 1) == '_')
                throw new IllegalUscoreException();
            
            else {
                return true;
            }
        }
        catch(InvalidCharacterException ic) {
            System.out.println(ic);
            return false;
        }
        catch(IllegalPeriodException ip) {
            System.out.println(ip);
            return false;
        }
        catch(IllegalUscoreException iu) {
            System.out.println(iu);
            return false;
        }
    }

    //Determines whether to terminate the program or not
    private static boolean continueOrNot() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("\nWanna Try again...? (Y|N): ");
            char c = sc.nextLine().toUpperCase().charAt(0);
            if(c == 'Y') return true;
            else if(c == 'N') return false;
            else {
                System.out.println("Enter a valid character!");
                return continueOrNot();
            }
        }
        catch(Exception e) {
            System.out.println(e);
            return continueOrNot();
        }
    }

    //Main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String user;
        boolean isValid,again;
        
        while(true) {
            
            try {
                System.out.print("\nEnter username: ");
                user = sc.nextLine();
                isValid = Validate(user);
                if(isValid) {
                    System.out.println("Username Validated successfully!");
                }
            }
            catch(Exception e) {
                System.out.println(e);
            }
            
            again = continueOrNot();
            if(again) continue;
            else {
                System.out.println("\nYou terminated...Bye!");
                break;
            }
        }
    }

}

//Exception when username contain invalid characters
class InvalidCharacterException extends Exception {

    @Override
    public String toString() {
        return "Username can only contain small alphabet,digits,period or underscore." ;
    }

}

//Exception when username starts or ends with a period.
class IllegalPeriodException extends Exception {
    
    @Override
    public String toString() {
        return "Username cannot start or end with a period." ;
    }

}

//Exception when username stats or ends with an underscore.
class IllegalUscoreException extends Exception {
    
    @Override
    public String toString() {
        return "Username cannot start or end with an underscore." ;
    }

}