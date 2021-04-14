package Math;

import java.util.Scanner;

public class BinominalCoefficient2_11051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[][] d = new long[1001][1001];
        for(int i=0; i<=n; i++){
            d[i][0] = 1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                d[i][j] = d[i-1][j-1] + d[i-1][j];
                d[i][j] %= 10007;
            }
        }

        System.out.println(d[n][k]);
    }
}
