/*
* D[N][M][K] = NxM크기의 체스판에 룩 K개를 놓는 경우의 수
*
* 1. N번 행에 룩을 놓지 않은 경우 : D[N-1][M][K]
*    N번 행에 룩을 놓지 않는다 라고 하면
*    나머지 (N-1)xM 크기의 체스판에 룩을 놓는 경우의 수와 같다
*
* 2. N번 행에 룩을 하나 놓았고, 다른 룩에게 공격받지 않는 경우 : D[N-1][M-1][K-1]xM
*       M
*     ..x..
*     ..x..
* N   ..x..
*     xxRxx
*
*    다른 룩에 공격을 받지 않으려면 x표시 된 곳에서는 룩이 있어서는 안된다.
*    (N-1)x(M-1)크기의 체스판에 룩을 놓고
*    열을 한개 추가하고, 밑에 행을 하나 추가하는 경우의 수와 같다고 생각하면 된다.
*
* 3. N번 행에 룩을 두 개 놓는 경우 : D[N-1][M-2][K-2]x Mx(M-1)/2
*       M
*     ..x.x..
*     ..x.x..
* N   ..x.x..
*     xxRxRxx
*
*    마찬가지로 (N-1)x(M-2)크기의 체스판에 룩을 놓고
*    열을 두개 추가하고, 밑에 행을 하나 추가하는 경우의 수와 같다.
*
* 4. N번 행에 룩을 하나 놓았고, 다른 룩에게 공격받는 경우 : D[N-2][M-1][K-2] X Mx(N-1)
*       M
*     ..x..
*     ..R..
* N   ..x..
*     xxRxx
*
*   (N-2)x(M-1)크기의 체스판에 룩을 놓고
*   열과 한개와 행 두개를 추가한다고 생각하면 된다.
*
*
*  */

package dynamicProgramming;

import java.util.*;

public class NRook2_1767 {
    static long[][][] d = new long[101][101][101];
    static long go(int n, int m, int k){
        if(k == 0){
            return 1;
        }
        if(n <= 0 || m <= 0 || k < 0){
            return 0;
        }
        if(d[n][m][k] != -1){
            return d[n][m][k];
        }
        d[n][m][k] = go(n-1, m, k) +
                go(n-1,m-1, k-1)*m +
                go(n-1, m-2, k-2)*m*(m-1)/2 +
                go(n-2, m-1, k-2)*m*(n-1);
        d[n][m][k] %= 1000001;
        return d[n][m][k];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                Arrays.fill(d[i][j], -1);
            }
        }
        System.out.println(go(n,m,k));
    }
}
