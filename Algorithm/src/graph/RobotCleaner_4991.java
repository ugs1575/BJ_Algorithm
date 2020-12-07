package graph;

import java.io.*;
import java.util.*;

class Pair15{
    int x, y;
    Pair15(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class RobotCleaner_4991 {
    static int w, h;
    static char[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int visitOrder(int[][] distance, int[] order, boolean[] check, int index){
        int ans = Integer.MAX_VALUE;
        if(index == order.length){
            int sum = 0;
            for(int i=0; i<order.length-1; i++){
                //System.out.println("from "+i+"to"+(i+1)+"+ "+distance[i][i+1]);
                sum += distance[order[i]][order[i+1]];
            }
            /*for(int i:order){
                System.out.print(i+" ");
            }*/
            //System.out.println("sum"+sum);

            return sum;
        }
        for(int i=1; i<order.length; i++){
            if(check[i]) continue;
            order[index] = i;
            check[i] = true;
            int res = visitOrder(distance, order, check, index+1);
            if(res < ans) ans = res;
            check[i] = false;
        }

        return ans;
    }
    static void bfs(int x, int y, int[][] visit){
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                visit[i][j] = -1;
            }
        }

        Queue<Pair15> q = new LinkedList<>();
        q.add(new Pair15(x, y));
        visit[x][y] = 0;
        while (!q.isEmpty()){
            Pair15 p = q.remove();
            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if(map[nx][ny] == 'x') continue;
                if(visit[nx][ny] != -1) continue;
                visit[nx][ny] = visit[p.x][p.y]+1;
                q.add(new Pair15(nx, ny));
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        w = Integer.parseInt(s[0]);
        h = Integer.parseInt(s[1]);
        while (w != 0 && h != 0){
            int index = 1;
            Pair15[] dirty = new Pair15[11];
            int[][] distance = new int[11][11];
            map = new char[h][w];
            for(int i=0; i<h; i++){
                String input = br.readLine();
                for(int j=0; j<w; j++){
                    map[i][j] = input.charAt(j);
                    if(map[i][j] == 'o') dirty[0] = new Pair15(i,j);
                    if(map[i][j] == '*') dirty[index++] = new Pair15(i,j);
                }
            }

            for(int i=0; i<index; i++){
                Pair15 p = dirty[i];
                int[][] visit = new int[h][w];
                bfs(p.x, p.y, visit);
                for(int j=i+1; j<index; j++){
                    Pair15 np = dirty[j];
                    distance[i][j] = visit[np.x][np.y];
                    distance[j][i] = visit[np.x][np.y];
                }
            }

            /*for(int i=0; i<index; i++){
                for(int j=i+1; j<index; j++){
                    System.out.println("from "+i+"to "+j+" takes"+distance[i][j]);
                }
            }*/

            boolean ok = true;
            for(int i=0; i<index; i++){
                boolean go = false;
                for(int j=0; j<index; j++){
                    if(i==j) continue;
                    if(distance[i][j] != -1) go = true;
                }

                if(!go){
                    ok = false;
                    break;
                }
            }

            if(ok){
                int[] order = new int[index];
                boolean[] check = new boolean[index];
                check[0] = true;
                System.out.println(visitOrder(distance, order, check, 1));
            }else{
                System.out.println(-1);
            }

            s = br.readLine().split(" ");
            w = Integer.parseInt(s[0]);
            h = Integer.parseInt(s[1]);
        }

    }
}
