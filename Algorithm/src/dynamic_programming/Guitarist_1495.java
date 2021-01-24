package dynamicProgramming;

import java.util.Scanner;

public class Guitarist_1495 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n+1];
        boolean[][] d = new boolean[n+1][m+1];
        for(int i=1; i<=n; i++){
            a[i] = sc.nextInt();
        }
        d[0][s] = true;
        for(int i=1; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(d[i-1][j]){
                    if(j + a[i] <= m){
                        d[i][j+a[i]] = true;
                        //System.out.println(i+"/"+(j+a[i]));
                    }
                    if(j - a[i] >= 0){
                        d[i][j-a[i]] = true;
                        //System.out.println(i+"/"+(j-a[i]));
                    }
                }
            }
        }

        int ans = -1;
        for(int i=0; i<=m; i++){
            if(d[n][i]){
                ans = i;
            }
        }

        System.out.println(ans);
    }
}
