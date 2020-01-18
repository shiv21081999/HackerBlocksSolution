import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static HashMap<Integer,Integer> factorise(int n){
        HashMap<Integer,Integer> primefactors = new HashMap<>();
        int count = 0;
        while(n%2==0 && n>0)
        {
            count++;
            n=n>>1;
        }
        primefactors.put(2, count);
        for(int i = 3 ; i <= n ; i+=2 )
        {
            count = 0;
            while(n%i==0 && n>0)
            {
                count++;
                n/=i;
            }
            if(count!=0)
                primefactors.put(i, count);
        }
        return primefactors;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = n;
        long digitsum = 0;
        while(r>0)
        {
            digitsum = digitsum+(r%10);
            r/=10;
        }
        HashMap<Integer,Integer> factors = factorise(n);
        long factorsum = 0;
        for (Map.Entry<Integer,Integer> x : factors.entrySet()) {
            long factdigitsum =0;
            r = x.getKey();
            while(r>0)
            {
                factdigitsum+=(r%10);
                r/=10;
            }
            factorsum+=(factdigitsum*x.getValue());
        }
        if(factorsum==digitsum)
            System.out.println(1);
        else
            System.out.println(0);
    }
}