import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static int count1 = 0,ans = Integer.MIN_VALUE;
    static int n = 0;
    static void getCount(int[][] board,int row,int col,int count)
    {
        if(row<0 || col<0 || row>=n || col>=n)
            return;
        if(board[row][col]==0)
            return;
        ans = Math.max(ans, count+1);
        board[row][col] = 0;
        getCount(board, row+1, col+2,count+1);
        getCount(board, row+1, col-2,count+1);
        getCount(board, row-1, col+2,count+1);
        getCount(board, row-1, col-2,count+1);
        getCount(board, row+2, col+1,count+1);
        getCount(board, row+2, col-1,count+1);
        getCount(board, row-2, col+1,count+1);
        getCount(board, row-2, col-1,count+1);
        board[row][col] = 1;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] board = new int[n][n];
        int count=0;
        int row=0,col=0;
        count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j]==1)
                {
                    count++;
                    if(count==0)
                    {
                        row = i;
                        col = j;
                    }

                }

            }
        }
        getCount(board, row, col,0);
        System.out.println(count-ans);
    }
}