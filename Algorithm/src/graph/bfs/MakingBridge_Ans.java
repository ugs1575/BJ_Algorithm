package graph.bfs;/*다리 만들기 문제 더 효율적인 방법
-땅을 확장하는 방식으로 생각한다
-check배열(g배열)에는 그룹번호를 넣어주고, d배열에는 거리를 넣어준다
-마지막으로 다른그룹에 속한 거리와 본인의 거리를 더해 가장 짧은 것을 구해주면 된다.*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MakingBridge_Ans {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int[][] d = new int[n][n];
        int[][] g = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (a[i][j] == 1 && g[i][j] == 0) {
                    Queue<Pair> q = new LinkedList<Pair>();
                    g[i][j] = ++cnt;
                    q.add(new Pair(i, j));
                    while (!q.isEmpty()) {
                        Pair p = q.remove();
                        int x = p.x;
                        int y = p.y;
                        for (int k=0; k<4; k++) {
                            int nx = x+dx[k];
                            int ny = y+dy[k];
                            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                                if (a[nx][ny] == 1 && g[nx][ny] == 0) {
                                    q.add(new Pair(nx, ny));
                                    g[nx][ny] = cnt;
                                }
                            }
                        }
                    }
                }
            }
        }
        Queue<Pair> q = new LinkedList<Pair>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                d[i][j] = -1;
                if (a[i][j] == 1) {
                    q.add(new Pair(i,j));
                    d[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (d[nx][ny] == -1) {
                        d[nx][ny] = d[x][y] + 1;
                        g[nx][ny] = g[x][y];
                        q.add(new Pair(nx,ny));
                    }
                }
            }
        }
        int ans = -1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<4; k++) {
                    int x = i+dx[k];
                    int y = j+dy[k];
                    if (0 <= x && x < n && 0 <= y && y < n) {
                        if (g[i][j] != g[x][y]) {
                            if (ans == -1 || ans > d[i][j] + d[x][y]) {
                                ans = d[i][j] + d[x][y];
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}