package Math;

import java.util.Scanner;

public class MultiOfArray_2740 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int[][] a = new int[n][r];
        for(int i=0; i<n; i++){
            for(int j=0; j<r; j++){
                a[i][j] = sc.nextInt();
            }
        }

        sc.nextInt();
        int m = sc.nextInt();
        int[][] b = new int[r][m];
        for(int i=0; i<r; i++){
            for(int j=0; j<m; j++){
                b[i][j] = sc.nextInt();
            }
        }

        int[][] c = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<r; j++){
                for(int k=0; k<m; k++){
                    c[i][k] += a[i][j]*b[j][k];
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }

    }
}
