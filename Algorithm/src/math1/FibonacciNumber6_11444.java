package Math;

import java.util.Scanner;

public class FibonacciNumber6_11444 {
    static long mod = 1000000007L;
    static long[][] multiplication(long[][] a, long[][] b){
        long[][] c = new long[2][2];
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<2; k++){
                    c[i][k] += a[i][j] * b[j][k];
                    c[i][k] %= mod;
                }
            }
        }

        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long[][] temp = new long[2][2];
        temp[0][0] = temp[0][1] = temp[1][0] = 1;

        long[][] ans = new long[2][2];
        ans[0][0] = ans[1][1] = 1;
        while (n>0){
            if(n%2 == 1)  {
                ans = multiplication(ans, temp);
            }

            n /= 2;
            temp = multiplication(temp, temp);
        }


        System.out.println(ans[0][1]);
    }
}
