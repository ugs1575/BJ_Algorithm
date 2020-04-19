import java.util.*;

public class TwoDots_16929 {
    static int n, m;
    static int[][] dist;
    static boolean[][] check;
    static char[][] game;
    static int[] ax = {-1, 0, 1, 0};
    static int[] ay = {0, 1, 0, -1};
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        game = new char[n][m];
        check = new boolean[n][m];

        for(int i=0; i<n; i++){
            String line = sc.nextLine();
            for(int j=0; j<m; j++){
                game[i][j] = line.charAt(j);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!check[i][j]){
                    dist = new int[n][m];
                    boolean ans = dfs(i, j, 1, game[i][j]);
                    if(ans){
                        System.out.println("Yes");
                        System.exit(0);
                    }
                }
            }
        }

        System.out.println("No");

    }

    public static boolean dfs(int x, int y, int cnt, char color){
        if(check[x][y]){
            if(cnt-dist[x][y] >= 4){
                return true;
            }else{
                return false;
            }
        }
        check[x][y] = true;
        dist[x][y] = cnt;
        System.out.print(x+"/"+y+"\n");
        for(int i=0; i<4; i++){
            int nextX = x + ax[i];
            int nextY = y + ay[i];
            if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m){
                if(game[nextX][nextY] == color){
                    if(dfs(nextX, nextY, cnt+1, color)){
                        return true;
                    }
                }

            }
        }

        return false;
    }

}
