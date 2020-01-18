import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int[] ans = new int[n+1];
        HashMap<Integer,Integer> set = new HashMap<>();
        for (int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        long sum = 0;
        for (int i = 1; i < ans.length; i++) {
            if(set.containsKey(arr[i]))
            {
                ans[i] = ans[i-1]+i-set.get(arr[i]);
                sum+=ans[i];
                set.put(arr[i],i);
            }
            else{
                ans[i]=ans[i-1]+i;
                sum+=ans[i];
                set.put(arr[i],i);
            }
        }
        sum*=2;
        sum-=n;
        double expected = (double)sum/(double)(n*n);
        System.out.printf("%.6f",expected);

    }
}