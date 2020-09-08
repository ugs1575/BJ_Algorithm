package bruteforce.recursion;

import java.util.Scanner;

public class Sdoku_2580 {
    public static final int n = 9;
    public static int square(int x, int y){
            /*
            일반적으로 그 칸이 몇번째인지 구하려면, 9x9 일때 x*9 + y로 구하면 되는데
            작은 사각형은
            행과 열이 0 1 2 라고 생각하면 각각 3으로 나눠 주면된다.
            */

        return (x/3)*3+(y/3);
    }
    public static boolean go(int[][] a, boolean[][][] c, int z){
        if(z == 81){ //마지막 81번째 칸
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(a[i][j]+" ");
                }
                System.out.println();
            }
            return true;
        }


        /*
            일반적으로 그 칸이 몇번째인지 구하려면, 9x9 일때 x*9 + y로 구하면 된다
        */
        int x = z/n;
        int y = z%n;
        if(a[x][y] != 0){
            return go(a, c, z+1);
        }else{
            for(int i=1; i<=9; i++){
                //숫자가 해당 열, 행, 사각형에 존재하지 않을 경우
                if(!c[0][x][i] && !c[1][y][i] && !c[2][square(x, y)][i]){
                    c[0][x][i] = c[1][y][i] = c[2][square(x, y)][i] = true;
                    a[x][y] = i;
                    if(go(a, c, z+1)){
                        return true;
                    }
                    a[x][y] = 0;
                    c[0][x][i] = c[1][y][i] = c[2][square(x,y)][i] = false;
                }
            }
        }

        return false;
    }

    public static void main(String main[]){
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[n][n];
        boolean[][][] c = new boolean[3][n][10];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a[i][j] = sc.nextInt();
                if(a[i][j] != 0){
                    c[0][i][a[i][j]] = true; //i번째 행에 a[i][j]이 존재한다
                    c[1][j][a[i][j]] = true; //i번째 열에 a[i][j]이 존재한다
                    c[2][square(i, j)][a[i][j]] = true; //i번째 사각형에 a[i][j]이 존재한다
                }
            }
        }
        go(a, c, 0);

    }
}
