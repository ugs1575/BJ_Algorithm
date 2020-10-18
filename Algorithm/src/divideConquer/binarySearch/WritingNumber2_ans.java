/*
* N번째 수의 길이는 자리수 별로 길이를 계산하는 방식으로 알 수 있다.
* 이 점을 이용해서 이분 탐색으로 N을 결정하고
* 그 때마다 수의 길이를 재보고
* K보다 작거나 같은지 비교해본다.
*
* 예)
* N=20, K=23인 경우
* 1부터 20까지 이어 붙인 수의 길이 : 31
* K가 길이보다 작기 때문에
* N이 20보다 작아져도 등장한다는 것을 알 수 있다
*
* 현재 가능한 정답의 범위 : 1~20
* 1부터 10까지 이어 붙인 수의 길이 : 11
* K가 길이보다 크기 때문에
* N이 10보다 작아지면 절대 K번째 수가 없다는 것을 알 수 있다.
* 하지만, 10보다 커지면 등장할 수도 있다.
* 따라서, 오른쪽을 택한다
*
** */

package divideConquer.binarySearch;

import java.util.*;

public class WritingNumber2_ans {
    static long calc(int n){
        long ans = 0;
        for(int start=1, len=1; start<=n; start*=10, len++){
            int end = start*10-1;
            if(end > n){
                end = n;
            }
            ans += (long)(end-start+1)*len;
        }
        return ans;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        long k = sc.nextLong();
        if(calc(n) < k){
            System.out.println(-1);
            System.exit(0);
        }
        int left  = 1;
        int right = n;
        int ans   = 0;
        while (left <= right){
            int mid = (left+right)/2;
            long len = calc(mid);
            if(len < k){
                left = mid+1;
            }else{
                ans = mid;
                right = mid-1;
            }
        }
        String s = Integer.toString(ans);
        long l = calc(ans);
        System.out.println(s.charAt((int) (s.length()-(l-k)-l)));
    }
}
