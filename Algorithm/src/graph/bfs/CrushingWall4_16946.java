package graph.bfs;

/*
* 이동할 수 있는 빈칸을 모두 그룹짓고 몇개의 칸으로 이루어져 있는지 계산해보자
* 11001      **11*
* 00011      111**
* 01010      1*1*2
* 10101      *3*3*
* 00000      33333
*
* 그룹 1의 크기 : 7
* 그룹 2의 크기 : 1
* 그룹 3의 크기 : 7
*
* 예를 들어 0,0 근처에 있는 빈 칸의 그룹은 1이다. 따라서 정답 = 1+7=8
* 2,3 근처에 있는 빈 칸의 그룹은 1,2,3이다. 따라서 정답 = 1+7+1+7=16
* 2,1 근처에 있는 빈 칸의 그룹은 1,1,1,3이다. 중복된 그룹은 여러번 세지 않는다 -> hashset 사용
* 따라서 정답 = 1+7+7=15
* */
import java.util.*;

public class CrushingWall4_16946 {
    static int n, m;
    static int[][] a, group;
    static boolean[][] check;
    static ArrayList<Integer> group_size = new ArrayList<>();
    final static int[] dx = {0,0,1,-1};
    final static int[] dy = {1,-1,0,0};

    //그룹짓
    static void bfs(int sx, int sy){
        int g = group_size.size();
        Queue<Integer> q = new LinkedList<>();
        q.add(sx);
        q.add(sy);
        check[sx][sy] = true;
        group[sx][sy] = g;
        int cnt = 1;
        while (!q.isEmpty()){
            int x = q.remove();
            int y = q.remove();
            for(int k=0; k<4; k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(0 <= nx && nx < n && 0 <= ny && ny < m){
                    if(a[nx][ny] == 0 && !check[nx][ny]){
                        q.add(nx);
                        q.add(ny);
                        check[nx][ny] = true;
                        group[nx][ny] = g;
                        cnt += 1;
                    }
                }
            }
        }
        group_size.add(cnt);
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        check = new boolean[n][m];
        group = new int[n][m];
        for(int i=0; i<n; i++){
            String s = sc.next();
            for(int j=0; j<m; j++){
                a[i][j] = s.charAt(j)-'0';
                check[i][j] = false;
                group[i][j] = -1;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i][j] == 0 && !check[i][j]){
                    bfs(i, j);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i][j] == 0){
                    System.out.print(0);
                }else{
                    HashSet<Integer> near = new HashSet<>();
                    for(int k=0; k<4; k++){
                        int x = i+dx[k];
                        int y = j+dy[k];
                        if(0<=x && x<n && 0<=y && y<m){
                            if(a[x][y] == 0){
                                near.add(group[x][y]);
                            }
                        }
                    }
                    int ans = 1;
                    for(int g : near){
                        ans += group_size.get(g);
                    }
                    System.out.print(ans%10);
                }
            }
            System.out.println();
        }



    }
}
