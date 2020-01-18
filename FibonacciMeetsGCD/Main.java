import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static int mod = 1000000007;
    static int[] arr = new int[100005];
    static class SegmentedTree{
        public long[] st = new long[0];
        public SegmentedTree(int n){
            st = new long[4*n];
        }
        public void build(int start , int end , int node)
        {
            if(start == end)
            {
                st[node] = arr[start];
                return;
            }
            int mid = (start+end)/2;
            build(start, mid, 2*node+1);
            build(mid+1, end, 2*node+2);
            st[node] = GCD(st[2*node+1],st[2*node+2]);
        }
        public void update(int start, int end , int index , int val, int node)
        {
            if(start == end)
            {
                long x = fibCalc(val);
                arr[index] = val;
                st[node] = x;
                return;
            }
            int mid = (start+end)/2;
            if(index <= mid)
                update(start, mid, index, val, 2*node+1);
            else
                update(mid+1, end, index, val, 2*node+2);
            st[node] = GCD(st[2*node+1],st[2*node+2]);
        }
        public long query(int start, int end, int l , int r, int node){
            if(r<start || end<l)
            {
                return 0;
            }
            if(start>= l && end<=r)
            {
                return st[node];
            }
            int mid = (start+end)/2;
            long q1 = query(start, mid, l, r, 2*node+1);
            long q2 = query(mid+1, end, l, r, 2*node+2);
            return GCD(q1,q2);
        }
        public long GCD(long a, long b)
        {
            return b==0 ? a : GCD(b, a%b);
        }
        public long fibCalc(long n){
            long[][] mat = {{1,1},{1,0}};
            long[][] res = {{1,0},{0,1}};
            n--;
            while(n>0)
            {
                if((n&1)>0)
                {
                    res = prod(res,mat);
                }
                mat = prod(mat,mat);
                n = n>>1;
            }
            return res[0][0];
        }
        public long[][] prod(long[][] a, long[][] b){
            long[][] ans = new long[a.length][b[0].length];
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[0].length; j++) {
                    for (int k = 0;k < a[0].length;k++) {
                        ans[i][j]+=(a[i][k]*b[k][j])%mod;
                    }
                    ans[i][j]%=mod;
                }
            }
            return ans;
        }
    }
    // static public int GCD(int a, int b)
    // {
    //     return b==0 ? a : GCD(b, a%b);
    // }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        SegmentedTree st = new SegmentedTree(n);
        long[] x = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        st.build(0, n-1, 0);
        for (int i = 0; i < q; i++) {
            int l,r;
            l = sc.nextInt();
            r = sc.nextInt();
            System.out.println(st.fibCalc(st.query(0, n-1, l-1, r-1, 0))%mod);
        }
    }
}