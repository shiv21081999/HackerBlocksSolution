import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static long ans =0;
    static void getInversionCount(int[] arr)
    {
        if(arr.length==1)
            return;
        int[] left = new int[arr.length/2];
        int[] right = new int[arr.length-left.length];
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[i+left.length];
        }
        getInversionCount(left);
        getInversionCount(right);
        ans+=getCount(left,right,arr);
    }
    static long getCount(int left[] ,int right[] , int[] base)
    {
        int i=0,j=0,k=0;
        long count=0;
        while (i<left.length && j<right.length) {
            if(left[i]>right[j])
            {
                base[k++] = right[j++];
                count+=(left.length-i);
            }
            else
            {
                base[k++] = left[i++];
            }
        }
        while (i<left.length) {
            base[k++] = left[i++];
        }
        while (j<right.length) {
            base[k++] = right[j++];
        }
        return count;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            ans = 0;
            getInversionCount(arr);
            System.out.println(ans);
            t--;
        }
        sc.close();
    }
}