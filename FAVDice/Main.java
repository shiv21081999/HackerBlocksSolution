import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            double ans = 0;
            for (int i = 1; i <= n; i++) {
                ans+=(1.0/i);
            }
            System.out.printf("%.2f",n*1.0*ans);
            System.out.println();
            t--;
        }
    }
}