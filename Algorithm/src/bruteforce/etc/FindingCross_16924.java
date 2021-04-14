package bruteforce.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Pair{
    int x, y, k;
    Pair(int x, int y, int k){
        this.x = x;
        this.y = y;
        this.k = k;
    }
}


public class FindingCross_16924 {
    static int n, m;
    static char[][] a;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static void draw(int x, int y, int k, boolean[][] visit){
        visit[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x;
            int ny = y;
            for(int j=0; j<k; j++){
                nx += dx[i];
                ny += dy[i];
                visit[nx][ny] = true;
            }
        }
    }
    static boolean check(int x, int y, int k){
        //System.out.println("*************************");
        //System.out.println(x+" "+y+" "+k);
        for(int i=0; i<4; i++){
            int nx = x;
            int ny = y;
            for(int j=0; j<k; j++){
                nx += dx[i];
                ny += dy[i];
                //System.out.println(nx+" "+ny);
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) return false;
                if(a[nx][ny] == '.'){
                    return false;
                }

            }
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        a = new char[n][m];
        boolean[][] visit = new boolean[n][m];
        ArrayList<Pair> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            String str = br.readLine();
            //System.out.println(str.length());
            for(int j=0; j<m; j++){
                a[i][j] = str.charAt(j);
            }
        }


        int max = (Math.min(n, m)-1)/2;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i][j] == '*'){
                    boolean canPut = false;
                    int max_k = 0;
                    for(int k=1; k<=max; k++){
                        boolean res = check(i, j, k);
                        if(res) {
                            canPut = true;
                            max_k = Math.max(max_k, k);
                        }
                    }
                    if(canPut) ans.add(new Pair(i, j, max_k));
                }
            }
        }

        for(Pair p : ans){
            draw(p.x, p.y, p.k, visit);
        }



        boolean res = true;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i][j] == '*' && !visit[i][j]){
                    res = false;
                }
            }
        }

        if(res){
            System.out.println(ans.size());
            for(Pair p : ans){
                System.out.println((p.x+1)+" "+(p.y+1)+" "+p.k);
            }
        }else{
            System.out.println(-1);
        }
    }
}
