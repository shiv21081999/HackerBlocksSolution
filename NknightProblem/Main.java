import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static ArrayList<ArrayList<Integer>> points  = new ArrayList<>();
    static int ans =0;
    static boolean check(int[][] grid, int row,int col)
    {
        if(row-2>=0 && col-1>=0)
        {
            if(grid[row-2][col-1]!=0)
                return false;
        }
        if(row-2>=0 && col+1<grid.length) 
        {
            if(grid[row-2][col+1]!=0)
                return false;
        }
        if(row+2<grid.length && col-1>=0)
        {
            if(grid[row+2][col-1]!=0)
                return false;
        }
        if(row+2<grid.length && col+1<grid.length)
        {
            if(grid[row+2][col+1]!=0)
                return false;
        }
        if(row-1>=0 && col-2>=0)
        {
            if(grid[row-1][col-2]!=0)
                return false;
        }
        if(row-1>=0 && col+2<grid.length)
        {
            if(grid[row-1][col+2]!=0)
                return false;
        }
        if(row+1<grid.length && col-2>=0)
        {
            if(grid[row+1][col-1]!=0)
                return false;
        }
        if(row+1<grid.length && col+2<grid.length)
        {
            if(grid[row+1][col+2]!=0)
                return false;
        }
        return true;
    }
    static void calcNKnight(int[][] grid,int row,int col,int n,int knights)
    {
        if(knights==0)
        {
            ans++;
            for (int i = 0; i < points.size(); i++) {
                ArrayList<Integer> amp = points.get(i);
                System.out.print("{"+amp.get(0)+"-"+amp.get(1)+"} ");
            }
            return;
        }
        if(col==n)
        {
            calcNKnight(grid, row+1, 0, n, knights);
            return;
        }
        if(row==n && col==0)
        {
            return;
        }
        for (int i = col; i < grid.length; i++) {
            if(check(grid,row,i))
            {
                grid[row][i]=1;
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(row);
                temp.add(i);
                points.add(temp);
                calcNKnight(grid, row, i+1, n, knights-1);
                grid[row][i]=0;
                points.remove(temp);
            }
        }
        calcNKnight(grid, row+1, 0, n, knights);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        calcNKnight(grid, 0, 0, n, n);
        System.out.println();
        System.out.println(ans);
    }
}