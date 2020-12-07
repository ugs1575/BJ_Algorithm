package graph;

import java.util.*;

class Pair17{
    int x, y;
    Pair17(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Castle_2234 {
    static int n, m;
    static int[][] map, group;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static int bfs(int x, int y, int group_num){
        int size = 1;
        Queue<Pair17> q = new LinkedList<>();
        q.add(new Pair17(x, y));
        group[x][y] = group_num;
        while (!q.isEmpty()){
            Pair17 p = q.remove();
            for(int i=0; i<4; i++){
                if((map[p.x][p.y]&(1<<i)) == 0){
                    int nx = p.x+dx[i];
                    int ny = p.y+dy[i];
                    if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    if(group[nx][ny] > 0) continue;
                    size += 1;
                    group[nx][ny] = group_num;
                    q.add(new Pair17(nx, ny));
                }

            }
        }

        return size;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[m][n];
        group = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        //그룹짓기
        ArrayList<Integer> room_size = new ArrayList<>();
        room_size.add(0);
        int max_size = 0;
        int group_num = 1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(group[i][j] == 0){
                    int size = bfs(i, j, group_num);
                    if(size > max_size) max_size = size;
                    room_size.add(size);
                    group_num += 1;
                }
            }
        }


        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int cur_group = group[i][j];
                int max = 0;
                for(int d=0; d<4; d++){
                    if((map[i][j]&(1<<d)) > 0){
                        int nx = i+dx[d];
                        int ny = j+dy[d];
                        if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                        if(group[nx][ny] != cur_group){
                            int merge = room_size.get(cur_group)+room_size.get(group[nx][ny]);
                            if(merge > max) max = merge;
                        }
                    }

                }

                if(max > ans) ans = max;
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(group[i][j]+" ");
            }
            System.out.println();
        }



        System.out.println(group_num-1);
        System.out.println(max_size);
        System.out.println(ans);



    }
}
