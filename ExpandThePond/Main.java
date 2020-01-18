import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static int ans = 0;
    static boolean flag = false;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static void expandThePond(int[][] pond ,int row ,int col,int count){
        if(row>=pond.length || col>=pond.length || row<0 || col<0)
        {
            ans = Math.max(ans, count);
            return;
        }
        if(flag == true && pond[row][col]==0)
        {
            ans = Math.max(ans, count);
            return;
        }
        if(flag == false && pond[row][col]==0)
        {
            flag = true;
            for (int i = 0; i < 4; i++) {
                expandThePond(pond, row+dx[i], col+dy[i], count+1);    
            }
            flag = false;
        }
        if(pond[row][col]==1)
        {
            pond[row][col] = 0;
            for (int i = 0; i < 4; i++) {
                expandThePond(pond, row+dx[i], col+dy[i], count+1);    
            }
            pond[row][col] = 1;
        }
        expandThePond(pond, row+1, col, count);
        expandThePond(pond, row, col+1, count);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] pond = new int[n][m];
        for (int i = 0; i < pond.length; i++) {
            for (int j = 0; j < pond[i].length; j++) {
                pond[i][j] = sc.nextInt();
            }
        }
        expandThePond(pond,0,0,0);
        System.out.println(ans);
    }
}