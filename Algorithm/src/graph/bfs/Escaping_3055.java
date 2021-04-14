package graph.bfs;

import java.util.*;

class Pair10{
    int x, y;
    Pair10(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Escaping_3055 {
    final static int[] dx = {0,0,1,-1};
    final static int[] dy = {1,-1,0,0};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        String[] map = new String[r];
        int[][] water = new int[r][c]; //1이 물이
        int[][] hedgehog = new int[r][c];
        Queue<Pair10> q = new LinkedList<>();
        int goal_x = 0;
        int goal_y = 0;
        int start_x = 0;
        int start_y = 0;


        for(int i=0; i<r; i++){
            String str = sc.next();
            map[i] = str;
            for(int j=0; j<c; j++){
                if(str.charAt(j) == 'D') {
                    goal_x = i;
                    goal_y = j;
                }else if(str.charAt(j) == 'S'){
                    start_x = i;
                    start_y = j;
                    hedgehog[i][j] = 1;
                }else if(str.charAt(j) == '*'){
                    q.add(new Pair10(i, j));
                    water[i][j] = 1;
                }else if(str.charAt(j) == 'X'){
                    water[i][j] = -1;
                    hedgehog[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()){
            Pair10 p = q.remove();
            int x = p.x;
            int y = p.y;

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0 <= nx && nx < r && 0 <= ny && ny < c){
                    if(water[nx][ny] != 0) continue;
                    if(map[nx].charAt(ny) == 'D') continue;
                    water[nx][ny] = water[x][y]+1;
                    q.add(new Pair10(nx, ny));
                }
            }
        }

        q.add(new Pair10(start_x, start_y));

        while (!q.isEmpty()){
            Pair10 p = q.remove();
            int x = p.x;
            int y = p.y;

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0 <= nx && nx < r && 0 <= ny && ny < c){
                    if(hedgehog[nx][ny] != 0) continue;
                    if(water[nx][ny] != 0 && hedgehog[x][y]+1 >= water[nx][ny]) continue;
                    hedgehog[nx][ny] = hedgehog[x][y]+1;
                    q.add(new Pair10(nx, ny));
                }
            }
        }

        if(hedgehog[goal_x][goal_y] == 0){
            System.out.println("KAKTUS");
        }else{
            System.out.println(hedgehog[goal_x][goal_y]-1);
        }

    }
}
