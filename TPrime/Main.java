import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static boolean CheckTPrime(long n)
    {
        long count = 0;
        long ans = 1;
        if(n%2==0)
        {
            while(n>1 && n%2==0)
            {
                count++;
                n/=2;
            }
            ans = ans*(count+1);
            if(ans>3)
            {
                return false;
            }
        }
        else{
            for(long i = 3 ; i*i <= n ; i+=2)
            {
                count = 0;
                while(n>1 && n%i==0)
                {
                    count++;
                    n/=i;
                }
                ans = ans*(count+1);
                if(ans>3)
                {
                    return false;
                }
            }
        }
        if(n>1)
        {
            ans*= 2;
        }
        if(ans == 3)
        {
            return true;
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n>0)
        {
            long a = sc.nextLong();
            if(CheckTPrime(a))
                System.out.println("YES");
            else
                System.out.println("NO");
            n--;
        }
        sc.close();
    }
}