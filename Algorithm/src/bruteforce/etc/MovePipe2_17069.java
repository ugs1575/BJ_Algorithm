package bruteforce.etc;

import java.util.*;
import java.io.*;

class Pair6{
    int lx, ly, rx, ry, type;
    Pair6(int lx, int ly, int rx, int ry, int type){
        this.lx = lx;
        this.ly = ly;
        this.rx = rx;
        this.ry = ry;
        this.type = type; //0:가로, 1:세로, 2:대각선
    }
}
public class MovePipe2_17069 {
    static int n;
    static int[][] a;
    static long[][][] d;
    static int[] dx = {0,1,1};
    static int[] dy = {1,0,1}; //우, 하, 대각선
    static boolean checkRange(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= n) return false;
        if(a[x][y] != 0) return false;
        return true;
    }
    static long go(Pair6 p){
        if(p.rx == n-1 && p.ry == n-1){
            return 1;
        }
        long ans = d[p.rx][p.ry][p.type];
        if(ans != -1) return ans;

        ans = 0;
        for(int i=0; i<3; i++){
            int nx = p.rx+dx[i];
            int ny = p.ry+dy[i];
            if(!checkRange(nx, ny)) continue;
            if(i == 2){
                if(!checkRange(p.rx+dx[0], p.ry+dy[0])) continue;
                if(!checkRange(p.rx+dx[1], p.ry+dy[1])) continue;
            }
            if(p.type == 2){
                ans += go(new Pair6(p.rx, p.ry, nx, ny, i));
            }else{
                if(i == p.type || i == 2) {
                    ans += go(new Pair6(p.rx, p.ry, nx, ny, i));
                }
            }

        }

        d[p.rx][p.ry][p.type] = ans;
        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        d = new long[n][n][3];
        for(int i=0; i<n; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                a[i][j] = Integer.parseInt(s[j]);
                for(int k=0; k<3; k++){
                    d[i][j][k] = -1;
                }
            }
        }

        System.out.println(go(new Pair6(0,0,0,1, 0)));

    }
}
