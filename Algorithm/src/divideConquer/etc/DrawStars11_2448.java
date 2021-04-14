package divideConquer.etc;

import java.util.Arrays;
import java.util.Scanner;

public class DrawStars11_2448 {
    public static void go(char[][] a, int x, int y, int n){
        if(n == 3){
            a[x][y] = a[x+1][y-1] = a[x+1][y+1] = '*';
            a[x+2][y-2] = a[x+2][y-1] = a[x+2][y] = a[x+2][y+1] = a[x+2][y+2] = '*';
            return;
        }

        go(a, x, y, n/2);
        go(a, x+n/2, y-n/2, n/2);
        go(a, x+n/2, y+n/2, n/2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] a = new char[n][2*n-1];
        for(int i=0; i<n; i++){
            for(int j=0; j<2*n-1; j++){
                a[i][j] = ' ';
            }
        }

        go(a,0,n-1,n);
        for(int i=0; i<n; i++){
            System.out.println(String.valueOf(a[i]));
        }
    }
}
