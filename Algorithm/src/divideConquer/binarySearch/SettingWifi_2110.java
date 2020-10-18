/*
* 첫번째 집에 항상 공유기가 존재해야 하는 이유가 있나요?
* 간단히 말하면 손해를 보지 않기 때문입니다.
* 최적으로 되도록 공유기를 C개 설치했는데 첫 번째 집에 설치를 안 해놓았다고 칩시다.
* 그러면 맨 왼쪽 집에 있는 공유기를 첫번째 집에 옮기면 공유기 사이의 거리가 멀어지니까
* 당연히 가장 인접한 두 공유기 사이의 거리가 늘면 늘지 줄진 않습니다.
* 따라서 맨 첫번째 집에 공유기를 설치하는 최적해가 언제나 존제하므로
* 맨 첫번째 집에 무조건 설치한다고 가정해도 됩니다.
*
* */


package divideConquer.binarySearch;

import java.util.*;

public class SettingWifi_2110 {
    static boolean possible(int[] a, int mid, int c){
        int cnt = 1;
        int last = a[0];
        for(int house : a){
            if(house - last >= mid){
                cnt += 1;
                last = house;
            }
        }

        return cnt >= c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        int left = 1;
        int right = a[n-1] - a[0];
        int ans = 0;
        while (left <= right){
            int mid = (left+right)/2;
            if(possible(a, mid, c)){
                left = mid+1;
                ans = Math.max(ans, mid);
            }else{
                right = mid-1;
            }
        }

        System.out.println(ans);
    }
}
