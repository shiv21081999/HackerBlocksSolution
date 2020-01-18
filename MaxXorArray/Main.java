import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        long xor = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            xor = xor^arr[i];
        }
        long m = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            m = xor^arr[i];
            if(m>ans && m >xor)
            {
                ans = m;
            }
        }
        System.out.println(ans);
    }
}