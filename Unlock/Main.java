import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n+1];
        int[] pos = new int[n+1];
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
                pos[arr[i]] = i;
            }
            int index = 1;
            while(k>0 && index<n+1)
            {
                int max = n+1-index;
                if(arr[index] != max)
                {
                    int temp = arr[index];
                    arr[index] = arr[pos[max]];
                    arr[pos[max]] = temp;
                    temp = pos[max]; 
                    pos[arr[index]] =index;
                    pos[arr[temp]] = temp;
                    k--;
                }
                index++;
            }
            for (int i = 1; i < n+1; i++) {
                System.out.print(arr[i]+" ");
            }
    }
}