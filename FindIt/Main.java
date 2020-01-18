import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    
    static int[] seive(int[] count){
        int[] sum = new int[100005];
        for(int i = 1 ; i < 100005 ; i++)
        {
            for (int j = i; j < 100005; j+=i) {
                sum[i]+=count[j];
            }
        }
        return sum;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] count = new int[100005];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            count[x]++;
        }
        int[] sum = seive(count);
        int q = sc.nextInt();
        while(q>0)
        {
            int k = sc.nextInt();
            System.out.println(sum[k]);
            q--;
        }
    }
}