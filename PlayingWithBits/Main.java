import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n>0)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int count = 0;
            while(a<=b)
            {
                count+=Integer.bitCount(a);
                a++;
            }
            System.out.println(count);
            n--;
        }
    }
}