/*
* D[N][a][b][c] = 곡의 수 N개, 세 사람이 부른 곡의 수가 a,b,c,개 일 때, 경우의 수
*
* 마지막 N번째 곡을 부르는 경우의 수를 생각해보면
* 각각 부르거나 안부르거나 2가지가 있고
* 2*2*2 = 8가지 경우의 수가 나오지만
*
* 적어도 한개의 곡은 한사람이 꼭 불러야 하므로 모두 다 안부르는 경우의 수 -1을 빼준다
*
* 7가지 경우의 수
* A
* B
* C
* A,B
* B,C
* A,C
* A,B,C
*
* 중 A,C 가 N번째 곡을 부른다고 해보자
* 그러면 N-1, a-1, b, c-1가 된다.
*
* 이런식으로 모두 다 해보면 된다.
*
* */

package dynamicProgramming;

import java.util.Scanner;

public class Acka_12996 {
    static final long mod = 1000000007;
    static long[][][][] d = new long[51][51][51][51];
    static long go(int n, int a, int b, int c){
        if(n == 0){
            if(a == 0 && b == 0 && c==0) return 1;
            else return 0;
        }

        if(a < 0 || b < 0 || c < 0) return 0;
        long ans = d[n][a][b][c];
        if(ans != -1) return ans;
        ans = 0;
        for(int i=0; i<2; i++){ //a,b,c가 부를지 말지 정해주기
            for(int j=0; j<2; j++){
                for(int k=0; k<2; k++){
                    if(i+j+k == 0) continue; //아무도 안부르는 경우의 수 제외
                    ans += go(n-1, a-i, b-j, c-k);
                }
            }
        }
        ans %= mod;
        d[n][a][b][c] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        for(int i=0; i<=n; i++){
            for(int j=0; j<=a; j++){
                for(int k=0; k<=b; k++){
                    for(int l=0; l<=c; l++){
                        d[i][j][k][l] = -1;
                    }
                }
            }
        }
        System.out.println(go(n,a,b,c));
    }
}
