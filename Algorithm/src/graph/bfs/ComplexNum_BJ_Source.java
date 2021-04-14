package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}*/


public class ComplexNum_BJ_Source {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};
    public static void bfs(int [][] a, int[][] group, int x, int y, int cnt, int n){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y));
        group[x][y] = cnt;
        while(!q.isEmpty()){
            Pair p = q.remove();
            x = p.x;
            y = p.y;
            for(int k=0; k<4; k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(0 <= nx && nx <n && 0 <= ny && ny < n){
                    if(a[nx][ny] == 1 && group[nx][ny] == 0){
                        q.add(new Pair(nx, ny));
                        group[nx][ny] = cnt;
                    }
                }
            }
        }
    }
}
