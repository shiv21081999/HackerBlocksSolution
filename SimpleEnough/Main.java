import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static long simpleEnough(long n, long start , long end , long l , long r){
        if(start==end)
        {
            return n;
        }
        long mid = (start+end)/2;
        long ans = 0;
        if(mid>l)
            ans += simpleEnough(n>>1, start, mid-1, l, r);
        if(mid<r)
            ans += simpleEnough(n>>1, mid+1, end, l, r);
        if(l<=mid && r>=mid)
        {
            ans+=(n%2);
        }
        return ans;        
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long l = sc.nextLong();
        long r = sc.nextLong();
        long len = 1;
        long temp = n;
        long div = 2;
        while(temp>1)
        {
            temp>>=1;
            len+=div;
            div<<=1;
        }
        System.out.println(simpleEnough(n,1,len,l,r));
        sc.close();
    }
}