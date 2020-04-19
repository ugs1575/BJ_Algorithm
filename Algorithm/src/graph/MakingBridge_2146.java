import java.util.*;

class Pair2{
    int x;
    int y;
    Pair2(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class MakingBridge_2146 {
    static int[][] map;
    static int[][] check;
    static int[][] distance;
    static int n;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new int[n][n];
        check = new int[n][n];
        distance = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }


        //그룹짓기
        int groupNum = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && check[i][j] == 0){
                    groupNum++;
                    bfs(i, j, groupNum);
                }
            }
        }

        int shortBridge = 0;

        while(groupNum > 0){
            Queue<Pair2> q2 = new LinkedList<Pair2>();

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    distance[i][j] = -1;
                    if(check[i][j] == groupNum){
                        distance[i][j] = 0;
                        q2.add(new Pair2(i, j));
                    }
                }
            }
            bfs2(q2);

            int ans = -1;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j] == 1 && check[i][j] != groupNum){
                        if(ans == -1 || distance[i][j]-1 < ans){
                            ans = distance[i][j]-1;
                        }
                    }
                }
            }

            if(shortBridge == 0 || ans < shortBridge){
                shortBridge = ans;
            }

            groupNum--;
        }

        System.out.println(shortBridge);

    }

    public static void bfs2(Queue<Pair2> q2){
        while (!q2.isEmpty()){
            Pair2 p = q2.remove();
            int x = p.x;
            int y = p.y;
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                //지도 범위안에 있고
                if(0<=nx && nx<n && 0<=ny && ny<n){
                    //바다이고, 방문하지 않았을때
                    if(distance[nx][ny] == -1){
                        distance[nx][ny] = distance[x][y]+1;
                        q2.add(new Pair2(nx, ny));
                    }
                }

            }
        }

    }

    public static void bfs(int x, int y, int groupNum){
        Queue<Pair2> q = new LinkedList<Pair2>();
        check[x][y] = groupNum;
        q.add(new Pair2(x, y));

        while (!q.isEmpty()){
            Pair2 p = q.remove();
            x = p.x;
            y = p.y;
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0 <= nx && nx<n && 0<=ny && ny<n){
                    if(map[nx][ny] == 1 && check[nx][ny] == 0){
                        check[nx][ny] = groupNum;
                        q.add(new Pair2(nx, ny));
                    }
                }
            }

        }

    }


}
