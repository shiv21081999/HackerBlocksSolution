import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int setBitSum[] = new int[32];
        int c=31,mul=1;
        while(c>=0)
        {
            for (int i = 0; i < arr.length; i++) {
                setBitSum[c]+=(arr[i]&mul);
                arr[i] =arr[i]>>1;
            }
            setBitSum[c]%=3;
            c--;

        }
        int ans = 0;
        for (int i = setBitSum.length-1; i >=0 ; i--) {
            ans+=(setBitSum[i]*mul);
            mul*=2;
        }
        System.out.println(ans);
    }
}