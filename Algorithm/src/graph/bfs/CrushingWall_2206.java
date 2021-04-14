package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
보통은 정형화 되어있기 때문에 정점의 정의를 생각할 필요가 없다
빈칸 -> 빈칸 (갈수 있음)
빈칸 -> 벽 (한번도 벽을 부시지 않았을 경우에만 갈 수 있다)
정점의 정의에서 가장 중요한 것은 어떤 하나의 점에서 할수있는 것은 항상 같아야한다.
이럴때는 되고 저럴때는 된다 -> 같은 정점이라 보면 안된다. 다른 정점이라고 해야한다.
정점을 분리시켜줘야한다 -> 하나의 정점이 할수있는 행동이 다른 요인에 의해 바뀌었을 때
이 문제에서 요인은 벽을 한번 부수고 지나갈 수 있다 이다.
그래서 필요한 것은 (행, 열, 벽을 부순 횟수)
(r,c,0) -> 빈칸(o)   (r,c,1) -> 벽(x)
        -> 벽(x)            -> 빈칸(o)
벽을 부신경우 , 안부신경우 두가지를 생각해야함 -> 3차원 배열 사
*/
class Pair6{
    int x, y, z;
    Pair6(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class CrushingWall_2206 {
    static int n, m;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        int[][] map = new int[n][m];
        int[][][] d = new int[n][m][2];

        for(int i=0; i<n; i++){
            String str = sc.nextLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        d[0][0][0] = 1;
        Queue<Pair6> q = new LinkedList<Pair6>();
        q.add(new Pair6(0,0,0));
        while (!q.isEmpty()){
            Pair6 p = q.remove();
            int x = p.x;
            int y = p.y;
            int z = p.z;
            for(int k=0; k<4; k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(nx < 0 || nx >= n || ny < 0 || ny >=m) continue;
                //다음 방문할 칸이 빈칸이고 방문 안했을 때
                if(map[nx][ny] == 0 && d[nx][ny][z] == 0){
                    d[nx][ny][z] = d[x][y][z] + 1;
                    q.offer(new Pair6(nx, ny, z));
                }
                //다음 방문할 칸이 벽이고 벽을 한번도 안부신경우,
                if(z == 0 && map[nx][ny] == 1 && d[nx][ny][z+1] == 0){
                    d[nx][ny][z+1] = d[x][y][z] + 1;
                    q.add(new Pair6(nx, ny, z+1));
                }
            }
        }

        if(d[n-1][m-1][0] != 0 && d[n-1][m-1][1] !=0){
            System.out.println(Math.min(d[n-1][m-1][0], d[n-1][m-1][1]));
        }else if(d[n-1][m-1][0] != 0){
            System.out.println(d[n-1][m-1][0]);
        }else if(d[n-1][m-1][1] != 0){
            System.out.println(d[n-1][m-1][1]);
        }else{
            System.out.println(-1);
        }

    }

}
