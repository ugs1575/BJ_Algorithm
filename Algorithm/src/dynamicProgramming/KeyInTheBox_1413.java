/*
* 넘.. 어렵다.... 참고 : https://justicehui.github.io/ps/2019/07/11/BOJ1413/
* 사이클의 개수가 M개를 넘지 않는 길이가 N인 순열의 개수를 구하는 문제
* 이 수는 제 1종 스털링 수(Stirling numbers of the first kind)와 같다
*
* D[i][j] = 길이가 i인 순열(1~i), 사이클의 수 j
* 두가지로 나눌 수 있다.
* 1. i번째 수가 혼자 사이클을 이루는 경우
*       1 2 .... i-1 i
*       |__________| (혼자 사이클 만듬)
*       D[i-1][j-1]
*
* 2. i번째 수가 기존에 있던 사이클에 들어가는 경우
*       1 2 3 4 5 6 i
*       |_________|
*       D[i-1][j]*(i-1)
*  i를 제외한 나머지는 사이클을 각각 이루고 있을 것이다..
*  예를 들면
*  1->2->3->1 4->6->4 5->5
*  간선의 개수는 i-1이다.
*  이중에 하나에 껴야 해서 (i-1)를 곱해주면 경우의 수를 구할 수 있다.
*
*
* */
package dynamicProgramming;

import java.util.Scanner;

public class KeyInTheBox_1413 {
    static long[][] d = new long[21][21];
    static long gcd(long x, long y){
        if(y == 0) return x;
        else  return gcd(y, x%y);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        d[1][1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                //자기 혼자 사이클 만듬 + 기존 사이클에 포함
                d[i][j] = d[i-1][j-1] + d[i-1][j] * (i-1);
            }
        }
        long bunja = 0;
        for(int i=1; i<=m; i++){
            bunja += d[n][i];
        }

        long bunmo = 1;
        for(int i=1; i<=n; i++){
            bunmo *= i;
        }

        long g = gcd(bunja, bunmo);
        bunja /= g;
        bunmo /= g;
        System.out.printf("%d/%d\n", bunja, bunmo);
    }
}
