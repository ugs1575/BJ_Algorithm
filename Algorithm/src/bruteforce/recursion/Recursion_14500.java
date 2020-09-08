package bruteforce.recursion;

import java.util.Scanner;

public class Recursion_14500 {
    static int n, m, max;
    static int[][] arr;
    static boolean[][] check;
    static int[] aX = {0,0,1,-1};
    static int[] aY = {1,-1,0,0};
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//세로
        m = sc.nextInt();//가로
        arr = new int[n][m];
        check = new boolean[n][m];
        max = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                go(i, j, 0, 0);
                if(i+2 < n){
                    int temp = arr[i][j] + arr[i+1][j] + arr[i+2][j];
                    if(j+1 < m){
                        int temp2 = temp + arr[i+1][j+1];
                        if(temp2 > max) max = temp2;
                    }
                    if(j-1 >= 0){
                        int temp2 = temp + arr[i+1][j-1];
                        if(temp2 > max) max = temp2;
                    }
                }

                if(j+2 < m){
                    int temp = arr[i][j] + arr[i][j+1] + arr[i][j+2];
                    if(i+1 < n){
                        int temp2 = temp + arr[i+1][j+1];
                        if(temp2 > max) max = temp2;
                    }
                    if(i-1 >= 0){
                        int temp2 = temp + arr[i-1][j+1];
                        if(temp2 > max) max = temp2;
                    }
                }
            }
        }

        System.out.println(max);


    }

    public static void go(int x, int y, int cnt, int sum){
        //base case
        if(cnt == 4){
            if(sum > max){
                max = sum;
            }
            return;
        }


        //범위에서 벗어나는 케이스
        if(x < 0 || x >= n || y < 0 || y >= m){
            return;
        }

        //방문했던곳은 방문하면 안됨
        if(check[x][y]) return;



        check[x][y] = true;
        for(int i=0; i<4; i++){
            go(x+aX[i], y+aY[i], cnt+1, sum+arr[x][y]);
        }
        check[x][y] = false;

    }
}
