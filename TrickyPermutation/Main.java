import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static ArrayList<String> ans = new ArrayList<>();
    static boolean swappingCheck(String str , int start, int check)
    {
        for (int i = start; i < check; i++) {
            if(str.charAt(i)==str.charAt(check))
                return false;
        }
        return true;
    }
    static void printPermute(String str,int pos)
    {
        if(pos==str.length())
        {
            ans.add(str);
            return;
        }
        for (int i = pos; i < str.length(); i++) {
            if(i==pos)
                printPermute(str, pos+1);
            else if(swappingCheck(str, pos, i))
                printPermute(str.substring(0, pos)+str.charAt(i)+str.substring(pos+1, i)+str.charAt(pos)+str.substring(i+1), pos+1);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printPermute(str, 0);
        Collections.sort(ans);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}