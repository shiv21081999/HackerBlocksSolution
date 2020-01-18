import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static String getTable(char n){
        String table[] = { " ", ".+@$", "abc", "def", "ghi", "jkl" , "mno", "pqrs" , "tuv", "wxyz" };
        return table[n-48]; 
    }
    static void printPossibleString(String str,String ans){
        if(str.length()==0)
        {
            System.out.println(ans);
            return;
        }
        String pos = getTable(str.charAt(0));
        for (int i = 0; i < pos.length(); i++) {
            printPossibleString(str.substring(1), ans+pos.charAt(i));
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printPossibleString(str, "");
    }
}