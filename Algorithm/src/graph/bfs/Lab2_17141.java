/*
*
* 5 2
* 1 1 1 1 1
* 1 1 2 1 1
* 1 1 2 1 1
* 1 1 1 1 1
* 1 1 1 1 1
* 이런 상황일때 바이러스를 가능지역 2곳 바이러스도 2개
* 면은 바이러스를 놓는 순간 모든 맵이 채워져서 확산 시간이 0이 되어야 하거든요
*
*
* */

package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair18{
    int x, y;
    Pair18(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Lab2_17141 {
    static int n, m;
    static int[][] map;
    static Pair18[] location = new Pair18[10];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int getTime(int[][] check){
        int max = -1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] != 1 && check[i][j] == -1){
                   return -1;
                }

                if(check[i][j] > max) {
                    max = check[i][j];
                }
            }
        }

        return max;
    }
    static int bfs(int[] ans){
        Queue<Pair18> q = new LinkedList<>();
        int[][] check = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                check[i][j] = -1;
            }
        }

        for(int i=0; i<m; i++){
            Pair18 p = location[ans[i]];
            q.add(new Pair18(p.x, p.y));
            check[p.x][p.y] = 0;
        }

        while (!q.isEmpty()){
            Pair18 p = q.remove();
            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(map[nx][ny] == 1) continue;
                if(check[nx][ny] != -1) continue;
                check[nx][ny] = check[p.x][p.y]+1;
                q.add(new Pair18(nx, ny));
            }
        }

        return getTime(check);
    }
    static int chooseLocation(int index, int start, int end, int[] ans){
        int min = -1;
        if(index == m){
            return bfs(ans);
        }
        for(int i=start; i<end; i++){
            ans[index] = i;
            int res = chooseLocation(index+1, i+1, end, ans);
            if(res > -1){
                if(min == -1 || res < min){
                    min = res;
                }
            }
        }

        return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        int index = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 2) location[index++] = new Pair18(i,j);
            }
        }

        int[] ans = new int[m];
        int min = chooseLocation(0,0, index, ans);
        System.out.println(min);
    }
}
