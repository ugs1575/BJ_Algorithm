/*
* D[i][j] = i번 사람까지 있을 때, j개의 소형 기관차로 운송할 수 있는 최대 손님의 수
* 1. j번째 소형기관차가 i번 객차까지를 끌었다
*    = D[i-k][j-1] + A[i]까지의 k개수의 합
*
* 2.                           끌지 않았다.
*    = D[i-1][j]
*
* D[i][j] = max(D[i-1][j], D[i-m][j-1] + A[i-m+1]~A[i]까지 합)
*
*
*
*
* */



package dynamicProgramming;

import java.util.*;

public class SmallTrain_2616 {
    static int[] s = new int[50001];
    static int[] a = new int[50001];
    static int[][] d = new int[50001][4];
    static int sum(int x, int y){
        return s[y] - s[x-1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++){
            a[i] = sc.nextInt();
            s[i] = s[i-1] + a[i];
        }
        int m = sc.nextInt();
        for(int j=1; j<=3; j++){
            for(int i=m*j; i<=n; i++){
                d[i][j] = d[i-1][j];
                d[i][j] = Math.max(d[i][j], d[i-m][j-1] + sum(i-m+1, i));
            }
        }

        System.out.println(d[n][3]);

    }

}
