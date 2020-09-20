/*
 * o-----o-----o----o--     (스위치)
 * |  |  |  | |  |  |  |
 * 2  3  3  3 3  3  3  2    (전구의 상태를 바꿀 수 있는 스위치의 개수)
 * |  |  |  | |  |  |  |
 * -- o---- o---- o---- o   (스위치)
 * 상태를 바꿀수 있는 방법이 1개인 경우가 없다
 * 1번 스위치를 어떻게 누를지 결정하면, 각각의 칸을 바꿀 수 있는 방법이 한개가 된다.
 *    --o-----o-----o--     (스위치)
 *    |  |  | |  |  |  |
 * 1  2  3  3 3  3  3  2    (전구의 상태를 바꿀 수 있는 스위치의 개수)
 * |  |  |  | |  |  |  |
 * -- o-----o-----o----o   (스위치)
 *    --o-----o-----o--     (스위치)
 *    |  |  | |  |  |  |
 *    1  2  3 3  3  3  2    (전구의 상태를 바꿀 수 있는 스위치의 개수)
 *       |  | |  |  |  |
 *       ---o----o----o   (스위치)
 *
 * 연속해서 실행하면 마지막 전구를 제외하고 A와 B가 같게된다.
 *
 * */

package greedy;

import java.util.*;

class Pair{
    boolean first;
    int second;
    Pair(boolean first, int second){
        this.first = first;
        this.second = second;
    }
}

public class LightAndSwitch_2138 {
    static void flip(int[] a, int x, int n){
        for(int i=x-1; i<=x+1; i++){
            if(i < 0 || i >= n) continue;
            a[i] = 1-a[i];
        }
    }

    static Pair go(int[] a, int[] b, int n){
        int ans = 0;
        for(int i=0; i<n-1; i++){
            if(a[i] != b[i]) {
                flip(a, i + 1, n);
                ans += 1;
            }
        }

        boolean ok = true;
        for(int i=0; i<n; i++){
            if(a[i] != b[i]){
                ok = false;
            }

        }


        return new Pair(ok, ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        String str = sc.next();
        for(int i=0; i<n; i++){
            a[i] = str.charAt(i)-'0';
        }
        str = sc.next();
        for(int i=0; i<n; i++){
            b[i] = str.charAt(i)-'0';
        }

        //첫번째 스위치를 누르지 않는다
        int[] temp = new int[n];
        System.arraycopy(a, 0, temp, 0, n);
        Pair p1 = go(temp, b, n);

        //첫번째 스위치를 누른다
        flip(a, 0, n);
        Pair p2 = go(a, b, n);
        if(p2.first){
            p2.second += 1; //첫번째 스위치 누른거 더해주기
        }

        if(p1.first && p2.first){
            System.out.println(Math.min(p1.second, p2.second));
        }else if(p1.first){
            System.out.println(p1.second);
        }else if(p2.first){
            System.out.println(p2.second);
        }else{
            System.out.println(-1);
        }

    }
}
