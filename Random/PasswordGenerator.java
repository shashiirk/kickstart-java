import java.util.Random;

class PasswordGenerator {
    public static void main(String args[]) {
        
        Random r = new Random();//Creating an object of class 'Random'
        
        String capital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small = "abcdefghijklmnopqrstuvwxyz";
        String digit = "0123456789";
        String special = "!@#$%^&*_<>?";
        String str = capital + small + digit + special;
        
        int l = 6;//Desired length of password
        
        char[] arr = new char[l];//Declaring an array of length l
        
        for(int i=0;i<arr.length;i++) {
            arr[i]=str.charAt(r.nextInt(str.length()));
        }
        
        String pass = String.valueOf(arr);//Converting character array to string
        
        System.out.println(pass);//Printing the password
    }
}