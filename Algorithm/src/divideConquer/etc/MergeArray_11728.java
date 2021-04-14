package divideConquer.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeArray_11728 {
    public static void merge(int start, int mid, int end, int[] a){
        int i = start;
        int j = mid+1;
        int k = 0;
        int[] b = new int[end-start];
        while (i<=mid && j<=end){
            if(a[i] <= a[j]){
                b[k++] = a[i++];
            }else{
                b[k++] = a[j++];
            }
        }

        while (i <= mid) b[k++] = a[i++];
        while (j <= end) b[k++] = a[j++];
        for(int t=start; t<=end; t++){
            a[t] = b[t-start];
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.valueOf(s[0]);
        int m = Integer.valueOf(s[1]);
        int[] a = new int[n];
        int[] b = new int[m];
        int[] ans = new int[n+m];
        s = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            a[i] = Integer.valueOf(s[i]);
        }
        s = br.readLine().split(" ");
        for(int i=0; i<m; i++){
            b[i] = Integer.valueOf(s[i]);
        }

        int i = 0;
        int j = 0;
        int k = 0;
        while (i<n && j<m){
            if(a[i] <= b[j]){
                ans[k++] = a[i++];
            }else{
                ans[k++] = b[j++];
            }
        }

        while (i < n) ans[k++] = a[i++];
        while (j < m) ans[k++] = b[j++];

        StringBuilder sb = new StringBuilder();

        for(int t=0; t<n+m; t++){
            sb.append(ans[t]+" ");
        }

        System.out.println(sb);

    }
}
