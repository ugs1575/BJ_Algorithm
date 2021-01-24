/*
* D[i][j][k] = SVC의 체력이 i,j,k 일 때, 모두 파괴하기 위해 공격해야하는 횟수의 최솟
*
* 공격할 수 있는 순서는 총 6가지가 있다.
* 1,2,3 = D[i-9][j-3][k-1]
* 1,3,2 = D[i-9][j-1][k-3]
* 2,1,3 = D[i-3][j-9][k-1]
* 2,3,1 = D[i-1][j-9][k-3]
* 3,1,2 = D[i-3][j-1][k-9]
* 3,2,1 = D[i-1][j-3][k-9]
*
* */


package dynamicProgramming;

import java.util.*;

public class Mutarisk_12869 {
    public static int[][][] d = new int[61][61][61];
    public static int go(int i, int j, int k){
        //음수로 떨어질 경우 0으로 바꿔서 리턴
        if(i < 0) return go(0, j, k);
        if(j < 0) return go(i, 0, k);
        if(k < 0) return go(i, j, 0);
        if(i == 0 && j == 0 && k == 0) return 0;
        if(d[i][j][k] != -1) return d[i][j][k];
        int ans = 10000000;
        if(ans > go(i-1, j-3, k-9)){
            ans = go(i-1, j-3, k-9);
        }
        if(ans > go(i-1, j-9, k-3)){
            ans = go(i-1, j-9, k-3);
        }
        if(ans > go(i-3, j-1, k-9)){
            ans = go(i-3, j-1, k-9);
        }
        if(ans > go(i-3, j-9, k-1)){
            ans = go(i-3, j-9, k-1);
        }
        if(ans > go(i-9, j-1, k-3)){
            ans = go(i-9, j-1, k-3);
        }
        if(ans > go(i-9, j-3, k-1)){
            ans = go(i-9, j-3, k-1);
        }
        ans += 1; //이번 공격
        d[i][j][k] = ans;
        return d[i][j][k];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scv = new int[3];
        for(int i=0; i<n; i++){
            scv[i] = sc.nextInt();
        }
        for(int i=0; i<=60; i++){
            for(int j=0; j<=60; j++){
                for(int k=0; k<=60; k++){
                    d[i][j][k] = -1;
                }
            }
        }

        System.out.println(go(scv[0], scv[1], scv[2]));
    }
}
