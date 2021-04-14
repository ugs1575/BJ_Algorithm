package DynamicProgramming;
import java.util.*;
import java.math.*;

/**
 * Created by woogyeongseo on 7/9/19.
 */
public class StepOnStairs {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[][] d = new int[n][3];

        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            if(i-2 >= 0){
                d[i][1] = Math.max(d[i-2][1],d[i-2][2]);
            }
            d[i][1] += a[i];

            if(i-1 >= 0){
                d[i][2] = d[i-1][1];
            }
            d[i][2] += a[i];
        }

        int ans = Math.max(d[n-1][1], d[n-1][2]);

        System.out.print(ans);
    }
}
