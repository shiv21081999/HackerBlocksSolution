import java.util.*;
import java.util.Arrays;
import java.math.BigInteger;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        String a = Integer.toBinaryString(x);
        String b = Integer.toBinaryString(y);
        int m = a.length();
        int n = b.length();
        for(int i = 0; i < (n-m) ;i++)
        {
            a = '0'+a;
        }
        String ans ="";
        boolean flag = false;
        if(a.compareTo(b)!=0)
        {
            for (int i = 0; i < a.length(); i++) {
                if(a.charAt(i)!=b.charAt(i))
                {
                    ans = ans+1;
                    flag=true;
                }
                else if(a.charAt(i)=='0' && b.charAt(i)=='0' && flag)
                {
                    ans = ans+1;
                }
                else if(a.charAt(i)=='1' && b.charAt(i)=='1' && i!=0 && flag)
                {
                    ans = ans+1;
                }
                else{
                    ans = ans+0;
                }
            
            }
        }
        else{
            ans=ans+"0";
        }
        int fans = 0,mul = 1;
        for (int i = ans.length()-1; i >=0; i--) {
            fans+=((ans.charAt(i)-48)*mul);
            mul*=2;
        }
        System.out.println(fans);
    }
}