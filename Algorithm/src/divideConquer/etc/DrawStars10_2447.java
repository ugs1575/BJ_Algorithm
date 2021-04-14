package divideConquer.etc;

import java.util.Scanner;

public class DrawStars10_2447 {
    static char STAR = '*';
    static char BLANK = ' ';
    public static void go(char[][] a, int x, int y, int n, char color){
        if(color == BLANK){
            for(int i=x; i<x+n; i++){
                for(int j=y; j<y+n; j++){
                    a[i][j] = BLANK;
                }
            }
        }else{
            if(n == 1){
                a[x][y] = STAR;
            }else{
                char newColor = STAR;
                int m = n/3;
                for(int i=0; i<3; i++){
                    for(int j=0; j<3; j++){
                        if(i == 1 && j == 1){
                            newColor = BLANK;
                        }else{
                            newColor = STAR;
                        }
                        go(a, x+i*m, y+j*m, m, newColor);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] a = new char[n][n];

        go(a, 0, 0, n, STAR);

        for (int i=0; i<n; i++) {
            System.out.println(String.valueOf(a[i]));
        }
    }
}
