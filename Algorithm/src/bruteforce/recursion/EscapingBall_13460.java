package bruteforce.recursion;

import java.util.Scanner;

class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class EscapingBall_13460 {
    static int[] dx = {0,1,-1,0};
    static int[] dy = {1,0,0,-1};
    static int n, m = 0;
    static char[][] a;
    static int go(Pair blue, Pair red, int move, int direction){
        int ans = -1;
        if(move > 10){
            return -1;
        }

        int red_x = red.x;
        int red_y = red.y;
        int blue_x = blue.x;
        int blue_y = blue.y;
        int cnt_red = 0;
        int cnt_blue = 0;
        boolean red_exit = false;
        boolean blue_exit = false;
        while (a[red_x][red_y] != '#'){
            red_x += dx[direction];
            red_y += dy[direction];
            cnt_red++;
            if(a[red_x][red_y] == 'O'){
                red_exit = true;
                break;
            }
        }

        while (a[blue_x][blue_y] != '#'){
            blue_x += dx[direction];
            blue_y += dy[direction];
            cnt_blue++;
            if(a[blue_x][blue_y]== 'O'){
                blue_exit = true;
                break;
            }
        }

        //System.out.println("direction : "+direction+" / move : "+move+" / red : "+red_x+","+red_y+","+cnt_red+","+red_exit+" / blue : "+blue_x+","+blue_y+","+cnt_blue+","+blue_exit);

        if(blue_exit) return -1;
        if(red_exit){
            return move;
        }else{
            red_x -= dx[direction];
            red_y -= dy[direction];
            blue_x -= dx[direction];
            blue_y -= dy[direction];
            if(red_x == blue_x && red_y == blue_y){
                if(cnt_blue > cnt_red){
                    blue_x -= dx[direction];
                    blue_y -= dy[direction];
                }else{
                    red_x -= dx[direction];
                    red_y -= dy[direction];
                }
                //System.out.println("red : "+red_x+","+red_y+" / blue : "+blue_x+","+blue_y);
            }

            for(int i=0; i<4; i++){
                if(i != direction && i != 3-direction){
                    int res = go(new Pair(blue_x, blue_y), new Pair(red_x, red_y), move+1, i);
                    if(res != -1){
                        if(ans == -1){
                            ans = res;
                        }else{
                            ans = Math.min(ans, res);
                        }
                    }
                }
            }

        }

        return ans;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        sc.nextLine();

        Pair red = new Pair(0,0);
        Pair blue = new Pair(0,0);

        for(int i=0; i<n; i++){
            String s = sc.nextLine();
            for(int j=0; j<m; j++){
                a[i][j] = s.charAt(j);
                if(a[i][j] == 'B'){
                    a[i][j] = '.';
                    blue = new Pair(i,j);
                }
                if(a[i][j] == 'R'){
                    a[i][j] = '.';
                    red = new Pair(i,j);
                }

            }
        }

        int ans = -1;
        for(int i=0; i<4; i++){
            int res = go(blue, red, 1, i);
            if(res != -1){
                if(ans == -1){
                    ans = res;
                }else{
                    ans = Math.min(ans, res);
                }
            }
        }

        System.out.println(ans);
    }

}
