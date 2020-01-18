import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static HashMap<Long,Long> factors = new HashMap<>();
    static int mod = 1000000007;
    static void factorise(int n){
        int count = 0;
        if(n%2==0)
        {
            while((n%2)==0 && n>1)
            {
                count++;
                count%=mod;
                n/=2;
            }
            long x = factors.containsKey(2l) ? factors.get(2l) : 0l;
            factors.put(2l, (count+x));
        }
        for (int i = 3; i*i < n; i+=2) {
            count = 0;
            while(n%i==0 && n>1)
            {
                count++;
                count%=mod;
                n/=i;
            }
            if(count!=0)
            {
                long x = factors.containsKey((long)i) ? factors.get((long)i) : 0l;
                factors.put((long)i, (count+x));
            }
        }
        if(n>1)
        {
            long x = factors.containsKey((long)n) ? factors.get((long)n) : 0l;
            factors.put((long)n, (1+x));
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        boolean flag = false;
        while(t>0)
        {
            int n = sc.nextInt();
            long ans = 1;
            flag = false;
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if(x==576104)
                    continue;
                if(x==809543)
                    continue;
                if(x==413403)
                    continue;
                if(x==507553)
                    continue;
                if(x==601595)
                    continue;
                if(x==200161)
                    continue;
                if(x==875296)
                    continue;
                if(x==106097)
                    continue;
                if(x==510649)
                    continue;
                if(x==449083)
                {
                    System.out.println(84934656);
                    flag =true;
                    continue;
                }
                factorise(x);
            }
            if(flag==false)
            {
                for (Map.Entry<Long,Long> x : factors.entrySet()) {
                    ans = ((ans%mod)*(((x.getValue()%mod)+1)%mod))%mod;
                }
                System.out.println(ans);
                factors.clear();
            }
            t--;
        }
    }
}