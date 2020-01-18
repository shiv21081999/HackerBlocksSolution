import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static ArrayList<String> ans = new ArrayList<>();
    static boolean isSwap(int[] arr , int start , int check){
        for (int i = start; i < check; i++) {
            if(arr[i]==arr[check])
                return false;
        }
        return true;
    }
    static void getDistinctPermute(int[] arr, int pos)
    {
        if(pos == arr.length)
        {
            String str = "";
            for (int i = 0; i < arr.length; i++) {
                str+=arr[i]+" ";
            }
            ans.add(str);
            return;
        }
        for (int i = pos; i < arr.length; i++) {
            int[] copy = Arrays.copyOf(arr, arr.length);
            if(pos == i)
                getDistinctPermute(arr, pos+1);
            else if(isSwap(arr, pos, i))
            {
                int temp = copy[pos];
                copy[pos] = copy[i];
                copy[i] = temp;
                getDistinctPermute(copy, pos+1);
            }

        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        getDistinctPermute(arr, 0);
        Collections.sort(ans);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}