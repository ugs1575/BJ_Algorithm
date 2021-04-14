package Math;

import java.util.*;

public class PowOfArray_10830 {
    static int n;
    static int[][] multiplication(int[][] A, int [][] B){
        int[][] C = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    C[i][k] += A[i][j] * B[j][k];
                    C[i][k] %= 1000;
                }
            }
        }

        return C;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long b = sc.nextLong();
        int[][] a = new int[n][n];
        int[][] temp = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a[i][j] = sc.nextInt();
                temp[i][j] = 0;
            }
            temp[i][i] = 1;
        }

        while (b>0){
            if(b%2 == 1){
                temp = multiplication(temp, a);
            }

            a = multiplication(a, a);
            b /= 2;
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }


    }
}
