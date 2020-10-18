package divideConquer.binarySearch;

import java.io.*;

public class CuttingLan_1654 {
    static boolean check(long[] length, long x, int n, int k){
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += length[i]/x;
        }
        return sum >= n;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        int k = Integer.parseInt(a[0]);
        int n = Integer.parseInt(a[1]);
        long[] length = new long[k];
        long max = Long.parseLong(br.readLine());
        length[0] = max;

        for(int i=1; i<k; i++){
            long num = Long.parseLong(br.readLine());
            length[i] = num;
            if(num > max){
                max = num;
            }
        }

        long ans = 0;
        long left = 1;
        long right = max;
        while (left <= right){
            long mid = (left+right)/2;
            if(check(length, mid, n, k)){
                ans = Math.max(ans, mid);
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        System.out.println(ans);
    }
}
