package divideConquer.binarySearch;

import java.util.Scanner;

public class CuttingTree_2805 {
    static boolean check(long[] length, long h, int m){
        long sum = 0;
        for(int i=0; i<length.length; i++){
            if(length[i] - h > 0){
                sum += length[i]-h;
            }
        }

        return sum >= m;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] length = new long[n];
        for(int i=0; i<n; i++){
            length[i] = sc.nextLong();
        }

        long max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, length[i]);
        }

        long left = 1;
        long right = max;
        long ans = 0;
        while (left <= right){
            long mid = (left+right)/2;
            if(check(length, mid, m)){
                ans = Math.max(ans, mid);
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        System.out.println(ans);
    }
}
