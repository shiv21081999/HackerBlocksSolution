import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static String[] alph = {" ","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    
    static ArrayList<String> result = new ArrayList<>();
    static void getNumString(String str, String ans){
        if(str.equals(""))
        {
            result.add(ans);
            return;
        }
        getNumString(str.substring(1), ans+alph[Integer.parseInt(str.substring(0,1))]);
        if(str.length()>1 && Integer.parseInt(str.substring(0,2))<=26)
        {
            getNumString(str.substring(2), ans+alph[Integer.parseInt(str.substring(0, 2))]);
        }

    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        getNumString(str, "");
        System.out.println(result.toString());
    }
}