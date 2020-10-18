/*
* size을 이분탐색하면서 3개가 나오느냐로 생각하는게 아니라
* 3개 이상이 나오는가로 봐야함
* 그룹을 나눌때는 size이상이 나오면 그룹 +1
*
* */


package divideConquer.binarySearch;

import java.util.*;

public class ExtraLessen_2343 {
    static int[] a = new int[1000000];
    static int n, m;
    static boolean go(int size){
        int cnt = 1;
        int sum = 0;
        for(int i=0; i<n; i++){
            if(sum + a[i] > size){
                cnt += 1;
                sum = a[i];
            }else{
                sum += a[i];
            }
        }
        return cnt <= m;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int left = 0;
        int right = 0;

        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
            if(left < a[i]){
                left = a[i];
            }
            right += a[i];
        }

        int ans = 0;
        while (left <= right){
            int mid = (left+right)/2;
            if(go(mid)){
                ans = mid;
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }
}