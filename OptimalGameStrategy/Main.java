import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static int ans = Integer.MIN_VALUE;
    static void getMaxWin(int[] a, int l, int r,int count,boolean flag)
    {
        if(l>r)
        {
            ans = Math.max(ans, count);
            return;
        }
        if(flag==true)
        {
            getMaxWin(a, l+1, r, count,false);
            getMaxWin(a, l, r-1, count, false);
        }
        else
        {
            getMaxWin(a, l+1, r, count+a[l],true);
            getMaxWin(a, l, r-1, count+a[r], true);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        getMaxWin(a, 0, n-1, 0, false);
        System.out.println(ans);
    }
}