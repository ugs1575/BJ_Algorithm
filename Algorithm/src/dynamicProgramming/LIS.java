package DynamicProgramming;

/**
 * Created by woogyeongseo on 1/9/19.
 */
import java.util.*;

public class LIS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];

        //수열A에 요솟값 넣기
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            d[i] = 1;
        }

        for(int i=1; i<n; i++){
            int length = 0;
            int max = 0;
            for(int j=0; j<i; j++){
                if(a[i]>a[j]){
                    length = d[j] + 1;
                    if(length>max){
                        max = length;
                        d[i] = max;
                    }
                }
            }
        }

        int ans = d[0];
        for(int i=0; i<n; i++){
            if(d[i]>ans){
                ans = d[i];
            }
        }

        System.out.print(ans);
    }
}