import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static ArrayList<Integer> primes = new ArrayList<>();
    static boolean[] prime = new boolean[100000005];
    static void seive(){
        Arrays.fill(prime,true);
        prime[0] = prime[1] = false;
        for (int i = 2; i*i < prime.length; i++) {
            if(prime[i])
            {
                primes.add(i);
                for (int j = i; i*j < prime.length; j++) {
                    prime[i*j] = false;
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n,m;
        seive();
        while(t>0)
        {
            m = sc.nextInt();
            n = sc.nextInt();
            long[] a = new long[n-m+1];
            for (int i = 0; i < a.length; i++) {
                a[i] = i+m;
            }
            for (int prime : primes) {
                if(prime*prime>n)break;
                int start = (m/prime)*prime;
                if(prime>=m) start = prime*2;
                for (int i = start; i <= n; i+=prime) {
                    if(i<m)continue;
                    a[i-m]/=prime;
                }
            }
            for (int i = 0; i < a.length; i++) {
                if(a[i]!=m+i || i+m == 1)continue;
                System.out.println(a[i]);
            }
            System.out.println();
            t--;
        }
    }
}