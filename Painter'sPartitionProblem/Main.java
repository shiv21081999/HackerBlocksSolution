import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static boolean check(int time,int k,int arr[]){
        int timeforgiven =0,painters=1;
        for(int i=0 ; i<arr.length;i++)
        {
            timeforgiven+=arr[i];
            if(timeforgiven>=time) 
            {
                painters++;
                timeforgiven=arr[i];
            }
        }
        if(painters>=k)
            return true;
        return false;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int max=-1,sum=0;
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max=Math.max(max,arr[i]);
            sum+=arr[i];
        }
        int left = max,right = sum;
        while(left<right)
        {
            int mid = left +((right-left)/2);
            // System.out.println(left+" "+mid+" "+right);
            if(check(mid,k,arr) && left != mid)
            {
                left=mid;
            }
            else{
                right = mid;
            }
        }
        System.out.println(left);
        sc.close();
    }
}