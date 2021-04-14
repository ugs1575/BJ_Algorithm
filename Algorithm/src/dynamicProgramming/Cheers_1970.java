/*
* D[i][j] = i번찌 사람부터 j번째 사람까지 최대 몇쌍이 건배를 할 수 있는가?
* i 번째와 k번째가 건배를 한 경우 문제를 두 부분으로 나눌 수 있다.
*
* i ..... k ......j
* D[i][j] = 1번(i와k) + D[i+1][k-1]번 + D[k+1][j]번
* 조건
* 1. i < k <= j
* 2. i의 콜라 브랜드 = k의 콜라 브랜드
*
* i번째 사람과 건배를 할 사람 k번째가 없는 경우가 있다.
* 같은 브랜드의 콜라가 없거나
* 그 사람이 건배를 안해야 최대가 되는 경우
* 그럴때는 i번째 사람이 없다고 치고
* D[i+1][j]
*
* 와 비교해 최댓값을 넣어주면 된다.
*
*
* */

package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Cheers_1970 {
    static int[] a = new int[1000];
    static int[][] d = new int[1000][1000];
    static int go(int i, int j){
        if(i >= j) return 0;
        int ans = d[i][j];
        if(ans != -1) return ans;
        ans = go(i+1, j);
        for(int k=i+1; k<=j; k++){
            int cur = 0;
            if(a[i] == a[k]){
                cur = go(i+1, k-1) + go(k+1, j) + 1;
            }
            if(ans < cur){
                ans = cur;
            }
        }
        d[i][j] = ans;
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            Arrays.fill(d[i], -1);
        }
        System.out.println(go( 0, n-1));
    }
}
