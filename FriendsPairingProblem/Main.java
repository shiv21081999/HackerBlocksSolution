import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static long[] dp = new long[35];
    static long getPairingSingle(int n){
        if(dp[n]==-1)
        {
            if(n<=1)
                dp[n]=1;
            else
            {
                dp[n] = getPairingSingle(n-1)+(n-1)*getPairingSingle(n-2);
            }
            
        }
        return dp[n];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Arrays.fill(dp,-1);
        while(t>0)
        {
            int n = sc.nextInt();
            System.out.println(getPairingSingle(n));
            t--;
        }
        
    }
}