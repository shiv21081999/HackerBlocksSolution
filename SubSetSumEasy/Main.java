import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static boolean checkSum(int sum, int arr[],int pos,boolean included)
    {
        if(sum == 0 && included)
        {
            return true;
        }
        if(pos==arr.length)
        {
            return false;
        }
        return checkSum(sum+arr[pos], arr, pos+1,true)|checkSum(sum, arr, pos+1,false);
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
            if(arr[0]==0)
            {
                System.out.println("Yes");
            }
            else if(checkSum(0, arr, 0 , false)){
                System.out.println("Yes");
            }
            else
            {
                System.out.println("No");
            }
            t--;
        }
        
    }
}