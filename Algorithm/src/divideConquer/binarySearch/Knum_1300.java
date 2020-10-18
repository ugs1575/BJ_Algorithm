/*
* 8은 몇번째에 있을까?
* 1 2  3  4  5
* 2 4  6  8  10
* 3 6  9  12 15
* 4 8  12 16 20
* 5 10 15 20 25
*
* 예를 들어 4번째 라는 것은 자신의 앞에 자신보다 같거나 작은 수들이 3개가 있기 때문에 4번째 이
*
*
* 어떻게 구할 수 있을까?
* -> 1행 = 8/1 = 5
* a[1][j] <= 8
* 1 <= j <= 8/1
* -> 2행 = 8/2 = 3 (8포함)
* 나누어 떨어진다는 것은 그 행에 8이 포함되어 있다는 것이다
* 작은 것만 카운트 하면 3, 같은 수까지 하게 되면 4
* -> 3행 = 8/3 = 2
* -> 4행 = 8/4 = 1 (8포함)
* -> 5행 = 8/5 = 1
* 총 12개
* 나누어 떨어지는 것이 2번 있었으니까
* 8 2개가 13번째 14번째에 존재한다.
*
*
*
*
* */


package divideConquer.binarySearch;

import java.util.Scanner;

public class Knum_1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        long left  = 1;
        long right = n*n;
        long ans   = 0;

        while (left <= right){
            long mid = (left+right)/2;
            long cnt = 0;
            for(long i=1; i<=n; i++){
                cnt += Math.min(n, mid/i); //작거나 같은 수의 갯수를 구하고 크기를 넘어가는 경우가 최솟값을 n으로 상 고정해주기
            }
            if(cnt >=k){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        System.out.println(ans);
    }
}
