import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static boolean[] column = new boolean[100];
    static boolean[] d1 = new boolean[100];
    static boolean[] d2 = new boolean[100];
    static int ans = 0;
    static boolean check(int row, int col,int n)
    {
        if(column[col])
            return false;
        if(d1[n+row-col])
            return false;
        if(d2[row+col])
            return false;
        return true;
    }
    static void placeNQueen(int row , int n){
        if(row==n)
        {
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
                if(check(row,i,n))
                {
                    column[i]=true;
                    d1[row-i+n]=true;
                    d2[row+i]=true;
                    placeNQueen(row+1, n);
                    column[i]=false;
                    d1[row-i+n]=false;
                    d2[row+i]=false;
                }
                
            }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        placeNQueen(0, n);
        System.out.println(ans);
        sc.close();
    }
}