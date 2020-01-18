import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int digits = (int)Math.log10((double)n);
        double ans = 2*(Math.pow(2,digits)-1);
        digits++;
        int i = 0;
        while(n>0){
            int r = n%10;
            if(r==7)
            {
                ans+=(Math.pow(2,i));
            }
            i++;
            n/=10;
        }
        System.out.println((long)ans+1);
    }
}