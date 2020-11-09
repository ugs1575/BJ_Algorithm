package bruteforce;

import java.util.Scanner;

class Pair11{
    int x, y;
    Pair11(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Teleport3_12908 {
    static long[] sTot, tToe;
    static long[][] tTot;
    static long go(int index, int[] ans, boolean[] check, int max){
        long min = -1;
        if(index == max){
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
            long time = sTot[ans[0]]+tToe[ans[max-1]]+max*10;
            for(int i=0; i<max-1; i++){
                if(tTot[ans[i]][ans[i+1]] == -1){
                    return -1;
                }
                time += tTot[ans[i]][ans[i+1]];
            }
            System.out.println("time"+time);

            return time;
        }

        for(int i=0; i<6; i++){
            if(check[i]) continue;
            check[i] = true;
            ans[index] = i;
            long res = go(index+1, ans, check, max);
            check[i] = false;
            if(res > 0){
                if(min == -1 || res < min){
                    min = res;
                }
            }

        }

        return min;
    }
    static long getDistance(int x1, int x2, int y1, int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        int ex = sc.nextInt();
        int ey = sc.nextInt();

        Pair11[] ts = new Pair11[6];
        Pair11[] te = new Pair11[6];
        int index = 5;
        for(int i=0; i<3; i++){
            int tsx = sc.nextInt();
            int tsy = sc.nextInt();
            int tex = sc.nextInt();
            int tey = sc.nextInt();
            ts[i] = new Pair11(tsx, tsy);
            te[i] = new Pair11(tex, tey);
            ts[index] = new Pair11(tex, tey);
            te[index--] = new Pair11(tsx, tsy);
        }

        sTot = new long[6];
        for(int i=0; i<6; i++){
            sTot[i] = getDistance(sx, ts[i].x, sy, ts[i].y);
        }
        tToe = new long[6];
        for(int i=0; i<6; i++){
            tToe[i] = getDistance(te[i].x, ex, te[i].y, ey);
        }
        tTot = new long[6][6];
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                if(i==j) continue;
                if(i+j == 5) tTot[i][j] = -1;
                else tTot[i][j] = getDistance(te[i].x, ts[j].x, te[i].y, ts[j].y);
            }
        }

        long min = getDistance(sx, ex, sy, ey);
        for(int i=1; i<=3; i++){
            boolean[] check = new boolean[6];
            int[] ans = new int[i];
            long res = go(0, ans, check, i);
            if(res > 0){
                if(res < min) min = res;
            }

        }

        System.out.println(min);
    }
}
