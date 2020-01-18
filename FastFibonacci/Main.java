import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static long nthFib(long n){
        long mat[][] = {{1,1},{1,0}};
        long res[][] = {{1,0},{0,1}};
        n--;
        while(n>0)
        {
            if((n&1)>0)
            {
                res = prod(res, mat);
            }
            mat = prod(mat, mat);
            n=n>>1;
        } 
        return res[0][0];
    }
    static long[][] prod(long[][] a , long[][] b)
    {
        long res[][] = new long[2][2];
                for(int i = 0 ; i < 2 ; i++)
                {
                    for(int j = 0 ; j < 2 ; j++)
                    {
                        for (int k = 0; k < 2; k++) {
                            res[i][j]+= (a[i][k]*b[k][j])%1000000007;
                        }
                        res[i][j] = res[i][j]%1000000007;
                    }
                }
                return res;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            long n = sc.nextLong();
            System.out.println(nthFib(n));
            t--;
        }
    }
}