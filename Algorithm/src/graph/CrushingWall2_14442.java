package graph;

import java.util.*;

class Pair7{
    int x, y, z;
    Pair7(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class CrushingWall2_14442 {
    final static int[] dx = {0,0,1,-1};
    final static int[] dy = {1,-1,0,0};
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] map = new int[n][m];
        int[][][] check = new int[n][m][k+1];


        for(int i=0; i<n; i++){
            String str = sc.next();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<Pair7> q = new LinkedList<>();
        q.add(new Pair7(0,0,0));
        check[0][0][0] = 1;
        while (!q.isEmpty()){
            Pair7 p = q.remove();
            int x = p.x;
            int y = p.y;
            int z = p.z;
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < m){
                    if(map[nx][ny] == 0 && check[nx][ny][z] == 0){
                        q.add(new Pair7(nx, ny, z));
                        check[nx][ny][z] = check[x][y][z]+1;
                    }else if(map[nx][ny] == 1 && z < k && check[nx][ny][z+1] == 0){
                        q.add(new Pair7(nx, ny, z+1));
                        check[nx][ny][z+1] = check[x][y][z]+1;
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        boolean visit = false;
        for(int i=0; i<=k; i++){
            if(check[n-1][m-1][i] != 0) {
                min = Math.min(check[n-1][m-1][i], min);
                visit = true;
            }
        }

        if(!visit){
            min = -1;
        }

        System.out.println(min);

    }
}
