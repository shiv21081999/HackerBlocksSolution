import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static long[][] nthFibSum(long n, long[][] arr, long mod){
        long[][] res = new long[arr.length][arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        n--;
        while(n>0)
        {
            if((n&1)>0)
            {
                res = prod(res,arr,mod);
            }
            arr = prod(arr, arr,mod);
            n = n>>1;
        }
        return res;
    }
    static long[][] prod(long[][] a, long[][] b,long mod)
    {
        long[][] res = new long[a.length][b[0].length];
        
        
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                for (int k = 0; k < res.length; k++) {
                    res[i][j]+=(a[i][k]*b[k][j])%mod;
                }
                res[i][j] = res[i][j]%mod;
            }
        }
        return res;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long[][] mat = {{1,1,1},{0,1,1},{0,1,0}};
            long[][] f1 = {{1},{1},{0}};
            long summ = 0,sumn = 0;
            long an =0;
            if(n == 0 || n == 1)
            {
                sumn = n&1;
                an = n&1;
            }
            else
            {
                long[][] maskn = nthFibSum(n, mat, 1000000007);
                long[][] ansn = prod(maskn, f1, 1000000007);
                sumn = ansn[0][0];
                an = ansn[1][0];
            }
            if(m == 0 || m == 1)
            {
                summ = m&1;
            }
            else
            {
                long[][] maskm = nthFibSum(m, mat, 1000000007);
                long[][] ansm = prod(maskm, f1, 1000000007);
                summ = ansm[0][0];
            }
            long ans = (summ-sumn+an)%1000000007;
            System.out.println(ans); 
            t--;
        }
    }
}