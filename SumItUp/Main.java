import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static HashSet<String> result = new HashSet<>();
    static public class SortByFirstNum implements Comparator<String>{
        public int compare(String a, String b)
        {
            String[] arr1 = a.split(" ");
            String[] arr2 = b.split(" ");
            int i = 0 ,j = 0;
            while(i<arr1.length && j<arr2.length)
            {
                if(Integer.parseInt(arr1[i])!=Integer.parseInt(arr2[j]))
                    return Integer.parseInt(arr1[i])-Integer.parseInt(arr2[j]);
                else{
                    i++;j++;
                }
            }
            return a.length()-b.length();
        }
    }
    static void findSumItUp(long sum,int pos, int arr[] , String ans)
    {
        if(sum == 0)
        {
            result.add(ans);
            return;
        }
        if(sum<0 || pos>=arr.length)
            return;
        findSumItUp(sum-arr[pos], pos+1, arr, ans+arr[pos]+" ");
        findSumItUp(sum, pos+1, arr, ans);
    } 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        long t = sc.nextLong();
        findSumItUp(t, 0, arr, "");
        ArrayList<String> ares = new ArrayList<>(result);
        Collections.sort(ares,new SortByFirstNum());
        for (int i = 0; i < ares.size(); i++) {
            System.out.println(ares.get(i));
        }
    }
}