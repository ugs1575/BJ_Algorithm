package bruteforce;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair3{
    int x, y;
    Pair3(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Baduk2_16988 {
    static int n, m;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static int bfs(int[][] a, boolean[][] check, int x, int y){
        Queue<Pair3> q = new LinkedList<>();
        q.add(new Pair3(x, y));
        check[x][y] = true;
        boolean ok = true;
        int cnt = 0;
        while (!q.isEmpty()){
            Pair3 p = q.remove();
            cnt += 1;
            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(a[nx][ny] == 0){
                    ok = false;
                }
                if(a[nx][ny] == 2 && !check[nx][ny]){
                    q.add(new Pair3(nx, ny));
                    check[nx][ny] = true;
                }
            }
        }

        if(!ok) cnt = 0;

        return cnt;
    }
    static int getCnt(int[][] a){
        boolean[][] check = new boolean[n][m];
        int sum = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i][j] == 2 && !check[i][j]){
                   sum += bfs(a, check, i, j);
                }
            }
        }
        return sum;
    }
    static int setRock(int start, int end, int[] ans, int index, ArrayList<Pair3> list){
        int max = 0;
        if(index == 2){
            int[][] a = new int[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    a[i][j] = map[i][j];
                }
            }
            Pair3 rock1 = list.get(ans[0]);
            Pair3 rock2 = list.get(ans[1]);
            a[rock1.x][rock1.y] = 1;
            a[rock2.x][rock2.y] = 1;
            return getCnt(a);
        }
        for(int i=start; i<=end; i++){
            ans[index] = i;
            int res = setRock(i+1, end, ans, index+1,list);
            if(max < res) max = res;
        }

        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        ArrayList<Pair3> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 0) list.add(new Pair3(i, j));
            }
        }

        int[] ans = new int[2];
        System.out.println(setRock(0,list.size()-1, ans, 0, list));

    }
}
