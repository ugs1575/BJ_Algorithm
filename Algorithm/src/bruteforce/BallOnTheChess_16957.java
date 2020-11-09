package bruteforce;

import java.util.Scanner;

class Pair10{
    int x, y;
    Pair10(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BallOnTheChess_16957 {
    static int[] dx = {-1,1,0,0,-1,-1,1,1};
    static int[] dy = {0,0,1,-1,-1,1,-1,1};
    static int r, c;
    static int[][] chess;
    static int dfs(int x, int y, int[][] dp){
        if(dp[x][y] != -1) return dp[x][y];
        boolean go = false;
        int min = Integer.MAX_VALUE;
        int minx = 0;
        int miny = 0;
        for(int i=0; i<8; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
            if(chess[nx][ny] < chess[x][y]){
                go = true;
                if(chess[nx][ny] < min){
                    min = chess[nx][ny];
                    minx = nx;
                    miny = ny;
                }
            }
        }

        if(!go) {
            dp[x][y] = x*c+y;
        }else{
            int res = dfs(minx, miny, dp);
            dp[x][y] = res;
        }

        return dp[x][y];

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        chess = new int[r][c];
        Pair10[] a = new Pair10[r*c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                chess[i][j] = sc.nextInt();
                a[i*c+j] = new Pair10(i, j);
            }
        }

        int[][] dp = new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                dp[i][j] = -1;
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(dp[i][j] == -1){
                    dfs(i, j, dp);
                }
            }
        }

        int[][] ans = new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int d = dp[i][j];
                ans[a[d].x][a[d].y] += 1;
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
