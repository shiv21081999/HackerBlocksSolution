import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static ArrayList<String> getString(String n){
        String searchIn[] = {
            "prateek", "sneha", "deepak", "arnav", "shikha", "palak",
            "utkarsh", "divyam", "vidhi", "sparsh", "akku"
    };
    ArrayList<String> ans = new ArrayList<>(); 
    for (int i = 0; i < searchIn.length; i++) {
        if(searchIn[i].contains(n))
            ans.add(searchIn[i]);
    }
    return ans;
    }
    static String getTable(char n){
        String table[] = { " ", ".+@$", "abc", "def", "ghi", "jkl" , "mno", "pqrs" , "tuv", "wxyz" };
        return table[n-48]; 
    }
    static void printStr(String str,String ans)
    {
        if(str.length() == 0)
        {
            ArrayList<String> arr = getString(ans);
            Collections.sort(arr);
            for (int i = 0; i < arr.size(); i++) {
                System.out.println(arr.get(i));
            }
            return;
        }
        String pos = getTable(str.charAt(0));
        for (int i = 0; i < pos.length(); i++) {
            printStr(str.substring(1), ans+pos.charAt(i));
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printStr(str, "");
    }
}