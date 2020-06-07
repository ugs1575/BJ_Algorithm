package bruteforce;

import java.util.*;

public class NM5_15654 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int[] ans = new int[m];
        boolean[] check = new boolean[10001];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        permute(arr, ans, check, n, m, 0);
    }

    public static void permute(int[] arr, int[] ans, boolean[] check, int n, int m, int index){
        if(index == m){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<m; i++){
                sb.append(ans[i]);
                if(i != m-1) sb.append(" ");
            }
            System.out.println(sb);
        }else{
            for(int i=0; i<n; i++){
                if(check[arr[i]]) continue;
                ans[index] = arr[i];
                check[arr[i]] = true;
                permute(arr, ans, check, n, m, index+1);
                check[arr[i]] = false;
            }
        }

    }
}
