import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static long mod = 1000000007;
    static long x,y,GCD;
    static void extendedEuclid(long a, long b){
        if(b==0)
        {
            x=1;
            y=0;
            GCD=a;
            return;
        }
        extendedEuclid(b, a%b);
        long temp = x;
        x = y;
        y = temp - (a/b)*y;
    }
    static long ncr(long n , long r){
        long nfact = 1,rfact=1;
        if(n-r<r)
            r = n-r;
        for (long i = r; i >= 1; i--) {
            nfact = ((nfact%mod)*((n-i+1)%mod))%mod;
            rfact = ((rfact%mod)*(i%mod))%mod;
        }
        extendedEuclid(rfact, mod);
        rfact = x>0?x:1000000007+x;
        return ((nfact%mod)*(rfact%mod))%mod;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long r = sc.nextLong();
        System.out.println(ncr(n, r));
    }
} 