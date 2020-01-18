import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static BigInteger hx(BigInteger x)
    {
        BigInteger xcube = x.multiply(x).multiply(x);
        BigInteger xsquare = x.multiply(x);
        BigInteger four = BigInteger.valueOf(4);
        BigInteger five = BigInteger.valueOf(5);
        BigInteger six = BigInteger.valueOf(6);
        BigInteger fourteen = BigInteger.valueOf(14);
        return xcube.multiply(four).add(five.multiply(xsquare)).subtract(six.multiply(x)).add(fourteen);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BigInteger x = sc.nextBigInteger();
        System.out.println(hx(x));
    }
}