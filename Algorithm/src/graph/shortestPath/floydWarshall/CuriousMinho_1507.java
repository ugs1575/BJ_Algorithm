/*
* 우리는 이렇게 생각해볼 수 있다.
문제에서는 사전에 플로이드 와샬 알고리즘을 통해 최단 경로를 구했다? 이렇게 가정하자.
그렇다면, 우리는 플로이드 와샬 알고리즘을 역으로 생각하여 문제를 해결할 수 있다.

1. 모든 도시를 간선으로 연결시킨다.
2. 거쳐가는 도시가 있을 경우 출발 도시와 도착 도시간의 간선은 없애버린다.

플로이드 와샬 알고리즘의 특성상 거쳐가는 모든 정점을 확인한다는 것을 알고 있다.
그렇다는 건, 출발 도시(i) -> 거쳐가는 도시(k) -> 도착 도시(j) 경로의 값이 존재한다면, 그것은 최단 경로이다.
그렇기에 i -> j의 간선은 없애버려도 된다.
* */

package graph.shortestPath.floydWarshall;

import java.util.Scanner;

public class CuriousMinho_1507 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n][n];
        boolean[][] unused = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                d[i][j] = sc.nextInt();
            }
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                if(k == i) continue;
                for(int j=0; j<n; j++){
                    if(i == j) continue;
                    if(k == j) continue;
                    if(d[i][j] > d[i][k]+d[k][j]){
                        System.out.println(-1);
                        System.exit(0);
                    }

                    if(d[i][j] == d[i][k]+d[k][j]){
                        unused[i][j] = true;
                    }
                }
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!unused[i][j]) ans += d[i][j];
            }
        }

        ans /= 2;
        System.out.println(ans);


    }
}
