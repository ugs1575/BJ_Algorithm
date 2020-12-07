package graph;

import java.io.*;
import java.util.*;

class Pair13{
    int x, y, cost;
    Pair13(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

public class MonkeyWantToBeHorse_1600 {
    static int k, w, h;
    static int[][] map;
    static int[] dx = {-1,0,1,0,-1,-2,-1,-2,1,2,1,2};
    static int[] dy = {0,1,0,-1,-2,-1,2,1,-2,-1,2,1};
    static int[] dc = {0,0,0,0,1,1,1,1,1,1,1,1};
    static void bfs(int[][][] check){
        Queue<Pair13> q = new LinkedList<>();
        check[0][0][0] = 0;
        q.add(new Pair13(0,0, 0));
        while (!q.isEmpty()){
            Pair13 p = q.remove();
            for(int i=0; i<12; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                int nc = p.cost+dc[i];
                if(nx < 0 || nx >= h || ny < 0 || ny >= w || nc > k) continue;
                if(check[nx][ny][nc] != -1) continue;
                if(map[nx][ny] == 1) continue;
                check[nx][ny][nc] = check[p.x][p.y][p.cost]+1;
                q.add(new Pair13(nx, ny, nc));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        w = Integer.parseInt(s[0]);
        h = Integer.parseInt(s[1]);
        map = new int[h][w];
        for(int i=0; i<h; i++){
            s = br.readLine().split(" ");
            for(int j=0; j<w; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        int[][][] check = new int[h][w][k+1];
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                Arrays.fill(check[i][j],-1);
            }
        }


        bfs(check);

        int min = -1;
        for(int i=0; i<=k; i++){
            if(check[h-1][w-1][i] != -1){
                if(min == -1 || check[h-1][w-1][i] < min){
                    min = check[h-1][w-1][i];
                }
            }
        }

        System.out.println(min);




    }
}
