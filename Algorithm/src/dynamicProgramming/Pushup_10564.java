/*
* D[i][j] = 총 팔굽혀펴기를 i번 했고, 이 때, 점수 j가 가능한가?
* 어떤 경기에서 가능한 득점의 종류 k
* D[i][j] -> d[i+j+k][j+k]
*
* 득점        7 + 3 + 2
* 팔굽혀펴기    7 + (7+3) + (7+3+2)
*
* */


package dynamicProgramming;

import java.util.*;

public class Pushup_10564 {
    static int n, m;
    static int[] a = new int[10];
    static boolean[][] d = new boolean[5001][5001];
    static void go(int i, int j){
        if(i > n) {
            return;
        }
        if(d[i][j]) return;
        d[i][j] = true;
        for(int k=0; k<m; k++){
            go(i+j+a[k], j+a[k]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            n = sc.nextInt();
            m = sc.nextInt();
            for(int i=0; i<m; i++){
                a[i] = sc.nextInt();
            }
            for(int i=0; i<5001; i++){
                Arrays.fill(d[i], false);
            }
            go(0,0);
            int ans = -1;
            for(int i=1; i<=n; i++){
                if(d[n][i]){
                    ans = i;
                }
            }
            System.out.println(ans);
        }
    }
}
