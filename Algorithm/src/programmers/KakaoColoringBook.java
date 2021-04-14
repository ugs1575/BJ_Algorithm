package programmers;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class KakaoColoringBook {
    static boolean[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    int bfs(int m, int n, int[][] picture, int x, int y){
        Queue<Pair> q = new LinkedList<>();
        visit[x][y] = true;
        q.add(new Pair(x, y));
        int size = 1;

        while (!q.isEmpty()){
            Pair p = q.remove();

            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue; //범위 벗어나면
                if(picture[nx][ny] != picture[x][y]) continue; //컬러가 다르면
                if(visit[nx][ny]) continue; //방문했으면
                size += 1;
                q.add(new Pair(nx, ny));
                visit[nx][ny] = true;
            }

        }

        return size;
    }
    public int[] solution(int m, int n, int[][] picture) {
        visit = new boolean[m][n];
        int maxSizeOfOneArea = 0;
        int numberOfArea = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //방문 x, 색깔이 칠해져있는 곳
                if(!visit[i][j] && picture[i][j] != 0){
                    numberOfArea += 1;
                    int size = bfs(m, n, picture, i, j);
                    if(size > maxSizeOfOneArea) maxSizeOfOneArea = size;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        /*int[] answer = solution(m, n, picture);
        System.out.println(answer[0]);
        System.out.println(answer[1]);*/

    }
}
