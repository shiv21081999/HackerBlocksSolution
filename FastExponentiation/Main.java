import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long p = sc.nextLong();
        long mask = 1;
        long res = 1;
        while(p>0)
        {
            if((p&mask)>0)
            {
                res*=n;
            }
            n*=n;
            p=p>>1;
        }
        System.out.println(res);
    }
}