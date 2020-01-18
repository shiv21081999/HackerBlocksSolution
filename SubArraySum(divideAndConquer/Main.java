import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static long getMaxSum(long[] arr)
    {
        if(arr.length==1)
            return arr[0];
        long[] left = Arrays.copyOfRange(arr, 0, arr.length/2);
        long[] right = Arrays.copyOfRange(arr, arr.length/2, arr.length);
        long leftMax = getMaxSum(left);
        long rightMax = getMaxSum(right);
        long sum = 0;
        long rightSum = Integer.MIN_VALUE;
        for (int i = 0; i < right.length; i++) {
            sum+= right[i];
            if(sum > rightSum)
                rightSum = sum;
        }
        sum = 0;
        long leftSum = Integer.MIN_VALUE;
        for (int i = left.length-1; i >=0 ; i--) {
            sum +=left[i];
            if(sum > leftSum)
                leftSum = sum;
        }
        return Math.max(leftSum+rightSum, Math.max(leftMax, rightMax));
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            System.out.println(getMaxSum(arr));
            t--;
        }
        
    }
}