import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static long[] totient = new long[1000005];
    static void getTotient(){
        for (int i = 0; i < totient.length; i++) {
            totient[i] = i;
        }
        for (int i = 2; i*i < totient.length; i++) {
            if(totient[i]==i)
            {
                for (int j = i; j < totient.length; j+=i) {
                    totient[j] = (totient[j]/i)*(i-1);
                }
            }
        }
    }
    public static void main(String args[]) {
        getTotient();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            System.out.println(totient[n]);
            t--;
        }
        
        
    }
}