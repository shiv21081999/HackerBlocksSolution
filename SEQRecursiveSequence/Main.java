import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static long[][] nthA(long n, long[][] arr){
        long[][] res = new long[arr.length][arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        while(n>0)
        {
            if((n&1)>0)
            {
                res = prod(res,arr);
            }
            arr = prod(arr, arr);
            n = n>>1;
        }
        return res;
    }
    static long[][] prod(long[][] a, long[][] b)
    {
        long[][] res = new long[a.length][b[0].length];
        
        
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                for (int k = 0; k < res.length; k++) {
                    res[i][j]+=(a[i][k]*b[k][j])%1000000000;
                }
                res[i][j] = res[i][j]%1000000000;
            }
        }
        return res;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        while(C>0)
        {
            int k = sc.nextInt();
            long[] b = new long[k+1];
            long[] c = new long[k+1];
            for (int i = 1; i < b.length; i++) {
                b[i] = sc.nextLong();
            }
            for (int i = 1; i < c.length; i++) {
                c[i] = sc.nextLong();
            }
            int n = sc.nextInt();
            long an;
            if(n<=k)
            {
                an = b[n];
            }
            else
            {
                long[][] arr = new long[k+1][k+1];
                for (int i = 0; i < arr.length; i++) {
                    Arrays.fill(arr[i],0);
                }
                arr[1] = c;
                for(int i = 2 ; i < arr.length ; i++)
                {
                    arr[i][i-1] = 1;
                }
                long[][] c1 = new long[b.length][1];
                c1[0][0] = 0;
                for (int i = 0; i < c1.length-1; i++) {
                    c1[b.length-i-1][0] = b[i+1];
                }
                long[][] ans = prod(nthA(n-k, arr),c1);
                an = ans[1][0]%1000000000;
            }
            System.out.println(an);
            C--;
        }
    }
}