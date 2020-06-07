package bruteforce;

import java.util.*;

public class CombineNum1_1748 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nLength = String.valueOf(n).length();
        long ans = 0;
        int start = 1;
        int last = 9;
        for(int i=1; i<=nLength; i++){

            if(n<=last)
                last = n;
            ans     += i*(last-start+1);
            start   *= 10;
            last    = start*10-1;
        }

        System.out.println(ans);
    }
}
