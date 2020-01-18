import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int n = b.length();
        int min = Integer.MAX_VALUE;
        int start = 0, front =-1,j = a.length()-1,count =0;
        String ans = "";
        HashMap<Character,Integer> mapB = new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            if(mapB.containsKey(b.charAt(i)))
            {
                int value = mapB.get(b.charAt(i));
                mapB.put(b.charAt(i),++value);
            }
            else
                mapB.put(b.charAt(i), 1);
        }
        HashMap<Character,Integer> mapA = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char x = a.charAt(i);
            if(mapB.containsKey(x)){
                if(mapA.containsKey(x))
                {
                    int r = mapA.get(x);
                    if(r < mapB.get(x))
                    {
                        count++;
                    }
                    mapA.put(x,++r);
                }
                else{
                    mapA.put(x,1);
                    count++;
                }
            }
            else {
                if(mapA.containsKey(x))
                {
                    int r = mapA.get(x);
                    mapA.put(x,++r);
                }
                else
                    mapA.put(x,1);
            }
            if(count==b.length())
            {
                for (int k = start; i < a.length() && (!mapB.containsKey(a.charAt(k)) || mapB.get(a.charAt(k)) < mapA.get(a.charAt(k))); k++) {
                    char y = a.charAt(k);
                    if(mapB.containsKey(y) && mapA.get(y) > mapB.get(y))
                    {
                        int r = mapA.get(y);
                        mapA.put(y,--r);
                    }
                    start++;
                }
                int length = i - start +1;
                if(min>length)
                {
                    min = length;
                    front = start;
                }
            }
        }
        if(front == -1)
            ans+="No string";
        else
            ans+=a.substring(front, front+min);
        System.out.println(ans);
        
    }
} 

