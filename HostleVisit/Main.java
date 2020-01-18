import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        while(q>0){
            int m = sc.nextInt();
            if(m == 1)
            {
                long x = sc.nextLong();
                long y = sc.nextLong();
                long rock = (x*x) + (y*y);
                pq.add(rock);
            }
            if(m == 2)
            {
                long arr[] = new long[k];
                for (int i = 0; i < k; i++) {
                    arr[i] = pq.poll();
                }
                System.out.println(arr[k-1]);
                for (int j = 0; j < k; j++) {
                    pq.add(arr[j]);
                }
            }
            q--;
        }
    }
}