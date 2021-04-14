package dynamicProgramming;

import java.util.*;

public class Coin2_2294 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[k+1];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        Arrays.fill(d, -1);

        d[0] = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<=k; j++){
                if(j-a[i] >= 0 && d[j-a[i]] != -1) {
                    if (d[j] == -1 || d[j] > d[j-a[i]]+1) {
                        d[j] = d[j-a[i]]+1;
                    }
                }
            }
        }

        System.out.println(d[k]);
    }
}
