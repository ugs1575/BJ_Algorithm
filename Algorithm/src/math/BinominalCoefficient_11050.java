package Math;

import java.util.Scanner;

public class BinominalCoefficient_11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] d = new int[11];
        d[0] = 1;
        d[1] = 1;
        for(int i=2; i<=10; i++){
            d[i] = d[i-1] * i;
        }

        int ans = d[n]/(d[k]*d[n-k]);
        System.out.println(ans);
    }
}
