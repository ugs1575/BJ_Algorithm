package dynamicProgramming;

import java.util.*;

public class Palindrome_10942_bottom_up {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[][] d = new int[n][n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            d[i][i] = 1;
        }

        for(int i=0; i<n-1; i++){
            if(a[i] == a[i+1]){
                d[i][i+1] = 1;
            }
        }

        for (int k=2; k<n; k++) {
            for (int i=0; i<n-k; i++) {
                int j = i+k;
                if (a[i] == a[j] && d[i+1][j-1] == 1) {
                    d[i][j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int m = sc.nextInt();
        while (m-- > 0){
            int s = sc.nextInt();
            int e = sc.nextInt();
            sb.append(d[s-1][e-1]);
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
