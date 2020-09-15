package graph;
/*
*
.......    -1 -1 -1 -1 -1 -1 -1
......C    -1 -1 -1 -1 -1 -1 -1
......*    -1 -1 -1 -1 -1 -1 -1
*****.*    -1 -1 -1 -1 -1 -1 -1
....*..    -1  1 -1 -1 -1 -1 -1
....*..    -1  1 -1 -1 -1 -1 -1
.C..*..     1  0  1  1 -1 -1 -1
.......    -1  1 -1 -1 -1 -1 -1
*
*한번에 한칸 간다고 생각하지 말고 한번에 갈 수 있는 곳만큼 가야한다고 생각해야함
* 그래서 선분이 제일 적은 것이 답이다
*
* */
import java.util.*;

class Pair12{
    int first;
    int second;
    Pair12(int first, int second){
        this.first = first;
        this.second = second;
    }
}
public class Lazer_6087 {
    final static int[] dx = {0,0,1,-1};
    final static int[] dy = {1,-1,0,0};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        String[] a = new String[h];
        int sx, sy, ex, ey;
        sx=sy=ex=ey=-1;
        for(int i=0; i<h; i++){
            a[i] = sc.next();
            for(int j=0; j<w; j++){
                if(a[i].charAt(j) == 'C'){
                    if(sx == -1){
                        sx = i;
                        sy = j;
                    }else{
                        ex = i;
                        ey =j;
                    }
                }
            }
        }
        int[][] d = new int[h][w];
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                d[i][j] = -1;
            }
        }
        Queue<Pair12> q = new LinkedList<Pair12>();
        q.add(new Pair12(sx, sy));
        d[sx][sy] = 0;
        while (!q.isEmpty()){
            Pair12 p = q.remove();
            int x = p.first;
            int y = p.second;
            for(int k=0; k<4; k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                //벽에 부딪힐때까지 한방향으로 쭉
                while (0 <= nx && nx < h && 0 <= ny && ny < w){
                    if(a[nx].charAt(ny) == '*') break;
                    if(d[nx][ny] == -1){
                        d[nx][ny] = d[x][y]+1;
                        q.add(new Pair12(nx, ny));
                    }
                    nx += dx[k];
                    ny += dy[k];
                }
            }
        }
        System.out.println(d[ex][ey]-1);
    }
}
