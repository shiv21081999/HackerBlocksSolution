import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static long pow(long a, long p)
    {
        long res = 1;
        while(p>0)
        {
            if((p&1)>0)
            {
                res*=a;
            }
            a*=a;
            p=p>>1;
        }
        return res;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a,n,p;
        while(t>0)
        {
            a = sc.nextInt();
            n = sc.nextInt();
            p = sc.nextInt();
            long ans = a;
            for(int i = 2 ; i <= n ; i++)
            {
                ans = pow(ans,i)%p;
            }
            System.out.println(ans%p);
            t--;
        }
    }
}