import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static int ans = Integer.MAX_VALUE;
    static int[] 
    static void getManHattan(int[] start , int[] end , int[][] pipe, int count)
    {
        if(start[0]==end[0] && start[1]==end[1])
        {
            ans = Math.min(ans, count);
            return;
        }
        if(start[0]<1 || end[0]<1 || start[1]<1 || end[1]<1)
        {
            return;
        }
        if(start[0]>2000 || end[0]>2000 || start[1]>2000 || end[1]>2000)
        {
            return;
        }
        for (int i = 0; i < 4; i++) {
            
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();   
            int[] start = new int[2];
            int[] end = new int[2];
            start[0] = sc.nextInt();
            start[1] = sc.nextInt();
            end[0] = sc.nextInt();
            end[1] = sc.nextInt();
            ans = Math.abs(start[0]-end[0]) + Math.abs(start[1]-end[1]);
            int[][] arr = new int[n][5];
            int i = 0;
            while(n>0)
            {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                arr[i][2] = sc.nextInt();
                arr[i][3] = sc.nextInt();
                arr[i][4] = sc.nextInt();
                i++;
                n--;
            }
            
            t--;
        }
    }
}