package graph;
/*
* (r,c) t초후 벽인지 확인하는 법
* a[r-t,c] = 1인지 0인지 확인하면
*
* */
import java.util.*;

public class EscapingMovingMaze_16954 {
    final static int[] dx = {0,0,1,-1,-1,-1,1,1,0};
    final static int[] dy = {1,-1,0,0,-1,1,-1,1,0};
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = 8;
        String[] a = new String[n];
        for(int i=0; i<n; i++){
            a[i] = sc.next();
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[][][] check = new boolean[8][8][9];
        check[7][0][0] = true;
        q.add(7); q.add(0); q.add(0);
        boolean ans = false;
        while (!q.isEmpty()){
            int x = q.remove();
            int y = q.remove();
            int t = q.remove();
            if(x == 0 && y == 7) ans = true;
            for(int k=0; k<9; k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                int nt = Math.min(t+1, 8);//8초가 지나면 빈칸이므로 8로 고정시키
                if(0 <= nx && nx < n && 0 <= ny && ny < n){
                    if(nx-t >= 0 && a[nx-t].charAt(ny) == '#') continue; // (t초후) 이동하려는 칸이 벽이면
                    if(nx-t-1 >=0 && a[nx-t-1].charAt(ny) == '#') continue; // (t+1초후) 이동하려는 간에 이동후 벽이 내려오면
                    if(check[nx][ny][nt] == false){
                        check[nx][ny][nt] = true;
                        q.add(nx); q.add(ny); q.add(nt);
                    }
                }
            }
        }

        System.out.println(ans ? 1:0);
    }
}
