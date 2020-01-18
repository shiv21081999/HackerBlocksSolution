import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static int setBitPos(long n){
        long mul = 1;
        for(int i = 0 ; i < 64; i++)
        {
            mul = mul<<i;
            if((mul&n)>0)
                return i;
        }
        return -1;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n>=70)
        {
            long[] arr = new long[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextLong();
            }
            System.out.println("YES");
        }
        else{
            boolean flag = false;
            long[] arr = new long[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextLong();
            }
            long xor = 0;
            for (int i = 0; i < arr.length-3; i++) {
                for (int j = 0; j < arr.length-2; j++) {
                    for (int k = j+1; k < arr.length-1; k++) {
                        for (int l = k+1; l < arr.length; l++) {
                            xor = arr[i]^arr[j]^arr[k]^arr[l];
                            if(xor==0)
                            {
                                flag = true;
                                break;
                            }
                        }
                        if(flag == true)
                        {
                            break;
                        }
                    }
                    if(flag == true)
                    {
                        break;
                    }
                }
                if(flag == true)
                {
                    break;
                }
            }
            if(flag==true)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}