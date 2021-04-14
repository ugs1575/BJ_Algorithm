package graph.bfs;

import java.util.ArrayList;
import java.util.Scanner;

class Pair4{
    int x, y;
    Pair4(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class WolfAndSheep_16956 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int r,c;
    static boolean[][] check;
    static char[][] a;
    static boolean bfs(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
            if(a[nx][ny] == 'W') return false;
            if(!check[nx][ny] && a[nx][ny] == '.'){
                check[nx][ny] = true;
                a[nx][ny] = 'D';
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        a = new char[r][c];
        check = new boolean[r][c];
        ArrayList<Pair4> list = new ArrayList<>();
        for(int i=0; i<r; i++){
            String s = sc.next();
            for(int j=0; j<c; j++){
                a[i][j] = s.charAt(j);
                if(a[i][j] == 'S'){
                    list.add(new Pair4(i, j));
                }
            }
        }

        boolean ok = true;
        for(Pair4 p : list){
            boolean res = bfs(p.x, p.y);
            if(!res) ok = false;
        }

        if(ok){
            System.out.println(1);
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    System.out.print(a[i][j]);
                }
                System.out.println();
            }
        }else{
            System.out.println(0);
        }

    }
}
