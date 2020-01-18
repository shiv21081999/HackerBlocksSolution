import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static int mod = 1000000007;
    static int[] dp = new int[1000000];
    static int getWays(int n , int m)
    {
        if(dp[n]==-1)
        {
            if(n<m)
                dp[n]=1;
            else if(n==m)
                dp[n]=2;
            else 
                dp[n] = (getWays(n-m, m)+getWays(n-1, m))%mod;
        }
        return dp[n];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Arrays.fill(dp,-1);
            if(n<m)
                System.out.println(1);
            else if(n==m)
                System.out.println(2);
            else
                System.out.println(getWays(n, m));
            t--;
        }
    }
}