import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int ans1=0,ans2=0;
        ArrayList<Integer> setBit = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            ans1 = ans1^arr[i];
        }
        for (int i = 0; i < n; i++) {
            if((ans1&arr[i]) > 0)
                setBit.add(arr[i]);
        }
        for (int i = 0; i < setBit.size(); i++) {
            ans2 = ans2^setBit.get(i);
        }
        ans1 = ans2^ans1;
        System.out.println(Math.min(ans1, ans2)+" "+Math.max(ans1, ans2));
    }
}