package divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NumberCard_10815 {
    public static boolean search(int x, int[] a){
        int left = 0;
        int right = a.length-1;

        while (left <= right){
            int mid = (left+right)/2;
            if(a[mid] == x){
                return true;
            }else if(x < a[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.valueOf(line[i]);
        }
        Arrays.sort(a);
        int m = Integer.valueOf(br.readLine());
        line = br.readLine().split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int x = Integer.valueOf(line[i]);
            boolean find = search(x, a);
            if(find) ans.append("1 ");
            else ans.append("0 ");
        }
        System.out.println(ans);
    }
}
