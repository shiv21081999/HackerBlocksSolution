import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static long x,y,GCD;
    static void extendedEuclid(long a, long b){
        if(b==0)
        {
            x=1;
            y=0;
            GCD=1;
            return;
        }
        extendedEuclid(b, a%b);
        long temp = x;
        x = y;
        y = temp - (a/b)*y;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] num = new long[n];
        long[] rem = new long[n];
        long prod = 1;
        for (int i = 0; i < rem.length; i++) {
            num[i] = sc.nextLong();
            prod*=num[i];
        }
        long ans = 0;
        for (int i = 0; i < rem.length; i++) {
            rem[i] = sc.nextLong();
        }
        for (int i = 0; i < rem.length; i++) {
            long ppi = prod/num[i];
            extendedEuclid(ppi, num[i]);
            ans = ans%prod + (((rem[i]*ppi)%prod)*(x>0?x:num[i]+x)%prod)%prod;
            ans%=prod;
        }
        System.out.println(ans);
        sc.close();
    }
}