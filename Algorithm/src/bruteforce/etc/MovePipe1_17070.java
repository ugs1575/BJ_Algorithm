package bruteforce.etc;

import java.util.*;
import java.io.*;

class Pair5{
    int lx, ly, rx, ry, type;
    Pair5(int lx, int ly, int rx, int ry, int type){
        this.lx = lx;
        this.ly = ly;
        this.rx = rx;
        this.ry = ry;
        this.type = type; //0:가로, 1:세로, 2:대각선
    }
}
public class MovePipe1_17070 {
    static int n;
    static int[][] a;
    static int[] dx = {0,1,1};
    static int[] dy = {1,0,1}; //우, 하, 대각선
    static boolean checkRange(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= n) return false;
        if(a[x][y] != 0) return false;
        return true;
    }
    static int go(Pair5 p){
        //System.out.println(p.lx+","+p.ly+"/"+p.rx+","+p.ry+"/"+p.type);
        int ans = 0;
        if(p.rx == n-1 && p.ry == n-1){
            return 1;
        }

        for(int i=0; i<3; i++){
            int nx = p.rx+dx[i];
            int ny = p.ry+dy[i];
            if(!checkRange(nx, ny)) continue;
            if(i == 2){
                if(!checkRange(p.rx+dx[0], p.ry+dy[0])) continue;
                if(!checkRange(p.rx+dx[1], p.ry+dy[1])) continue;
            }
            if(p.type == 2){
                ans += go(new Pair5(p.rx, p.ry, nx, ny, i));
            }else{
                if(i == p.type || i == 2) {
                    ans += go(new Pair5(p.rx, p.ry, nx, ny, i));
                }
            }

        }

        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        for(int i=0; i<n; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                a[i][j] = Integer.parseInt(s[j]);
            }
        }

        System.out.println(go(new Pair5(0,0,0,1, 0)));

    }
}
