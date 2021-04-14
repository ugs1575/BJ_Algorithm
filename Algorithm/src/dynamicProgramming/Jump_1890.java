package dynamicProgramming;

import java.util.*;

public class Jump_1890 {
    static int[][] a = new int[100][100];
    static long[][] d = new long[100][100];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a[i][j] = sc.nextInt();
            }
        }
        d[0][0] = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(a[i][j] == 0) continue;
                //오른쪽
                if(j+a[i][j] < n){
                    d[i][j+a[i][j]] += d[i][j];
                }
                //위쪽
                if(i+a[i][j] < n){
                    d[i+a[i][j]][j] += d[i][j];
                }
            }
        }

        System.out.println(d[n-1][n-1]);
    }
}
