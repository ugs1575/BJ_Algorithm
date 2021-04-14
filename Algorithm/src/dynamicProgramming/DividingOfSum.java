package DynamicProgramming;
import java.util.*;
/**
 * Created by woogyeongseo on 22/9/19.
 */
public class DividingOfSum {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        long[][] d = new long[n+1][k+1];

        d[0][0] = 1;

        for(int j=1; j<=k; j++){
            for(int i=0; i<=n; i++){
                for(int x=0; x<=i; x++){
                    d[i][j] += d[i-x][j-1];
                    d[i][j] %= 1000000000L;

                }
            }
        }

        System.out.println(d[n][k]);

    }
}
