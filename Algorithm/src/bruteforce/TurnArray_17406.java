package bruteforce;

import java.util.Scanner;

class Pair4{
    int r, c, s;
    Pair4(int r, int c, int s){
        this.r = r;
        this.c = c;
        this.s = s;
    }
}
public class TurnArray_17406 {
    static int[] dx = {0,1,0,-1}; //우 하 좌
    static int[] dy = {1,0,-1,0};
    static int n, m, k;
    static int[][] a;
    static Pair4[] oper;
    static int calc(int[][] b){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=0; j<m; j++){
                sum += b[i][j];
            }
            min = Math.min(sum, min);
        }

        return min;
    }
    static void change(int[][] b, int x, int y, int t){
        int nx = x;
        int ny = y;
        for(int i=0; i<4; i++){
            for(int j=0; j<t; j++){
                int temp = b[x][y];
                nx += dx[i];
                ny += dy[i];
                b[x][y] = b[nx][ny];
                b[nx][ny] = temp;
            }
        }

    }
    static void turn(int[][] b, int x1, int y1, int x2, int y2){
        int row = x2-x1+1;
        int cnt = row/2;
        int t = row-1;
        x1 -= 1;
        y1 -= 1;
        x2 -= 1;
        y2 -= 1;

        while (cnt > 0){
            cnt -= 1;
            change(b, x1, y1, t);
            x1 += 1;
            y1 += 1;
            t -= 2;
        }
    }
    static int makeOrder(int[] order, boolean[] check, int index){
        int ans = -1;
        if(index == k){
            //배열복사
            int[][] b = new int[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    b[i][j] = a[i][j];
                }
            }
            //순서대로 돌리기
            for(int i=0; i<k; i++){
                Pair4 p = oper[order[i]];
                turn(b, p.r-p.s, p.c-p.s, p.r+p.s, p.c+p.s);
            }

            //배열 최솟값 구하기
            int res = calc(b);
            return res;
        }


        for(int i=0; i<k; i++){
            if(check[i]) continue;
            order[index] = i;
            check[i] = true;
            int res = makeOrder(order, check, index+1);
            if(ans == -1){
                ans = res;
            }else{
                ans = Math.min(ans, res);
            }
            check[i] = false;
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        a = new int[n][m];
        oper = new Pair4[k];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                a[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<k; i++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            int s = sc.nextInt();
            oper[i] = new Pair4(r, c, s);
        }

        int[] order = new int[k];
        boolean[] check = new boolean[k];
        System.out.println(makeOrder(order, check, 0));
    }
}
