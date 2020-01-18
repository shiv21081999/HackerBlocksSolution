import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static long[] dp = new long[50];
    static long noOfNDigitNo(int n){
        if(dp[n]==0)
        {
            if(n==0)
                dp[n] = 1;
            else if(n==1)
                dp[n] = 2;
            else dp[n] = noOfNDigitNo(n-1)+noOfNDigitNo(n-2);
        }
        return dp[n];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x = 1;
        while(t>0)
        {
            int n = sc.nextInt();
            System.out.println("#"+x+" : "+noOfNDigitNo(n));
            x++;
            t--;
        }
        
    }
}