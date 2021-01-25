package Math;

import java.util.Scanner;

public class FibonacciNumber3_2749 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int[] d = new int[1500001];
        d[0] = 0;
        d[1] = 1;
        for(int i=2; i<=1500000; i++){
            d[i] = d[i-1] + d[i-2];
            d[i] %= 1000000;
        }

        int ans = (int) (n%1500000);
        System.out.println(d[ans]);
    }
}
