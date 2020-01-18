import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr =new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int i=0,j=0;
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> lengths = new ArrayList<>();
        int len = 0;
        while(i<arr.length)
        {
            if(j==arr.length)
            {
                len=j-i;
                lengths.add(len);   
                set.remove(arr[i]);
                i++;
            }
            else if(set.contains(arr[j]))
            {
                len=j-i;
                lengths.add(len);   
                set.remove(arr[i]);
                i++;
                flag = false;
            }
            else{
                set.add(arr[j]);
                j++;
            }
        }
        int ans = 0;
        int div = 1000000007;
        for (int k = 0; k < lengths.size(); k++) {
            int temp = lengths.get(k);
            int sum = temp*(temp+1);
            sum/=2;
            ans = (ans%div + sum%div)%div;
        }
        System.out.println(ans);
    }
}
