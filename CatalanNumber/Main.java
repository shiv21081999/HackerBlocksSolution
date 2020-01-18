import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static BigInteger combination(BigInteger n, BigInteger r){
        if((n.subtract(r)).compareTo(r)<0)
            r=n.subtract(r);
        BigInteger one = BigInteger.valueOf(1);
        BigInteger ans = one;
        BigInteger x = one;
        for (BigInteger i = r; i.compareTo(one)>=0; i=i.subtract(one)) {
            ans = ans.multiply(n.subtract(i).add(one));
            ans = ans.divide(x);
            x = x.add(one);
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger comb = combination(BigInteger.valueOf(2*n), BigInteger.valueOf(n));
        BigInteger ans = comb.divide(BigInteger.valueOf(n+1));
        System.out.println(ans);
    }
}