/*
DFS/BFS의 목적 : 한 정점에서 시작해 연결된 모든 정점을 방문 (최소의 개념을 사용하는게 아니다)
시간복잡도 : O(NM) 모두 nm개의 칸을 방문할 수 있으니
벽을 3개 세우는 경우의 수 : (NM)^3
총 시간복잡도 O((NM)^4)이기 때문에 시간 안에 해결할 수 있다.

n개 중 k를 고르는 문제 2^n 재귀함수로 구현하는 경우가 많은데
k가 고정적인 경우 for문을 이용해 구현하는 것이 머리가 덜 아프다..

*/

package graph;

import java.util.*;

class Pair4{
    int x;
    int y;
    Pair4(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Lab_14502 {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] map;
    static int[][] map2;
    static int n,m;

    static int bfs(){
        Queue<Pair4> q = new LinkedList<Pair4>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map2[i][j] = map[i][j];
                if (map2[i][j] == 2) {
                    q.add(new Pair4(i, j));
                }
            }
        }

        while (!q.isEmpty()){
            Pair4 p = q.remove();
            int x = p.x;
            int y = p.y;

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < m){
                    if(map2[nx][ny] == 0){
                        map2[nx][ny] = 2;
                        q.add(new Pair4(nx, ny));
                    }
                }

            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map2[i][j] == 0){
                    cnt += 1;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for(int x1=0; x1<n; x1++){
            for(int y1=0; y1<m; y1++){
                if(map[x1][y1] != 0) continue;
                for(int x2=0; x2<n; x2++){
                    for(int y2=0; y2<m; y2++){
                        if(map[x2][y2] != 0) continue;
                        for(int x3=0; x3<n; x3++){
                            for(int y3=0; y3<m; y3++){
                                if(map[x3][y3] != 0) continue;
                                if(x1 == x2 && y1 == y2) continue;
                                if(x1 == x3 && y1 == y3) continue;
                                if(x2 == x3 && y2 == y3) continue;
                                map[x1][y1] = 1;
                                map[x2][y2] = 1;
                                map[x3][y3] = 1;
                                int cur = bfs();
                                if(ans < cur) ans = cur;
                                map[x1][y1] = 0;
                                map[x2][y2] = 0;
                                map[x3][y3] = 0;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

}
