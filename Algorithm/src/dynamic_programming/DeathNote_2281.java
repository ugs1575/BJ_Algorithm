/*
* D[index][count] = index를 쓸것이고, 그 줄에 총 count개의 글자를 썼을 때
* 두 가지 경우를 생각하면 된다.
* 1. 다음줄로 넘어가는 경우
* 2. 현재 줄에 이이서 쓰는 경우
* 남는 칸의 제곱의 합을 구하는 것은 다음줄로 넘어 가는 경우에만 계산해준다.
* 왜냐, 마지막칸은 무시해야하기 때문에 그 부분을 처리할 수 있다.
*
* 이름 사이에 빈칸을 처리하는 것은
* 이름 뒤에 항상 빈칸을 한칸 붙이는 것으로 생각한다.
*
* 1. 다음 줄로 넘어가는 경우
*           count개(마지막 빈칸 포함 되어있을 거임) + space (m - count -1(count개에 포함되어있는 빈칸 빼주기)
* 다음줄 =>   A[index]
*
* go(index+1, A[index]+1) + space*space
*
* 2. 현재 줄에 이어서 쓰는 경우
* count개 A[index]+1(빈칸)
* go(index+1, count+1(빈칸)+A[index])
*
*
* */


package dynamicProgramming;

import java.util.*;

public class DeathNote_2281 {
    static int n, m;
    static int[] a = new int[1001];
    static int[][] d = new int[1000][1002];
    static int go(int index, int cnt){
        if(index == n) return 0; //마지막 무시
        int ans = d[index][cnt];
        if(ans != -1) return ans;
        //다음줄에 쓰는 경우
        int space = (m-(cnt-1));
        int cost = space*space;
        ans = go(index+1, a[index]+1)+cost;
        //같은줄에 쓰는 경우
        if(cnt + a[index] <= m){ //폭을 넘기지 않으면
            int cur = go(index+1, cnt+a[index]+1);
            if(ans > cur) ans = cur;
        }
        d[index][cnt] = ans;
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        for(int i=0; i<1000; i++){
            Arrays.fill(d[i],-1);
        }

        System.out.println(go(1, a[0]+1));
    }
}
