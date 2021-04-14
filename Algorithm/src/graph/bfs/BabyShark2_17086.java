package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BabyShark2_17086 {
    static int n, m;
    static int[][] map;
    static int[] dx = {-1,0,1,0,-1,-1,1,1};
    static int[] dy = {0,1,0,-1,-1,1,-1,1};
    static int bfs(int x, int y){
        int[][] check = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                check[i][j] = -1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        check[x][y] = 0;
        q.add(x);
        q.add(y);
        while (!q.isEmpty()){
            int cx = q.remove();
            int cy = q.remove();
            if(map[cx][cy] == 1) return check[cx][cy];
            for(int i=0; i<8; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(check[nx][ny] != -1) continue;
                check[nx][ny] = check[cx][cy]+1;
                q.add(nx);
                q.add(ny);
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){
                    int ans = bfs(i, j);
                    if(ans > 0){
                        if(max < ans) max = ans;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
