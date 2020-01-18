import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static long[][] nthA(long n, long[][] arr, long mod){
        long[][] res = new long[arr.length][arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
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
        int C = sc.nextInt();
        while(C>0)
        {
            int k = sc.nextInt();
            long[] b = new long[k+1];
            long[] c = new long[k+1];
            long sk = 0;
            for (int i = 1; i < b.length; i++) {
                b[i] = sc.nextLong();
                sk+=b[i];
            }
            for (int i = 1; i < c.length; i++) {
                c[i] = sc.nextLong();
            }
            long m = sc.nextLong();
            long n = sc.nextLong();
            long p = sc.nextLong();
            long sn;
            long sm;
            long am;
            if(n<=k)
            {
                sn = 0;
                sm = 0;
                am = b[(int)m];
                for (int i = 0; i <= n; i++) {
                    if(i<=m)
                    {
                        sn = sn+b[i];
                        sm = sm+b[i];
                        sm = sm%p;
                        sn = sn%p;
                    }
                    else{
                        sn+=b[i];
                        sn = sn%p;
                    }
                }
            }
            else if(m<=k)
            {
                sm = 0;
                am = b[(int)m];
                for (int i = 0; i <= m; i++) {
                    sm+=b[i];
                    sm = sm%p;
                }
                long[][] arr = new long[k+1][k+1];
                for (int i = 0; i < arr.length; i++) {
                    Arrays.fill(arr[i],0);
                }
                arr[1] = c;
                for (int i = 0; i < arr.length; i++) {
                    arr[0][i] = c[i];
                }
                arr[0][0] = 1;
                for(int i = 2 ; i < arr.length ; i++)
                {
                    arr[i][i-1] = 1;
                }
                long[][] fk = new long[b.length][1];
                fk[0][0] = sk;
                for (int i = 0; i < fk.length-1; i++) {
                    fk[b.length-i-1][0] = b[i+1];
                }
                long[][] sumn = prod(nthA(n-k, arr,p),fk,p);
                sn = sumn[0][0]%p;
            }
            else
            {
                long[][] arr = new long[k+1][k+1];
                for (int i = 0; i < arr.length; i++) {
                    Arrays.fill(arr[i],0);
                }
                arr[1] = c;
                for (int i = 0; i < arr.length; i++) {
                    arr[0][i] = c[i];
                }
                arr[0][0] = 1;
                for(int i = 2 ; i < arr.length ; i++)
                {
                    arr[i][i-1] = 1;
                }
                long[][] fk = new long[b.length][1];
                fk[0][0] = sk;
                for (int i = 0; i < fk.length-1; i++) {
                    fk[b.length-i-1][0] = b[i+1];
                }
                long[][] summ = prod(nthA(m-k, arr,p),fk,p);
                long[][] sumn = prod(nthA(n-k, arr,p),fk,p);
                sm = summ[0][0]%p;
                sn = sumn[0][0]%p;
                am = summ[1][0]%p;
            }
            System.out.println((sn-sm+am)%p);
            C--;
        }
    }
}