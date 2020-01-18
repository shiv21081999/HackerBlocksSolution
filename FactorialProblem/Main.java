import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        int t,n,k;
        Scanner sc = new Scanner(System.in);
        int count =0;
        t = sc.nextInt();
        while(t>0)
        {
            n=sc.nextInt();
            k=sc.nextInt();
            int ans = Integer.MAX_VALUE;
            for (int i = 2; i*i < k; i++) {
                if(k%i==0){
                    count=0;
                    while(k%i==0)
                    {
                        count++;
                        k/=i;
                    }
                    int tmp = 0;
                    long p = i;
                    while(p<=n)
                    {
                        tmp+=(n/p);
                        p*=i; 
                    }
                    ans = Math.min(ans, tmp/count);
                }
            }
            if(k>1)
            {
                int tmp = 0;
                long p = k;
                while(p<=n)
                {
                    tmp+=(n/p);
                    p*=k;
                }
                ans = Math.min(ans, tmp);
            }
            if(ans==Integer.MAX_VALUE)
                ans = 0;
            System.out.println(ans);
            t--;
            
        }
    }
}