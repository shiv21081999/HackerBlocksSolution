import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    static int seive(int n){
        boolean[] pb = new boolean[1_000_000_05];
        Arrays.fill(pb,true);
        int index=0;
        for(int i = 2 ; i*i < 1_000_000_05 ; i++)
        {
            if(pb[i])
            {
                for (int j = i; i*j < 1_000_000_05; j++) {
                    pb[i*j] = false;
                }
            }
        }
        for (int i = 2; i < pb.length; i++) {
            if(pb[i])
            {
                index++;
            }
            if(index==n)
            {
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(seive(n));

    }
}