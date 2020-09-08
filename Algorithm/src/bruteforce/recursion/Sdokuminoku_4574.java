package bruteforce.recursion;

import java.util.Scanner;

public class Sdokuminoku_4574 {
    static boolean[][] d;
    static boolean[][][] c;
    static int[][] p;
    static final int[] dx = {0, 1}; //가로 세로 놓기
    static final int[] dy = {1, 0};

    public  static boolean isOut(int x, int y){
        return x < 0 || x >= 9 || y < 0 || y >= 9;
    }
    static boolean can(int x, int y, int num){
        return c[0][x][num] == false && c[1][y][num] == false && c[2][square(x,y)][num] == false;
    }
    static int square(int x, int y){
        return (x/3)*3+(y/3);
    }
    static void visit(int x, int y, int num, boolean what){
        c[0][x][num] = what;
        c[1][y][num] = what;
        c[2][square(x,y)][num] = what;
    }
    public static boolean go(int z){
        if(z == 81){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(p[i][j]);
                }
                System.out.println();
            }
            return true;
        }

        int x = z/9;
        int y = z%9;
        if(p[x][y] != 0){
            return go(z+1);
        }else{
            for(int k=0; k<2; k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(isOut(nx, ny)){
                    continue;
                }
                if(p[nx][ny] != 0) continue;
                for(int i=1; i<=9; i++){
                    for(int j=1; j<=9; j++){
                        if(i == j) continue;
                        if(d[i][j]) continue;
                        if(can(x,y,i) && can(nx,ny,j)){
                            visit(x,y,i,true);
                            visit(nx,ny,j,true);
                            d[i][j] = d[j][i] = true;
                            p[x][y] = i;
                            p[nx][ny] = j;
                            if(go(z+1)){
                                return true;
                            }
                            visit(x,y,i,false);
                            visit(nx,ny,j,false);
                            d[i][j] = d[j][i] = false;
                            p[x][y] = 0;
                            p[nx][ny] = 0;
                        }
                    }
                }
            }
        }

        return false;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int order = 0;
        p = new int[9][9];
        c = new boolean[3][9][10];
        d = new boolean[10][10];

        int n = sc.nextInt();
        while(n != 0){
            order++;
            p = new int[9][9];
            c = new boolean[3][9][10];
            d = new boolean[10][10];
            //도미노
            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                String location = sc.next();
                int row = location.charAt(0)-65;
                int col = Character.getNumericValue(location.charAt(1))-1;
                p[row][col] = num;
                visit(row, col, num, true);

                int num2 = sc.nextInt();
                String location2 = sc.next();
                int row2 = location2.charAt(0)-65;
                int col2 = Character.getNumericValue(location2.charAt(1))-1;
                p[row2][col2] = num2;
                visit(row2, col2, num2, true);

                d[num][num2] = d[num2][num] =true;
            }

            //숫자
            for(int i=1; i<=9; i++){
                String location = sc.next();
                int row = location.charAt(0)-65;
                int col = Character.getNumericValue(location.charAt(1))-1;
                p[row][col] = i;
                visit(row, col, i, true);
            }
            System.out.println("Puzzle "+order);
           /* for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(p[i][j]);
                }
                System.out.println();
            }*/
            go(0);

            n = sc.nextInt();
        }


    }

}
