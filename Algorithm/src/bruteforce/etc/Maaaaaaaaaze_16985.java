package bruteforce.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair8{
    int f, x, y;
    Pair8(int f, int x, int y){
        this.f = f;
        this.x = x;
        this.y = y;
    }
}

public class Maaaaaaaaaze_16985 {
    static int n = 5;
    static int[][][] cube = new int[n][n][n];
    static int[] dx = {-1,0,0,1,0,0};
    static int[] dy = {0,1,-1,0,0,0};
    static int[] df = {0,0,0,0,1,-1};
    static int bfs(int[][][] cube2){
        int res = -1;
        Queue<Pair8> q = new LinkedList<>();
        int[][][] check = new int[n][n][n];
        q.add(new Pair8(0,0,0));
        check[0][0][0] = 1;
        while (!q.isEmpty()){
            Pair8 p = q.remove();
            for(int i=0; i<6; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                int nf = p.f+df[i];
                if(nf < 0 || nf >= n || nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(cube2[nf][nx][ny] == 0) continue;
                if(check[nf][nx][ny] > 0) continue;
                check[nf][nx][ny] = check[p.f][p.x][p.y] + 1;
                q.add(new Pair8(nf, nx, ny));
            }
        }

        if(check[4][4][4] > 0){
            res = check[4][4][4];
        }


        return res;

    }
    static void rotate(int[][][] cube2, int c2_floor, int c1_floor, int d){
            if(d == 0){
                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        cube2[c2_floor][i][j] = cube[c1_floor][i][j];
                    }
                }
            }else if(d == 1){
                for(int i=0; i<n; i++) {
                    for(int j=n-1; j>=0; j--) {
                        cube2[c2_floor][i][n-1-j] = cube[c1_floor][j][i];
                    }
                }
            }else if(d == 2) {
                for(int i=n-1; i>=0; i--) {
                    for(int j=n-1; j>=0; j--){
                        cube2[c2_floor][n-1-i][n-1-j] = cube[c1_floor][i][j];
                    }
                }
            }else{
                for(int i=n-1; i>=0; i--) {
                    for(int j=0; j<n; j++){
                        cube2[c2_floor][n-1-i][j] = cube[c1_floor][j][i];
                    }
                }
            }

    }
    static int getMoveCnt(int[][][] cube2, int index, int[] order){
        int min = -1;
        if(index == n){
            int res = -1;
            if(cube2[0][0][0] == 1 && cube2[4][4][4] == 1){
                int move = bfs(cube2);
                res = move;
            }

            return res;

        }
        for(int i=0; i<4; i++){
            rotate(cube2, index, order[index], i);
            int res = getMoveCnt(cube2, index+1, order);
            if(res > 0){
                if(min == -1 || res < min){
                    min = res;
                }
            }
        }

        return min;
    }
    static int setOrder(int index, int[] order, boolean[] check){
        int min = -1;
        if(index == n){
            int[][][] cube2 = new int[n][n][n];
            int res = getMoveCnt(cube2,0, order);
            return res;
        }
        for(int i=0; i<n; i++){
            if(check[i]) continue;
            order[index] = i;
            check[i] = true;
            int res = setOrder(index+1, order, check);
            if(res > 0){
                if(min == -1 || res < min){
                    min = res;
                }
            }
            check[i] = false;
        }

        return min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                String[] s = br.readLine().split(" ");
                for(int k=0; k<n; k++){
                    cube[i][j][k] = Integer.parseInt(s[k]);
                }
            }
        }

        int[] order = new int[n];
        boolean[] check = new boolean[n];
        int ans = setOrder(0, order, check);
        if(ans > 0) ans -= 1;
        System.out.println(ans);
    }
}
