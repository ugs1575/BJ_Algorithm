package bruteforce.etc;

import java.util.*;

public class NM3_15651 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ans = new int[m];
        permute(0, n, m, ans);
    }

    public static void permute(int index, int end, int r, int[] ans){
        if(index == r){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<r; i++){
                sb.append(ans[i]);
                if(i != r-1) sb.append(" ");
            }
            sb.append("\n");
            System.out.print(sb);
        }else{
            for(int i=1; i<=end; i++){
                ans[index] = i;
                permute(index+1, end, r, ans);
            }
        }
    }
}
