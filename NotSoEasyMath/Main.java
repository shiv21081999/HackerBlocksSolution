import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        long arr[] = {2,3,5,7,11,13,17,19};
        Scanner sc = new Scanner(System.in);
        long n = 0l;
        long t = sc.nextInt();
        while(t>0)
        {
            n = sc.nextLong();
            long m = (1<<8)-1;
            long ans = 0l;
            for (int i = 1; i <=m ; i++) {
                long denom = 1l;
                long x = Long.bitCount(i);
                for(int j = 0 ; j <= 7 ; j++)
                {
                    if(((1<<j)&i)>0)
                    {
                        denom*=arr[j];
                    }
                }
                if((x&1)==0)
                {
                    ans-=(n/denom);
                }
                else
                {
                    ans+=(n/denom);
                }
            }
            System.out.println(ans);
            t--;
        }
    }
}