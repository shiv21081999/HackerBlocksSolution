import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static BigInteger combination(BigInteger n , BigInteger r){
        BigInteger one = BigInteger.valueOf(1);
        BigInteger comb = BigInteger.valueOf(1);
        BigInteger x = BigInteger.valueOf(1);
        for(BigInteger j = r; j.compareTo(one)>=0 ;j=j.subtract(one))
        {
            comb=comb.multiply(n.subtract(j).add(one));
            comb = comb.divide(x);
            x = x.add(one);
        }
        return comb;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n;
        BigInteger one = BigInteger.valueOf(1);
        BigInteger two = BigInteger.valueOf(2);
        while(t>0)
        {
            n = sc.nextInt();
            long arr[] = new long[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextLong();
            }
            long[] presum = new long[n+1];
            presum[0] = 0;
            for (int i = 1; i < presum.length; i++) {
                presum[i] = presum[i-1]+arr[i-1];
            }
            long[] rem = new long[n];
            for (int i = 0; i < presum.length; i++) {
                int tmp = (int)(presum[i]%n);
                rem[tmp]++;
            }
            BigInteger ans = BigInteger.valueOf(0);
            for (int i = 0; i < rem.length; i++) {
                if(rem[i]>=2)
                {
                    ans = ans.add(combination(BigInteger.valueOf(rem[i]), two));
                }
            }
            System.out.println(ans);
            t--;
        }
    }
}