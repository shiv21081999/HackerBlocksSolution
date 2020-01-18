import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static long[][] TthOperation(int n,long t,long[][] x){
        long[][] mat = new long[x.length][x.length];
        long[][] res = new long[x.length][x.length];
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(mat[i],1);
            mat[i][i] = 0;
            res[i][i]=1;
        }
        while(t>0)
        {
            if((t&1)>0)
            {
                res = prod(res, mat);
            }
            mat = prod(mat, mat);
            t=t>>1;
        }

        return prod(res,x);
    }
    static long[][] prod(long[][] a, long[][] b)
    {
        long[][] res = new long[a.length][b[0].length];
        
        
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                for (int k = 0; k < res.length; k++) {
                    res[i][j]+=(a[i][k]*b[k][j])%98765431;
                }
                res[i][j] = res[i][j]%98765431;
            }
        }
        return res;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long t = sc.nextLong();
        long[][] arr = new long[n][1];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = sc.nextLong();
        }
        long[][] ans = TthOperation(n, t, arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0]);
        }
    }
}