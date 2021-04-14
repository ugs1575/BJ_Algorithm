package bruteforce.etc;

import java.util.HashSet;
import java.util.Scanner;

public class NumberMapJump_2210 {
    final static int n = 5;
    final static int[] dx = {-1,1,0,0};
    final static int[] dy = {0,0,-1,1};
    static int[][] map = new int[n][n];
    static void go(int x, int y, int index, int[] a, HashSet<String> set){
        if(index == n+1){
            StringBuilder sb = new StringBuilder();
            for(int i:a){
                sb.append(i);
            }
            set.add(sb.toString());
            return;
        }
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            a[index] = map[nx][ny];
            go(nx, ny, index+1, a, set);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int[] a = new int[n+1];
                a[0] = map[i][j];
                go(i, j, 1, a, set);
            }
        }

        System.out.println(set.size());
    }
}
