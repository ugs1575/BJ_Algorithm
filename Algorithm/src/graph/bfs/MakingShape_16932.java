package graph.bfs;

import java.util.*;
import java.io.*;

class Pair9{
    int x, y;
    Pair9(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class MakingShape_16932 {
    static int n, m;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean outRange(int x, int y){
        return x < 0 || x >= n || y < 0 || y >= m;
    }
    static void bfs(int x, int j, int[][] check, int group, ArrayList<Integer> group_size){
        Queue<Pair9> q = new LinkedList<>();
        q.add(new Pair9(x, j));
        check[x][j] = group;
        int cnt = 1;
        while (!q.isEmpty()){
            Pair9 p = q.remove();
            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(outRange(nx, ny)) continue;
                if(map[nx][ny] == 0) continue;
                if(check[nx][ny] > 0) continue;
                cnt += 1;
                check[nx][ny] = group;
                q.add(new Pair9(nx, ny));
            }

        }

        group_size.add(cnt);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new int[n][m];
        for(int i=0; i<n; i++){
            s = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        int group = 1;
        int[][] check = new int[n][m];
        ArrayList<Integer> group_size = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 1 && check[i][j] == 0){
                    bfs(i, j, check, group, group_size);
                    group += 1;
                }
            }
        }


        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){
                    int size = 0;
                    HashSet<Integer> hs = new HashSet<>();
                    for(int k=0; k<4; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(outRange(nx, ny)) continue;
                        if(map[nx][ny] == 0) continue;
                        hs.add(check[nx][ny]-1);
                    }

                    for(int k:hs){
                        size += group_size.get(k);
                    }
                    size += 1;
                    System.out.println(i+"/"+j+"/"+size);
                    if(max < size) max = size;
                }
            }
        }

        System.out.println(max);
    }
}
