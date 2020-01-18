import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
import java.util.Collections;
public class Main {
    static ArrayList<String> ans = new ArrayList<>();
    static void printBalances(String x,int n,int m){
        // System.out.println(n+" "+m+" "+x);
        if(n>m)
            return;
        if(n==0 && m==0)
        {
            ans.add(x);
            return;
        }
        if(n<0 || m<0)
            return;
        printBalances(x+"(", n-1, m);
        printBalances(x+")", n, m-1);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printBalances("", n, n);
        Collections.sort(ans,Collections.reverseOrder());
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}