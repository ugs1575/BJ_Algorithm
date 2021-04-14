/*
* D[i][j] = i번째 물건까지 고려했고, 배냥에 넣은 물건 무게의 합이 j일 때, 가치의 최댓값
* i번째 물건을 가방에 넣지 않은 경우 : D[i-1][j]
*
* i번째 물건까지 넣었을 때 무게 j가 된것이다.
* i번째 물건이 없었다면 D[i-1][j-w[i]] 이었을 것이고 가치는 V[i]만큼 더해질 것이다.
* i번째 물건을 가방에 넣은 경우 : D[i-1][j-w[i]] + V[i]
*
*
* ## 0/1 Knapsack Problem
* n = 4
* k = 7
*
*                   weight
*               0  1  2  3  4  5  6  7
* v[i] w[i] 0   0  0  0  0  0  0  0  0
*  13  6    1   0  0  0  0  0  0  13 13  -> 1은 weight 6부터 채울 수 있다, 그 이전 것은 이전 row값을 넣어준다
*  8   4    2   0  0  0  0  8  0  13 13  -> 2는 weight 4부터 넣을 수 있고, 그 이전 물건 1도 같이 고려했을 때 무게가 10이되서 넘으니까 못넣음
*  6   3    3   0  0  0  6  8  0  13 14  -> 3은 weight 3부터 넣을 수 있고, 그전 것 같이 모든 조합을 고려했을 때 들어가는 것은 2,3 조합이다
*  12  5    4   0  0  0  6  8  12 13 14  -> 마찬가지.. 답은 D[4,7]이 된다
*
* 해당 작업을 수식으로 나타내면
* D[i,w] = max{D[i-1, w], D[i-1, w-w[i]]+p[i]}
* 가 된다.
*
* */

package dynamicProgramming;

import java.util.Scanner;

public class KnapSack_12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] w = new int[n+1];
        int[] v = new int[n+1];
        for(int i=1; i<=n; i++){
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        int[][] d = new int[n+1][k+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=k; j++){
                d[i][j] = d[i-1][j];
                if(j-w[i] >= 0){
                    d[i][j] = Math.max(d[i][j], d[i-1][j-w[i]]+v[i]);
                }
            }
        }
        System.out.println(d[n][k]);

    }
}
