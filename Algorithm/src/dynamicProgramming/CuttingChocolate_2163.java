package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class CuttingChocolate_2163 {
    static int[][] d = new int[301][301];
    static int go(int x, int y){
        if(x == 1 && y == 1) return 0;
        if(d[x][y] != -1) return d[x][y];
        for(int k=1; k<y; k++){
            if(d[x][y] == -1){
                d[x][y] = go(x,y-k) + go(x, k) + 1;
            }else{
                d[x][y] = Math.min(d[x][y], go(x,y-k) + go(x, k) + 1);
            }
        }
        for(int k=1; k<x; k++){
            if(d[x][y] == -1){
                d[x][y] = go(x-k, y) + go(k, y) + 1;
            }else{
                d[x][y] = Math.min(d[x][y], go(x-k, y) + go(k, y) + 1);
            }
        }

        return d[x][y];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i=0; i<301; i++){
            Arrays.fill(d[i], -1);
        }
        System.out.println(go(n, m));
    }
}
