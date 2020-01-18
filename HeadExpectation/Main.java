import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long ans = (long)Math.pow(2,n+1)-2l;
        System.out.println(ans);
    }
}