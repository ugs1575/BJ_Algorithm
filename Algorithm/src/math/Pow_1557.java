/*
* 에라테네스의 체를 이용해서 먼저 제곱 ㄴㄴ 수를 걸러주고
* 포함배제원리를 이용해 나누어 떨어지는 개수를 구해서 mid에서 빼준다
* 이분탐색을 이용해서 k번째 수를 구해준다.
*
* */

package Math;

import java.util.*;

public class Pow_1557 {
    static int MAX = 100000;
    static ArrayList<Integer> primes = new ArrayList<Integer>();
    static boolean[] c = new boolean[MAX+1];;
    static long calc(int index, long num, long mid){
        if(index >= primes.size()) return 0;
        if(num*primes.get(index) > mid) return 0;
        long ans = 0;
        ans += mid/(num*primes.get(index));
        ans += calc(index+1, num, mid);
        ans -= calc(index+1, num*primes.get(index), mid);

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i=2; i<=MAX; i++){
            if(c[i]) continue;
            primes.add(i*i);
            for(int j=i+i; j<=MAX; j+=i){
                c[j] = true;
            }
        }

        int k = sc.nextInt();
        long left = 0;
        long right = 8;
        long ans = right;
        while (left <= right){
            long mid = (left+right)/2;
            int cnt = (int) (mid - calc(0,1,mid));
            if(cnt >= k){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        System.out.println(ans);

    }
}
