/*
* 시간복잡도 : O(n^2+m)
*
* 팰린드롬이란 앞으로 읽어도 뒤로 읽어도 똑같은 문자열을 말한다.
*
* 단순히 이 문자열이 팰린드롬인지 아닌지 판별해 보기 위한 가장 간단한 방법은
* 문자열을 뒤집어서
* 원래 문자열이랑 같은지 하나씩 비교해 보면 된다.
*
* 이 문제같은 형식을 쿼리 문제라하는데
* 어떤 것이 있고 그것에 어떤 처리를 해서 답을 구하는 형식을 말한다.
*
* ********* 이문제를 푸는 방식
*
* 점화식 정의 D[i][j] = A[i] ~ A[j]가 팰린드롬이면 1, 아니면 0
*
* 길이가 1인 문자는 무조건 팰린드롬이다
*   D[i][j] = 1
* 길이가 2인 문자는 두 문자가 같으면 팰린드롬이다.
*   D[i][i+1] = 1(A[i] == A[i+1])
*   D[i][i+1] = 0(A[i] != A[i+1])
* 이외 판별하기 위해서는
* i i+1 ... j-1 j
*
* i == j 같다  -> D[i+1][j-1] 가 팰린드롬인지 확인 -> 재귀호출
*       다르다 -> 팰린드롬이 아니다
*
* */

package dynamicProgramming;

import java.util.*;

public class Palindrome_10942_top_down {
    static int[] a;
    static int[][] d;
    static int go(int i, int j){
        if(d[i][j] != -1) return d[i][j];

        //길이가 1일때
        if(i == j){
            return 1;
        }else if(j == i+1){ //길이가 2일때
            if(a[i] == a[j]) return 1;
            else return 0;
        }

        if(a[i] == a[j]){
            return d[i][j] = go(i+1, j-1);
        }else{
            return d[i][j] = 0;
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n];
        d = new int[n][n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
            Arrays.fill(d[i], -1);
        }

        StringBuilder sb = new StringBuilder();
        int m = sc.nextInt();
        while (m-- > 0){
            int s = sc.nextInt();
            int e = sc.nextInt();
            sb.append(go(s-1, e-1));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
