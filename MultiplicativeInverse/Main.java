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
            GCD=a;
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
        extendedEuclid(n, 1000000007);
        System.out.println(x>0?x:1000000007+x);
    }
}