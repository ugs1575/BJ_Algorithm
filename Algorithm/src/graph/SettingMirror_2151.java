package graph;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair16{
    int x, y, dir, door;
    Pair16(int x, int y, int dir, int door){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.door = door;
    }
}

public class SettingMirror_2151 {
    static int sx, sy, ex, ey, n;
    static char[][] map;
    static int[] dx = {-1,-1,1,1};
    static int[] dy = {-1,1,-1,1};
    static void bfs(boolean[][][] check){
        Queue<Pair16> q = new LinkedList<>();
        for(int i=0; i<4; i++){
            int nx = sx+dx[i];
            int ny = sy+dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(map[nx][ny] == '*') continue;
            q.add(new Pair16(nx, ny, i,0));
            check[nx][ny][0] = true;
        }

        while (!q.isEmpty()){
            Pair16 p = q.remove();
            System.out.println("cur"+p.x+"/"+p.y+"/"+p.dir+"/"+p.door);
            if(map[p.x][p.y] == '#' && p.door > 0){
                System.out.println(p.door);
                return;
            }
            if(map[p.x][p.y] == '!'){ //방향을 바꿀 수 있다
                for(int i=0; i<4; i++){
                    if(p.dir != i && (p.dir+i) == 4) continue;
                    int nx = p.x+dx[i];
                    int ny = p.y+dy[i];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if(map[nx][ny] == '*') continue;
                    if(i == p.dir){//설치안함
                        if(check[nx][ny][p.door]) continue;
                        q.add(new Pair16(nx, ny, i, p.door));
                        System.out.println("same"+nx+"/"+ny+"/"+i+"/"+p.door);
                        check[nx][ny][p.door] = true;
                    }else{//설치함
                        if(check[nx][ny][p.door+1]) continue;
                        System.out.println(nx+"/"+ny+"/"+i+"/"+(p.door+1));
                        q.add(new Pair16(nx, ny, i, p.door+1));
                        check[nx][ny][p.door+1] = true;
                    }
                }
            }else{
                int nx = p.x+dx[p.dir];
                int ny = p.y+dy[p.dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(map[nx][ny] == '*') continue;
                if(check[nx][ny][p.door]) continue;
                System.out.println("same"+nx+"/"+ny+"/"+p.dir+"/"+p.door);
                q.add(new Pair16(nx, ny, p.dir, p.door));
                check[nx][ny][p.door] = true;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        sx = 0;
        sy = 0;
        ex = 0;
        ey = 0;
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == '#'){
                    if(sx == 0 && sy == 0){
                        sx = i;
                        sy = j;
                    }else{
                        ex = i;
                        ey = j;
                    }
                }
            }
        }

        boolean[][][] check = new boolean[n][n][n*n];
        bfs(check);

    }
}
