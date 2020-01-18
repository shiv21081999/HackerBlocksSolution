import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double p = sc.nextDouble();
        long ans = (long)Math.ceil(Math.sqrt(730*Math.log(1.0/(1-p))));
        System.out.println(ans);
    }
}