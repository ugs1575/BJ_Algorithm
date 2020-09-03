package bruteforce.recursion;

import java.util.Scanner;

public class Nqueen_9663 {
    static int n;
    static boolean[][] check;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        check = new boolean[n][n];

        int ans = go(0);

        System.out.println(ans);
    }

    public static int go(int row){
        int ans = 0;
        if(row == n){
            return 1;
        }

        for(int col=0; col<n; col++){
            if(canPut(row, col)){
                check[row][col] = true;
                ans += go(row+1);
                check[row][col] = false;
            }
        }

        return ans;
    }

    public static boolean canPut(int row, int col){
        // |체크
        for(int i=0; i<n; i++){
            if(i == row) continue;
            if(check[i][col]){
                return false;
            }
        }

        //왼쪽 위 대각선 (\) 체크
        int x = row-1;
        int y = col-1;
        while (x>=0 && y>=0){
            if(check[x][y]){
                return false;
            }
            x -= 1;
            y -= 1;
        }

        // 오른쪽 위 대각선(/) 체크
        x = row-1;
        y = col+1;
        while(x>=0 && y<n){
            if(check[x][y]){
                return false;
            }
            x -= 1;
            y += 1;
        }
        return true;
    }
}
