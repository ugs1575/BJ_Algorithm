package graph;

import java.util.*;

class Pair14{
    int x, y;
    Pair14(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class ColorWeakness_10026 {
    final static int[] dx ={0,0,1,-1};
    final static int[] dy ={1,-1,0,0};
    static int n;
    public static boolean go(boolean blind, char from, char to){
        if(from == to) return true;
        if(blind) {
            if (from == 'R' && to == 'G') return true;
            if (from == 'G' && to == 'R') return true;
        }
        return false;
    }
    public static int bfs(boolean blind, char[][] map){
        boolean[][] check = new boolean[n][n];
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!check[i][j]){
                    ans ++;
                    Queue<Pair14> q = new LinkedList<>();
                    q.add(new Pair14(i, j));
                    check[i][j] = true;
                    while (!q.isEmpty()){
                        Pair14 p = q.remove();
                        int x = p.x;
                        int y = p.y;
                        for(int k=0; k<4; k++){
                            int nx = x+dx[k];
                            int ny = y+dy[k];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if(check[nx][ny]) continue;
                            if(go(blind, map[x][y], map[nx][ny])){
                                q.add(new Pair14(nx, ny));
                                check[nx][ny] = true;
                            }
                        }
                    }
                }

            }
        }

        return ans;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        char[][] map = new char[n][n];
        for(int i=0; i<n; i++){
            String str = sc.next();
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j);
            }
        }



        System.out.println(bfs(false, map) +" "+ bfs(true, map));

    }
}
