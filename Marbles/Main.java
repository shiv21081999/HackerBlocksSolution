import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static BigInteger combination(BigInteger n , BigInteger r){
        BigInteger one = BigInteger.valueOf(1);
        BigInteger comb = BigInteger.valueOf(1);
        BigInteger x = BigInteger.valueOf(1);
        for(BigInteger j = r; j.compareTo(one)>=0 ;j=j.subtract(one))
        {
            comb=comb.multiply(n.subtract(j).add(one));
            comb = comb.divide(x);
            x = x.add(one);
        }
        return comb;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n,k;
        while(t>0)
        {
            n = sc.nextInt();
            k = sc.nextInt();
            System.out.println(combination(BigInteger.valueOf(n-1),BigInteger.valueOf(k-1)));
            t--;
        }
    }
}