package divideConquer.binarySearch;

import java.util.Scanner;

public class DividingPart_13397 {
    static boolean check(int score, int[] a, int m){
        int cnt = 1;
        int min = a[0];
        int max = a[0];
        for(int i=1; i<a.length; i++){
            if(a[i] < min) min = a[i];
            if(a[i] > max) max = a[i];
            int diff = max - min;
            if(diff > score){
                cnt += 1;
                min = a[i];
                max = a[i];
            }
        }
        //System.out.println(score+"/"+ cnt);

        return cnt <= m;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int left  = 0;
        int right = 9999;
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        //System.out.println(left);
        //System.out.println(right);

        int ans = 0;
        while (left <= right){
            int mid = (left+right)/2;
            if(check(mid, a, m)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        System.out.println(ans);
    }
}
