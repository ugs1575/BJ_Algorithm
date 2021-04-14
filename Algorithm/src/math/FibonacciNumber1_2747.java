package Math;

import java.util.Scanner;

public class FibonacciNumber1_2747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[46];
        d[0] = 0;
        d[1] = 1;
        for(int i=2; i<=45; i++){
            d[i] = d[i-1]+d[i-2];
        }

        System.out.println(d[n]);
    }

}
