import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        BigInteger one = BigInteger.valueOf(1);
        BigInteger ans = one;
        for (BigInteger i = one; i.compareTo(n)<=0; i=i.add(one)) {
            ans = ans.multiply(i);
        }
        System.out.println(ans);
    }
}