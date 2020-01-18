import java.util.*;
import java.util.Arrays;
import java.math.BigDecimal;
import java.math.BigInteger;
public class Main {
    static BigDecimal mod = new BigDecimal("1000000007");
    static long modi = 1000000007; 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        BigDecimal[] arr = new BigDecimal[x];
        BigDecimal one = BigDecimal.valueOf(1);
        BigDecimal two = BigDecimal.valueOf(2);
        BigDecimal div = one;
        for (int i = 0; i < x; i++) {
            arr[i] = sc.nextBigDecimal();
            div = div.multiply(arr[i].add(one)).remainder(mod);
        }
        div = div.divide(two);
        BigDecimal ans = one;
        for (int i = 0; i < arr.length; i++) {
            ans = ans.multiply(div.multiply(arr[i]).add(one)).remainder(mod);
        }
        
        System.out.println(ans.remainder(mod).intValue());
    }
}