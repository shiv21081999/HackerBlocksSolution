import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            String ans ="";
            for (int j = 0; j < s1.length(); j++) {
                ans = ans + ((s1.charAt(j)-48)^(s2.charAt(j)-48));
            }
            System.out.println(ans);
        }
    }
}