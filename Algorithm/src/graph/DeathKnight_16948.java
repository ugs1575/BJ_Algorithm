package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DeathKnight_16948 {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        int[] dr = {-2,-2,0,0,2,2};
        int[] dc = {-1,1,-2,2,-1,1};

        int[][] map = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = -1;
            }
        }

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(r1);
        qy.add(c1);
        map[r1][c1] = 0;
        while (!qx.isEmpty() && !qy.isEmpty()){
            int current_r = qx.remove();
            int current_c = qy.remove();
            for(int i=0; i<6; i++){
                int next_r = current_r+dr[i];
                int next_c = current_c+dc[i];
                if(next_r < 0 || next_r >= n || next_c < 0 || next_c >= n){
                    continue;
                }
                if(map[next_r][next_c] == -1){
                    map[next_r][next_c] = map[current_r][current_c]+1;
                    qx.add(next_r);
                    qy.add(next_c);
                }
            }
        }

        System.out.println(map[r2][c2]);
    }
}
