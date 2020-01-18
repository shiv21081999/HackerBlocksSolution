import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static BigInteger zero = BigInteger.valueOf(0);
    static BigInteger GCD(BigInteger a , BigInteger b)
    {
        return b.compareTo(zero)==0 ? a : GCD(b, a.remainder(b));
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BigInteger x = sc.nextBigInteger();
        BigInteger y = sc.nextBigInteger();
        System.out.println(x);
        System.out.println(GCD(x,y));
        
    }
}