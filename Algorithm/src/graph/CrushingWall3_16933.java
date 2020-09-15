package graph;

import java.util.*;

class Pair8{
    int x, y, z, d;
    Pair8(int x, int y, int z, int d){
        this.x = x; //x좌표
        this.y = y; //y좌표
        this.z = z; //벽을 부순 횟수
        this.d = d; //낮(0) or 밤(1)
    }
}
public class CrushingWall3_16933 {
    final static int[] dx = {0,0,1,-1};
    final static int[] dy = {1,-1,0,0};
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] map = new int[n][m];
        int[][][][] check = new int[n][m][k+1][2];
        for(int i=0; i<n; i++){
            String str = sc.next();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        Queue<Pair8> q = new LinkedList<Pair8>();
        q.add(new Pair8(0,0,0,0));
        check[0][0][0][0] = 1;
        while (!q.isEmpty()){
            Pair8 p = q.remove();
            int x   = p.x;
            int y   = p.y;
            int z   = p.z;
            int d   = p.d;
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < m){
                    if(map[nx][ny] == 0 && check[nx][ny][z][1-d] == 0){
                        q.add(new Pair8(nx, ny, z, 1-d));
                        check[nx][ny][z][1-d] = check[x][y][z][d]+1;
                    }else if(d == 0 && z < k && map[nx][ny] == 1 && check[nx][ny][z+1][1-d] == 0){
                        q.add(new Pair8(nx, ny, z+1, 1-d));
                        check[nx][ny][z+1][1-d] = check[x][y][z][d]+1;
                    }
                }
            }
            //머무르는 경우
            if(check[x][y][z][1-d] == 0){
                q.add(new Pair8(x, y, z, 1-d));
                check[x][y][z][1-d] = check[x][y][z][d]+1;
            }

        }

        int min = Integer.MAX_VALUE;
        boolean possible = false;
        for(int i=0; i<2; i++){
            for(int j=0; j<=k; j++){
                if(check[n-1][m-1][j][i] != 0){
                    min = Math.min(check[n-1][m-1][j][i], min);
                    possible = true;
                }
            }
        }

        if(!possible) min = -1;

        System.out.println(min);
    }
}
