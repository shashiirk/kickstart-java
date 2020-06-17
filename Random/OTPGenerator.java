import java.util.Random;

public class OTPGenerator {
    public static void main(String args[]) {
        //Creating object of class 'Random'
        Random r = new Random();
        //Length of OTP
        int l = 4;
        
        String str = "0123456789";
        //Declaring an array of length l
        char[] otp = new char[l];
        
        for(int i=0;i<l;i++) {
            otp[i]=str.charAt(r.nextInt(str.length()));
        }
        //Converting character array to string
        String pass = String.valueOf(otp);
        //Printing the OTP
        System.out.println(pass);
    }
}