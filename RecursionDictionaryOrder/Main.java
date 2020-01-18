import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static ArrayList<String> ans = new ArrayList<>();
    static void getLarger(String str , int pos , String check)
    {
        if(pos==str.length())
        {
            if(str.compareTo(check)>0)
            {
                ans.add(str);
            }
            return;
        }
        for (int i = pos; i < str.length(); i++) {
            if(i==pos)
                getLarger(str, pos+1, check);
            else
                getLarger(str.substring(0,pos)+str.charAt(i)+str.substring(pos+1, i)+str.charAt(pos)+str.substring(i+1), pos+1, check);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        getLarger(str, 0, str);
        Collections.sort(ans);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}